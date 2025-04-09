package hi.hbv401.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
    @FXML
    private TextField userName;

    @FXML
    private TextField userPhone;

    @FXML
    private Button backButton;


    private String userEmail;
    private Booking booking;
    private Database db = Database.getInstance();

    @FXML
    private void handleSubmit() {
        // Create a new user, and add it to the database
        List<Booking> bookings = new ArrayList<Booking>();
        User user = new User(null, userName.getText(), userEmail, userPhone.getText(), bookings);

        db.createUser(user);

        // If we got here from a booking, boot them straight to the booking page, else take them to search
        if (booking != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookingView.fxml"));
                Parent root = loader.load();
                
                Stage stage = (Stage) backButton.getScene().getWindow();
                BookingController controller = loader.getController();
                controller.setBooking(booking);
                // Need to do this because the database auto-assigns IDs
                controller.setUser(db.getUserDetails(userEmail));
                controller.init();

                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
                Parent root = loader.load();
                
                MainViewController controller = loader.getController();
                Stage stage = (Stage) backButton.getScene().getWindow();
                controller.setPrimaryStage(stage);
                
                Scene scene = new Scene(root, 800, 600);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) backButton.getScene().getWindow();
            
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}
