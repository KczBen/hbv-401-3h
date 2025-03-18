package hi.hbv401;

import java.time.LocalDateTime;

public class Booking {
    public final LocalDateTime bookedFrom;
    public final LocalDateTime bookedUntil;
    // in place of a user ID
    public final String userEmail;
    public final int hotelId;
    public final int roomNumber;

    public Booking(LocalDateTime bookedFrom, LocalDateTime bookedUntil, String userEmail, int hotelId, int roomNumber) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.userEmail = userEmail;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
    }
}
