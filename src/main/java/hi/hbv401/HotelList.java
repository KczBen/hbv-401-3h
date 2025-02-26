package hi.hbv401;

/* Return type of the search function in Database
 *
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
public class HotelList {
    
}
