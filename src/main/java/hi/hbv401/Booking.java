package hi.hbv401;

import java.time.LocalDate;

public class Booking {
    private final LocalDate bookedFrom;
    private final LocalDate bookedUntil;
    private final int userId;
    private final int hotelId;
    private final int roomNumber;

    public Booking(LocalDate bookedFrom, LocalDate bookedUntil, int userId, int hotelId, int roomNumber) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User ID: ").append(this.userId)
          .append("\nHotel ID: ").append(this.hotelId)
          .append("\nRoom number: ").append(this.roomNumber)
          .append("\nBooked from: ").append(this.bookedFrom)
          .append("\nBooked until: ").append(this.bookedUntil);
    
        sb.append("\n");
    
        return sb.toString();
    }

    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public LocalDate getBookedUntil() {
        return bookedUntil;
    }

    public int getUser() {
        return userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
