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

    public int getStartingPrice() {
        return startingPrice;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getCancelPolicy() {
        return cancelPolicy;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
