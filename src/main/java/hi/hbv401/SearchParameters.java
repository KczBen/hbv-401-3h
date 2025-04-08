package hi.hbv401;

import java.time.LocalDate;
import java.util.List;

/* Arguments to the search function in the database */
public class SearchParameters {
    public final Integer priceMin;
    public final Integer priceMax;
    
    public final Double ratingMin;
    public final Double ratingMax;

    public final Integer guestsMin;
    public final Integer guestsMax;

    public final LocalDate availableFrom;
    public final LocalDate availableUntil;

    public final List<String> propertyTypes;
    public final String location;

    public SearchParameters(Integer priceMin, 
                            Integer priceMax, 
                            Double ratingMin, 
                            Double ratingMax, 
                            Integer guestsMin, 
                            Integer guestsMax, 
                            LocalDate availableFrom, 
                            LocalDate availableUntil, 
                            List<String> propertyTypes,
                            String location) {

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