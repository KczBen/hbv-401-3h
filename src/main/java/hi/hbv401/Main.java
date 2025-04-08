package hi.hbv401;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test stuff, javafx doesn't run this
        Database.initialize("sql/database.db");
        Database db = Database.getInstance();
        SearchParameters params = new SearchParameters(null, null, null, 10, 1, null, null, null, null, "Demotown");
        List<Hotel> hotels = db.searchHotels(params);
        System.out.println(db.getRoomBookings(1, 101).size());
        System.out.println(db.getUserDetails(2));
        System.out.println(hotels.get(0));
    }
}