package hi.hbv401;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Database {
    // SQL interface code

    private final String hotelsUrl;
    private final String roomsUrl;
    private final String availabilityUrl;

    public Database(String hotelsUrl, String roomsUrl, String availabilityUrl) {
        this.hotelsUrl = "jdbc:sqlite:" + hotelsUrl;
        this.roomsUrl = roomsUrl;
        this.availabilityUrl = availabilityUrl;
    }

    // Load SQL database

    /* Get a list of hotel IDs that match the requested parameters. Returns null if none exist */
    public List<Integer> searchHotels(SearchParameters params) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(hotelsUrl);
            Statement stmt = conn.createStatement();
            stmt.execute("ATTACH DATABASE '" + roomsUrl + "' AS rooms");
            stmt.execute("ATTACH DATABASE '" + availabilityUrl + "' AS bookings");

            /* Dnamically build the query, since nothing is expected to be specified */
            // base statement, joins rooms and catches all by default
            StringBuilder sql = new StringBuilder("""
                SELECT h.hotel_id 
                FROM hotels AS h
                    LEFT JOIN rooms.rooms AS r ON h.hotel_id = r.hotel_id

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

            // now here is where it gets fucky-wucky with the availability
            // we need to return a period where there is no overlap between the specified date and booked dates
            if (params.availableFrom != null || params.availableUntil != null)
            {
                sql.append("""
                    AND NOT EXISTS ( 
                        SELECT 1 FROM bookings.availability AS b
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

            sql.append("GROUP BY h.hotel_id");
            
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            
            for (int i = 0; i < sqlParams.size(); i++) {
                pstmt.setObject(i + 1, sqlParams.get(i));
            }
            
            // Debug: show the query template + args
            System.out.println(pstmt);
            
            ResultSet rs = pstmt.executeQuery();

            List<Integer> hotelIdList = new ArrayList<Integer>();

            while (rs.next()) {
                hotelIdList.add(rs.getInt("hotel_id"));
            }

            return hotelIdList;
        }
        
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /* Get details about a hotel */
    public Hotel getHotelDetails(int hotel_id) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(hotelsUrl);
            Statement stmt = conn.createStatement();
            stmt.execute("ATTACH DATABASE '" + roomsUrl + "' AS rooms");

            // get rooms first to make building the hotel easier
            String sql = """
                SELECT *
                    FROM rooms AS r
                    WHERE r.hotel_id = ?
                """;

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

                roomsList.add(new Room(hotelId, roomNumber, price, type, maxGuests));
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
            String longDescription = "";
            List<String> photos = new ArrayList<>();
            int price = 0;
            int propertyType = 0;
            String cancelPolicy = "";
            String phone = "";
            String email = "";
            String address = "";

            while (rs.next()) {
                hotelId = rs.getInt("hotel_id");
                name = rs.getString("name");
                rating = rs.getInt("rating");
                longDescription = rs.getString("description");
                cancelPolicy = rs.getString("cancellation_policy");
                phone = rs.getString("phone");
                email = rs.getString("email");
                // TODO: Min price, photos, address
                // TODO: Remove property type from hotel, it's a room property
            }

            return new Hotel(hotelId, name, rating, longDescription, photos, price, roomsList, propertyType, cancelPolicy, phone, email, address);
        }

        catch (Exception e) {
            return null;
        }
    }

    /* Gets the booked dates for the given room. It returns a list of from..to dates if the hotel is booked, null otherwise */
    public List<Booking> getRoomBookings(int hotelId, int roomNumber) {
        // Select the given (hotel_id, roomNumber) key from the reservations table
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(hotelsUrl);
            Statement stmt = conn.createStatement();
            stmt.execute("ATTACH DATABASE '" + availabilityUrl + "' AS bookings");

            String sql = """
                SELECT * FROM
                    availability AS b
                    WHERE
                        b.hotel_id = ?
                        AND
                        b.room_number = ?
                """;

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, hotelId);
            pstmt.setInt(2, roomNumber);

            ResultSet rs = pstmt.executeQuery();
            
            // Make a list of Availability from the dates in the table and return it
            List<Booking> bookingList = new ArrayList<>(); 

            while (rs.next()) {
                LocalDateTime bookedFrom = LocalDate.parse(rs.getString("booked_from")).atStartOfDay();
                LocalDateTime bookedUntil = LocalDate.parse(rs.getString("booked_from")).atStartOfDay();
                // TODO: String userEmail = rs.getString("email"); <- Not in data yet
                // java plz shadow it?
                int dbhotelId = rs.getInt("hotel_id");
                int dbroomNumber = rs.getInt("room_number");

                bookingList.add(new Booking(bookedFrom, bookedUntil, null, dbhotelId, dbroomNumber));
            }

            return bookingList;
        }

        catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Booking> getBookingForUser(String userEmail) {

        return null;
    }

    public void makeBooking(String userEmail, Room room) {

    }

    public void cancelBooking(String userEmail, int hotelId, int roomNumber) {

    }
}
