package hi.hbv401.ui;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookingController {
    @FXML
    private Label hotelNameLabel;

    @FXML
    private Label roomNumberLabel;

    @FXML
    private Label checkinDateLabel;

    @FXML
    private Label checkoutDateLabel;

    @FXML
    private Label totalNightsLabel;
    
    @FXML
    private Label totalPriceLabel;

    private Database db = Database.getInstance();
    private User user;
    private Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
