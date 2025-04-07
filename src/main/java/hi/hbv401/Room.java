package hi.hbv401;


public class Room {
    private final int hotelID;
    private final int roomNumber;
    private final int price;
    private final String type;
    private final int maxGuests;
    
    public Room(int hotelID, int roomNumber, int price, String type, int maxGuests) {
        this.hotelID= hotelID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
        this.maxGuests = maxGuests;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getMaxGuests() {
        return maxGuests;
    }
}
