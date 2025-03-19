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
        return new ArrayList<>(reservations);
    }
}
