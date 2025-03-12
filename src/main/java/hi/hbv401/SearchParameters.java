package hi.hbv401;

import java.util.Date;
import java.util.List;

/* Arguments to the search function in the database */
public class SearchParameters {
    public final int priceMin;
    public final int priceMax;
    
    public final int ratingMin;
    public final int ratingMax;

    public final int guestsMin;
    public final int guestsMax;

    public final Date availableFrom;
    public final Date availableUntil;

    public final List<Integer> propertyTypes;
    public final int location;

    public SearchParameters(int priceMin, 
                            int priceMax, 
                            int ratingMin, 
                            int ratingMax, 
                            int guestsMin, 
                            int guestsMax, 
                            Date availableFrom, 
                            Date availableUntil, 
                            List<Integer> propertyTypes,
                            int location) {

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