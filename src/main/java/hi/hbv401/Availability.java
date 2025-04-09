package hi.hbv401;

import java.time.LocalDate;
import java.util.Date;

public class Availability {
    public final LocalDate bookedFrom;
    public final LocalDate bookedUntil;

    public Availability(LocalDate bookedFrom, LocalDate bookedUntil) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
    }
}