package hi.hbv401;

import java.util.Date;
import java.util.List;

/* Arguments to the search function in the database */
public class SearchParameters {
    public final Integer priceMin;
    public final Integer priceMax;
    
    public final Integer ratingMin;
    public final Integer ratingMax;

    public final Integer guestsMin;
    public final Integer guestsMax;

    public final Date availableFrom;
    public final Date availableUntil;

    public final List<Integer> propertyTypes;
    public final Integer location;

    public SearchParameters(Integer priceMin, 
                            Integer priceMax, 
                            Integer ratingMin, 
                            Integer ratingMax, 
                            Integer guestsMin, 
                            Integer guestsMax, 
                            Date availableFrom, 
                            Date availableUntil, 
                            List<Integer> propertyTypes,
                            Integer location) {

        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.ratingMin = ratingMin;
        this.ratingMax = ratingMax;
        this.guestsMin = guestsMin;
        this.guestsMax = guestsMax;
        this.availableFrom = availableFrom;
        this.availableUntil = availableUntil;
        this.propertyTypes = propertyTypes;
        this.location = location;
    }
}