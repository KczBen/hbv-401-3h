package hi.hbv401;

/* Arguments to the search function in the Database
 *
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
 * location: int[] (indexes into a hash map/SQL database of locations we have elsewhere)
 */
public class SearchParameters {
    
}
