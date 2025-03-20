package hi.hbv401;

import java.util.Date;

public class Availability {
    public final Date bookedFrom;
    public final Date bookedUntil;

    public Availability(Date bookedFrom, Date bookedUntil) {
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
    }
}