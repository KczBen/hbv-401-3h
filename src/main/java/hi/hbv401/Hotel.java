package hi.hbv401;

import java.util.*;

public class Hotel {
    private final int hotelId;
    private final String name;
    private final float rating;
    private final String description;
    private final List<String> photos;
    private final int startingPrice;
    private final List<Room> rooms;
    private final String cancelPolicy;
    private final String phone;
    private final String email;
    private final String address;

    public Hotel(int hotelId, String name, float rating, String description, List<String> photos, int startingPrice,
            List<Room> rooms, String cancelPolicy, String phone, String email, String address) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.photos = (photos != null) ? photos : List.of();
        this.startingPrice = startingPrice;
        this.rooms = rooms;
        this.cancelPolicy = cancelPolicy;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPhotos() {
        return photos;
    }
}
