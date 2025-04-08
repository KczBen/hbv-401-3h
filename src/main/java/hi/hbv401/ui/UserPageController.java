package hi.hbv401.ui;

import java.io.IOException;
import java.util.List;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.Hotel;
import hi.hbv401.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class UserPageController {
    @FXML
    private VBox bookingListContainer;

    private Database db = Database.getInstance();
    private User user;

    @FXML
    private void initialize() {
        List<Booking> bookings = db.getBookingForUser(user);
        configureTable(null);
    }

    private void configureTable(List<Booking> bookings) {
        bookingListContainer.getChildren().clear();

        for (Booking booking : bookings) {
            /*
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HotelCard.fxml"));
                VBox hotelCard = loader.load();

                HotelCardController controller = loader.getController();
                controller.setHotel(hotel);

                hotelListContainer.getChildren().add(hotelCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}
