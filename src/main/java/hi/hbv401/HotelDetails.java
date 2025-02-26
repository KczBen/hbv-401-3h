package hi.hbv401;

/* Return type of the getHotel function in Database
 * 
 * name: String
 * rating: float
 * longDescription: String
 * photos: ???[] (maybe links?)
 * -- Not sure how to do availability in this format, would like a calendar that shows open dates
 *    By this point, the user has already searched for a from..to date and it is available during those days (since search returned it)
 *    Or they haven't specified a date, but then they definitely would need a calendar view here
 *    Maybe a separate SQL database that stores occupied days, and we join on the hotel UUID?
 *    
 * price: int
 * rooms: int
 * propertyType: int (or enum, as above)
 * cancelPolicy: String
 * phone: String
 * email: String
 * address: ??? (see this is why I think the map will be a pain, we somehow have to fake real addresses)
 */
public class HotelDetails {
    
}
