package hi.hbv401;

import java.time.LocalDateTime;

public class Booking {
    private final LocalDateTime bookedFrom;
    private final LocalDateTime bookedUntil;
    private final User user;
    private final int hotelId;
    private final int roomNumber;

    public Booking(LocalDateTime bookedFrom, LocalDateTime bookedUntil, User user, int hotelId, int roomNumber) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.user = user;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getBookedFrom() {
        return bookedFrom;
    }

    public LocalDateTime getBookedUntil() {
        return bookedUntil;
    }

    public User getUser() {
        return user;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
