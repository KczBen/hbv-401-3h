package hi.hbv401.ui;

import java.io.IOException;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private Database db = Database.getInstance();

    // Did we get here from booking or login?
    private Booking booking;

    @FXML
    private TextField emailField;

    @FXML
    private Button backButton;

    @FXML
    private void handleSubmit() {
        String email = emailField.getText();
        if (validateEmail(email)) {
            // We can log them in or register, take them to the appropriate page
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginCode.fxml"));
                Parent root = loader.load();
                
                Stage stage = (Stage) backButton.getScene().getWindow();
                LoginCodeController controller = loader.getController();
                controller.setUserEmail(email);
                controller.setBooking(this.booking);

                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {

        }
    }

    @FXML
    private void handleBack() {
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

    private boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex == 0 || atIndex == email.length() - 1) {
            return false;
        }

        String localPart = email.substring(0, atIndex);
        if (localPart.isEmpty()) {
            return false;
        }

        String domainPart = email.substring(atIndex + 1);

        // Check domain part has at least one '.' and not at start or end
        int dotIndex = domainPart.indexOf('.');
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == domainPart.length() - 1) {
            return false;
        }

        // Split domain into segments
        String[] domainSegments = domainPart.split("\\.");
        for (String segment : domainSegments) {
            if (segment.isEmpty()) {
                return false;
            }
        }

        // Check TLD is at least two characters
        String tld = domainPart.substring(domainPart.lastIndexOf('.'));
        if (tld.length() < 2) {
            return false;
        }

        return true;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
