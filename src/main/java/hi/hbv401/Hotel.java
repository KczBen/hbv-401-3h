package hi.hbv401;

import java.util.*;

/* More detailed stuff about the hotels once the user clicks on it */
public class Hotel {
    public final int hotelID;
    public final String name;
    public final float rating;
    public final String description;
    public final List<String> photos;
    public final int startingPrice;
    public final List<Room> rooms;
    public final String cancelPolicy;
    public final String phone;
    public final String email;
    public final String address;
    
    // oBjEcT oRiEnTeD pRoGrAmMiNg Is So GoOd
    public Hotel(int hotelID,
                        String name,
                        float rating,
                        String longDescription,
                        List<String> photos,
                        int price,
                        List<Room> rooms,
                        int propertyType,
                        String cancelPolicy,
                        String phone,
                        String email,
                        String address) {

        this.hotelID = hotelID;
        this.name = name;
        this.rating = rating;
        this.description = longDescription;
        this.photos = photos;
        this.startingPrice = price;
        this.rooms = rooms;
        this.cancelPolicy = cancelPolicy;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}