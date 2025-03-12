package hi.hbv401;

import java.sql.*;
import java.util.List;

public class Database {
    // SQL interface code

    private final String databaseUrl;

    public Database(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    // Load SQL database

    /* Get a list of hotel IDs that match the requested parameters. Returns null if none exist */
    public List<Integer> searchHotels(SearchParameters params) {
        // Join hotel and room tables on hotelID

        // Search by the parameters

        // Return a list of IDs

        return null;
    }

    /* Get details about a hotel */
    public Hotel getHotelDetails(int hotelID) {
        // Join the hotel and room tables on hotelID

        // Make a list of the rooms

        // Create a new Hotel and return it
        
        return null;
    }

    /* Gets the booked dates for the given room. It returns a list of from..to dates if the hotel is booked, null otherwise */
    public List<Availability> getRoomAvailabilities(int hotelID, int roomNumber) {
        // Select the given (hotelID, roomNumber) key from the reservations table

        // Make a list of Availability from the dates in the table and return it

        return null;
    }
}