package hi.hbv401;

import java.time.LocalDate;

public class Booking {
    private final LocalDate bookedFrom;
    private final LocalDate bookedUntil;
    private final User user;
    private final int hotelId;
    private final int roomNumber;

    public Booking(LocalDate bookedFrom, LocalDate bookedUntil, User user, int hotelId, int roomNumber) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.user = user;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
    }

    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public LocalDate getBookedUntil() {
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
