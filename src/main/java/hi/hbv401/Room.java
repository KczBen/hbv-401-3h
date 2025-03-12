package hi.hbv401;


public class Room {
    public final int hotelID;
    public final int roomNumber;
    public final int price;
    public final String type;
    public final int maxGuests;
    
    public Room(int hotelID, int roomNumber, int price, String type, int maxGuests) {
        this.hotelID= hotelID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
        this.maxGuests = maxGuests;
    }
}