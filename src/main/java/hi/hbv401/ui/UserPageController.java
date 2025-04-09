package hi.hbv401.ui;

import java.io.IOException;
import java.util.List;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserPageController {
    @FXML private VBox bookingListContainer;
    @FXML private Button homeButton;

    private Database db = Database.getInstance();
    private User user;

    public void init() {
        List<Booking> bookings = db.getBookingForUser(user);
        configureTable(bookings);
    }

    private void configureTable(List<Booking> bookings) {
        bookingListContainer.getChildren().clear();

        for (Booking booking : bookings) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookingCard.fxml"));
                VBox hotelCard = loader.load();

                BookingCardController controller = loader.getController();
                controller.setBooking(booking);

                bookingListContainer.getChildren().add(hotelCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void handleHome() {
        // Take them back home
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();
            
            MainViewController controller = loader.getController();
            Stage stage = (Stage) homeButton.getScene().getWindow();
            controller.setPrimaryStage(stage);
            
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
