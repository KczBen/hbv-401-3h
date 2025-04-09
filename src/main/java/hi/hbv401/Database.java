package hi.hbv401;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Database {
    private static Database instance;

    private final String dbUrl;

    private Database(String dbUrl) {
        this.dbUrl = "jdbc:sqlite:" + dbUrl;
    }

    public static void initialize(String dbUrl) {
        if (instance == null) {
            instance = new Database(dbUrl);
        } else {
            throw new IllegalStateException("Database already initialized");
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Database not initialized yet");
        }
        return instance;
    }

    /* Hotels - Search */
    public List<Hotel> searchHotels(SearchParameters params) {
        StringBuilder sql = new StringBuilder("""
            SELECT h.hotel_id,r.room_number
            FROM hotels AS h
                LEFT JOIN rooms AS r ON h.hotel_id = r.hotel_id

                WHERE 1=1 
            """);
        List<Object> sqlParams = new ArrayList<>();

        // price
        if (params.priceMin != null) {
            sql.append("AND price >= ? ");
            sqlParams.add(params.priceMin);
        }
        if (params.priceMax != null) {
            sql.append("AND price <= ? ");
            sqlParams.add(params.priceMax);
        }

        // rating
        if (params.ratingMin != null) {
            sql.append("AND rating >= ? ");
            sqlParams.add(params.ratingMin);
        }
        if (params.ratingMax != null) {
            sql.append("AND rating <= ? ");
            sqlParams.add(params.ratingMax);
        }

        // guests
        if (params.guestsMin != null) {
            sql.append("AND max_guests >= ? ");
            sqlParams.add(params.guestsMin);
        }
        if (params.guestsMax != null) {
            sql.append("AND max_guests <= ? ");
            sqlParams.add(params.guestsMax);
        }

        // city
        if (params.location != null) {
            sql.append("AND city = ? ");
            sqlParams.add(params.location);
        }

        // property type
        if (params.propertyTypes != null) {
            String placeholders = params.propertyTypes.stream()
                .map(type -> "?")
                .collect(Collectors.joining(", "));
                sql.append("AND r.type IN (" + placeholders + ") ");
            sqlParams.addAll(params.propertyTypes);
        }

        // availability
        if (params.availableFrom != null || params.availableUntil != null)
        {
            sql.append("""
                AND NOT EXISTS ( 
                    SELECT 1 FROM bookings AS b
                        WHERE b.hotel_id = r.hotel_id
                            AND b.room_number = r.room_number
                """);

            if (params.availableFrom != null) {
                sql.append("AND b.booked_until > ? ");
                if (params.availableUntil == null) {
                    sql.append(")");
                }
                sqlParams.add(params.availableFrom.format(DateTimeFormatter.ISO_DATE));
            }

            if (params.availableUntil != null) {
                sql.append("AND b.booked_from < ? )");
                sqlParams.add(params.availableUntil.format(DateTimeFormatter.ISO_DATE));
            }
        }

        try(Connection conn = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = conn.prepareStatement(sql.toString())){
            Class.forName("org.sqlite.JDBC");

            /* Dynamically build the query, since nothing is expected to be specified */
            // base statement, joins rooms and catches all by default
            
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            
            for (int i = 0; i < sqlParams.size(); i++) {
                pstmt.setObject(i + 1, sqlParams.get(i));
            }
                        
            ResultSet rs = pstmt.executeQuery();

            Map<Integer, Set<Integer>> hotelIdToRoomNumbers = new HashMap<>();

            while (rs.next()) {
                int hotelId = rs.getInt("hotel_id");
                int roomNumber = rs.getInt("room_number");

                hotelIdToRoomNumbers
                    .computeIfAbsent(hotelId, k -> new HashSet<>())
                    .add(roomNumber);
            }

            List<Hotel> hotelList = new ArrayList<>();

            for (Map.Entry<Integer, Set<Integer>> entry: hotelIdToRoomNumbers.entrySet()) {
                int hotelId = entry.getKey();
                List<Integer> roomNumbers = new ArrayList<>(entry.getValue());

                Hotel hotel = getHotelDetailsFiltered(hotelId, roomNumbers);
                hotelList.add(hotel);
            }

            return hotelList;
        }
        
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Hotel getHotelDetails(int hotel_id) {
        List<Integer> priceList = new ArrayList<Integer>();
        String sql = """
            SELECT *
                FROM rooms AS r
                WHERE r.hotel_id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");

            // get rooms first to make building the hotel easier

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotel_id);

            ResultSet rs = pstmt.executeQuery();
            
            List<Room> roomsList = new ArrayList<>(); 

            while (rs.next()) {
                Integer hotelId = rs.getInt("hotel_id");
                Integer roomNumber = rs.getInt("room_number");
                String type = rs.getString("type");
                Integer maxGuests = rs.getInt("max_guests");
                Integer price = rs.getInt("price");
                String amenities = rs.getString("amenities");

                // Add price to the array so we can get the min price later
                priceList.add(price);

                roomsList.add(new Room(hotelId, roomNumber, price, type, maxGuests, amenities));
            }

            sql = """
                SELECT *
                    FROM hotels AS h
                    WHERE h.hotel_id = ?
                """;

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hotel_id);
            rs = pstmt.executeQuery();

            int hotelId = 0;
            String name = "";
            float rating = 0;
            String short_description = "";
            List<String> photos = new ArrayList<>();
            int startingPrice = Collections.min(priceList);
            String cancelPolicy = "";
            String phone = "";
            String email = "";
            String city = "";
            String address = "";

            while (rs.next()) {
                hotelId = rs.getInt("hotel_id");
                name = rs.getString("name");
                rating = rs.getInt("rating");
                short_description = rs.getString("short_description");
                photos.add(rs.getString("index_photo"));
                city = rs.getString("city");
                address = rs.getString("address");
                cancelPolicy = rs.getString("cancellation_policy");
                phone = rs.getString("phone");
                email = rs.getString("email");
            }

            return new Hotel(hotelId, name, rating, short_description, photos, startingPrice, roomsList, cancelPolicy, phone, email, city, address);
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Hotel getHotelDetailsFiltered(int hotel_id, List<Integer> includedRooms) {
        List<Integer> priceList = new ArrayList<Integer>();
        String placeholders = includedRooms.stream()
            .map(rn -> "?")
            .collect(Collectors.joining(", "));

        String sql = """
            SELECT *
                FROM rooms AS r
                WHERE r.hotel_id = ?
                    AND r.room_number IN (""" + placeholders + ")";
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotel_id);
            for (int i = 0; i < includedRooms.size(); i++) {
                pstmt.setInt(i + 2, includedRooms.get(i));
            }

            ResultSet rs = pstmt.executeQuery();
            
            List<Room> roomsList = new ArrayList<>(); 

            while (rs.next()) {
                Integer hotelId = rs.getInt("hotel_id");
                Integer roomNumber = rs.getInt("room_number");
                String type = rs.getString("type");
                Integer maxGuests = rs.getInt("max_guests");
                Integer price = rs.getInt("price");
                String amenities = rs.getString("amenities");

                // Add price to the array so we can get the min price later
                priceList.add(price);

                roomsList.add(new Room(hotelId, roomNumber, price, type, maxGuests, amenities));
            }

            sql = """
                SELECT *
                    FROM hotels AS h
                    WHERE h.hotel_id = ?
                """;

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hotel_id);
            rs = pstmt.executeQuery();

            int hotelId = 0;
            String name = "";
            float rating = 0;
            String short_description = "";
            List<String> photos = new ArrayList<>();
            int startingPrice = Collections.min(priceList);
            String cancelPolicy = "";
            String phone = "";
            String email = "";
            String city = "";
            String address = "";

            while (rs.next()) {
                hotelId = rs.getInt("hotel_id");
                name = rs.getString("name");
                rating = rs.getInt("rating");
                short_description = rs.getString("short_description");
                photos.add(rs.getString("index_photo"));
                city = rs.getString("city");
                address = rs.getString("address");
                cancelPolicy = rs.getString("cancellation_policy");
                phone = rs.getString("phone");
                email = rs.getString("email");
            }

            
            return new Hotel(hotelId, name, rating, short_description, photos, startingPrice, roomsList, cancelPolicy, phone, email, city, address);
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /* Hotels - Types */
    public List<Integer> getPriceRange() {
        String sql = """
            SELECT MIN(price) AS min_price, MAX(price) as max_price FROM rooms
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            List<Integer> priceRange = new ArrayList<>();

            while (rs.next()) {
                int minPrice = rs.getInt("min_price");
                priceRange.add(minPrice);
                int maxPrice = rs.getInt("max_price");
                priceRange.add(maxPrice);
            }

            
            return priceRange;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<String> getLocations() {
        String sql = """
            SELECT city
            FROM hotels

            GROUP BY city
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            List<String> locations = new ArrayList<>();

            while (rs.next()) {
                locations.add(rs.getString("city"));
            }

            
            return locations;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<String> getRoomTypes() {
        String sql = """
            SELECT type
            FROM rooms

            GROUP BY type
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            List<String> types = new ArrayList<>();

            while (rs.next()) {
                types.add(rs.getString("type"));
            }
            
            
            return types;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /* Bookings */
    public List<Booking> getRoomBookings(int hotelId, int roomNumber) {
        // Select the given (hotel_id, roomNumber) key from the reservations table
        String sql = """
            SELECT * FROM
                bookings AS b
                WHERE
                    b.hotel_id = ?
                    AND
                    b.room_number = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotelId);
            pstmt.setInt(2, roomNumber);

            ResultSet rs = pstmt.executeQuery();
            
            // Make a list of bookings from the dates in the table and return it
            List<Booking> bookingList = new ArrayList<>(); 

            while (rs.next()) {
                int dbhotelId = rs.getInt("hotel_id");
                int dbroomNumber = rs.getInt("room_number");
                LocalDate bookedFrom = LocalDate.parse(rs.getString("booked_from"));
                LocalDate bookedUntil = LocalDate.parse(rs.getString("booked_from"));
                int userId = rs.getInt("user_id");

                bookingList.add(new Booking(bookedFrom, bookedUntil, userId, dbhotelId, dbroomNumber));
            }
            
            
            return bookingList;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Booking> getBookingForUser(int userId) {
        String sql = """
            SELECT * FROM
                bookings AS b
                WHERE
                    b.user_id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            
            // Make a list of bookings from the dates in the table and return it
            List<Booking> bookingList = new ArrayList<>(); 

            while (rs.next()) {
                LocalDate bookedFrom = LocalDate.parse(rs.getString("booked_from"));
                LocalDate bookedUntil = LocalDate.parse(rs.getString("booked_until"));
                int dbhotelId = rs.getInt("hotel_id");
                int dbroomNumber = rs.getInt("room_number");

                bookingList.add(new Booking(bookedFrom, bookedUntil, userId, dbhotelId, dbroomNumber));
            }
            
            
            return bookingList;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Booking> getBookingForUser(User user) {
        return getBookingForUser(user.getUserId());
    }

    public void makeBooking(Booking booking) {
        String sql = """
            INSERT INTO bookings (hotel_id, room_number, booked_from, booked_until, user_id)
                VALUES (?, ?, ?, ?, ?)
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, booking.getHotelId());
            pstmt.setInt(2, booking.getRoomNumber());
            pstmt.setString(3, booking.getBookedFrom().toString());
            pstmt.setString(4, booking.getBookedUntil().toString());
            pstmt.setInt(5, booking.getUser());

            pstmt.executeUpdate();
                        
            
        }

        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void cancelBooking(User user, int hotelId, int roomNumber) {
        String sql = """
            DELETE FROM
                bookings AS b
                WHERE
                    b.hotel_id = ?
                    AND
                    b.room_number = ?
                    AND
                    b.user_id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotelId);
            pstmt.setInt(2, roomNumber);
            pstmt.setInt(3, user.getUserId());

            pstmt.executeQuery();
                        
            
        }

        catch(Exception e) {
            System.err.println("Failed to delete booking");
        }
    }

    /* Users */
    public User getUserDetails(int userId) {
        String sql = """
            SELECT * FROM
                users AS u
                WHERE
                    u.id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            
            int id = 0;
            String name = null;
            String email = null;
            String phone = null;
            List<Booking> reservations = null;

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phone = rs.getString("phone");
                reservations = getBookingForUser(id);
            }
            
            
            return new User(id, name, email, phone, reservations);
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public User getUserDetails(String userEamil) {
        String sql = """
            SELECT * FROM
                users AS u
                WHERE
                    u.email = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userEamil);

            ResultSet rs = pstmt.executeQuery();
            
            int id = 0;
            String name = null;
            String email = null;
            String phone = null;
            List<Booking> reservations = null;

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phone = rs.getString("phone");
                reservations = getBookingForUser(id);
                return new User(id, name, email, phone, reservations);
            }
            
            
            return null;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Integer createUser(User user) {
        String sql = """
            INSERT INTO users (name, email, phone)
            VALUES (?, ?, ?)
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int userId = rs.getInt(1);
                
                return userId;
            }
            
            
            return null;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /* Reviews */
    public List<Review> getHotelReviews(int hotelId) {
        String sql = """
            SELECT * FROM
                reviews AS r
                WHERE
                    r.hotel_id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotelId);

            ResultSet rs = pstmt.executeQuery();
            
            List<Review> reviewList = new ArrayList<>();

            Hotel hotel = getHotelDetails(hotelId);
            
            while (rs.next()) {
                int rating = rs.getInt("rating");
                String comment = rs.getString("content");
                LocalDate createdAt = LocalDate.parse(rs.getString("date"));;
                User user = getUserDetails(rs.getInt("user_id"));

                reviewList.add(new Review(user, hotel, rating, comment, createdAt));
            }
            
            
            return reviewList;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Review> getHotelReviews(Hotel hotel) {
        return getHotelReviews(hotel.getHotelId());
    }

    public List<Review> getUserReviews(int userId) {
        String sql = """
            SELECT * FROM
                reviews AS r
                WHERE
                    r.user_id = ?
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            
            List<Review> reviewList = new ArrayList<>();

            Hotel hotel = getHotelDetails(userId);
            
            while (rs.next()) {
                int rating = rs.getInt("rating");
                String comment = rs.getString("content");
                LocalDate createdAt = LocalDate.parse(rs.getString("date"));;
                User user = getUserDetails(rs.getInt("user_id"));

                reviewList.add(new Review(user, hotel, rating, comment, createdAt));
            }
            
            
            return reviewList;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Review> getUserReviews(User user) {
        return getUserReviews(user.getUserId());
    }

    public void createReview(Review review) {
        String sql = """
            INSERT INTO reviews (user_id, hotel_id, rating, content, date)
            VALUES (?, ?, ?, ?, ?)
            """;
        try(Connection conn = DriverManager.getConnection(dbUrl);
         PreparedStatement stmt = conn.prepareStatement(sql)){
            Class.forName("org.sqlite.JDBC");


            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, review.getUser().getUserId());
            pstmt.setInt(2, review.getHotel().getHotelId());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getComment());
            pstmt.setString(5, review.getCreatedAt().toString());

            pstmt.executeUpdate();
                        
            
        }

        catch (Exception e) {
            System.err.println(e);
        }
    }
}
