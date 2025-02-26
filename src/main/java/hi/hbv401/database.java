package hi.hbv401;

public class database {
    // SQL interface code

    // Load SQL database

    public static /* returnType */ search(/* args */) {
        // Retrieve hotels based on criteria
        // Should probably an object called Filter or Criteria as its argument
        // Said object should probably look like this:
        /*
        * -- Ranges --
        * These are from..to, bound between two values, sliders
        * If a value is null, that means there is no bound in that direction
        * If both values are null, ignore it as a criteria
        * 
        * priceMin: int
        * priceMax: int
        * 
        * ratingMin: int
        * ratingMax: int (why would you even want to search for this?)
        * 
        * roomsMin: int
        * roomsMax: int
        * 
        * availableFrom: ??? (some sort of date)
        * availableUntil: ???
        * 
        * -- Selectors --
        * These are checkboxes or other types of selectors, 0 <= may be selected
        * propertyType: int[] (or enum[]?)
        * location: int[] (indexes into a hash map of locations we have elsewhere)
        */

        // Then it should return a list of hotel entries. This is what the user will see on the search page
        // Each hotel entry should probably have these:

        /*
        * UUID: UUID (unique internal identifier for the hotel, used for other things)
        * name: String
        * rating: float
        * shortDescription: String (we can just truncate the long description too)
        * price: int (I assume ISK? for USD or EUR, we also need an integer decimal component)
        * rooms: int
        * availableFrom: ??? (some sort of date, first available day from today, if no start date is specified in search)
        * availableUntil: ??? (last day of continuous availability, starting from the 'from' date)
        * propertyType: int (or enum, as above)
        * location: int (only needed if we let the user select more than one location)
        * indexPhoto: ??? (I genuinely have no idea, this is the photo the user will see next to the description and name)
        */
    }

    public static /* returnType */ getHotel(UUID hotelID) {
        // Gets the other details for a given hotel when the user clicks on it

        // Returns a Hotel with these details:
        /*
         * name: String
         * rating: float
         * longDescription: String
         * photos: ???[] (maybe links?)
         * -- Not sure how to do availability in this format, would like a calendar that shows open dates
         *    By this point, the user has already searched for a from..to date and it is available during those days (since search returned it)
         *    Or they haven't specified a date, but then they definitely would need a calendar view here
         *    Maybe a separate SQL database that stores available days, and we join on the hotel UUID?
         * price: int
         * rooms: int
         * propertyType: int (or enum, as above)
         * cancelPolicy: String
         * phone: String
         * email: String
         * address: ??? (see this is why I think the map will be a pain, we somehow have to fake real addresses)
         */
    }
}
