package hi.hbv401;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private final String name;
    private final String email;
    private final String phone;
    private final List<Booking> reservations;

    public User(int userId, String name, String email, String phone, List<Booking> reservations) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.reservations = (reservations != null) ? new ArrayList<>(reservations) : new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User ID: ").append(this.userId)
          .append("\nName: ").append(this.name)
          .append("\nEmail: ").append(this.email)
          .append("\nPhone: ").append(this.phone);
    
        sb.append("\nReservations:");
        if (reservations == null || reservations.isEmpty()) {
            sb.append(" None");
        } else {
            for (Booking booking : reservations) {
                sb.append("\n  - Hotel ID: ").append(booking.getHotelId())
                  .append(", Room Number: ").append(booking.getRoomNumber())
                  .append(", From: ").append(booking.getBookedFrom())
                  .append(", Until: ").append(booking.getBookedUntil());
            }
        }
    
        return sb.toString();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Booking> getReservations() {
        return reservations;
    }
}
