package hi.hbv401.ui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.Hotel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BookingCardController {
    @FXML private ImageView indexPhoto;
    @FXML private Label hotelName;
    @FXML private Label roomNumber;
    @FXML private Label bookedFrom;
    @FXML private Label bookedUntil;
    @FXML private Label address;
    @FXML private Label cancelPolicy;
    @FXML private Button cancelButton;

    private UserPageController parentController;

    private Database db = Database.getInstance();
    private Booking booking = null;

    public void setBooking(Booking booking) {
        this.booking = booking;
        List<Integer> roomList = new ArrayList<Integer>();
        roomList.add(booking.getRoomNumber());
        Hotel hotel = db.getHotelDetailsFiltered(booking.getHotelId(), roomList);

        hotelName.setText(hotel.getName());
        roomNumber.setText("" + booking.getRoomNumber());
        bookedFrom.setText(booking.getBookedFrom().toString());
        bookedUntil.setText(booking.getBookedUntil().toString());
        address.setText(hotel.getAddress());
        cancelPolicy.setText(hotel.getCancelPolicy());
        address.setText(hotel.getAddress());
        String imagePath = System.getProperty("user.dir") + "/csv" + hotel.getPhotos().get(0);
        try {
            File file = new File(imagePath);
            URL url = file.toURI().toURL();
            Image image = new Image(url.toString());
            indexPhoto.setImage(image);
        }
        
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setParentController(UserPageController parent) {
        this.parentController = parent;
    }

    @FXML
    public void handleCancel() {
        System.out.println("Deleting booking \n" + booking);
        db.cancelBooking(booking);
        parentController.init();
    }
}
