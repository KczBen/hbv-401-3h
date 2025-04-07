package hi.hbv401;

import java.util.*;

public class Hotel {
    public final int hotelId;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel ID: ").append(this.hotelId)
          .append("\nName: ").append(this.name)
          .append("\nRating: ").append(this.rating)
          .append("\nDescription: ").append(this.description)
          .append("\nPhotos: ").append(this.photos)
          .append("\nStarting Price: ").append(this.startingPrice)
          .append("\nCancel Policy: ").append(this.cancelPolicy)
          .append("\nPhone: ").append(this.phone)
          .append("\nEmail: ").append(this.email)
          .append("\nAddress: ").append(this.address);
    
        sb.append("\nRooms: ");
        if (rooms == null || rooms.isEmpty()) {
            sb.append("None");
        } else {
            List<Integer> roomNumbers = rooms.stream()
                                             .map(room -> room.getRoomNumber())
                                             .toList();
            sb.append(roomNumbers);
        }
        sb.append("\n");
    
        return sb.toString();
    }
}
