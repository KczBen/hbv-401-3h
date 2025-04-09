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

public class LoginCodeController {
    private Database db = Database.getInstance();
    private String userEmail;
    private Booking booking;

    @FXML
    private TextField codeField;

    @FXML
    private Button backButton;

    @FXML
    private void handleSubmit() {
        String code = codeField.getText();

        if (validateCode(code)) {
            // Code in the right format, now check if they are registered
            if (db.getUserDetails(userEmail) != null) {
                // They are registered
                if (booking != null) {
                    // We got here from a booking, take them to the booking page
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookingView.fxml"));
                        Parent root = loader.load();
                        
                        Stage stage = (Stage) backButton.getScene().getWindow();
                        BookingController controller = loader.getController();
                        controller.setBooking(booking);
                        controller.setUser(db.getUserDetails(userEmail));
                        controller.init();
        
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                else {
                    // We got here from a login, take them to the user page
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserView.fxml"));
                        Parent root = loader.load();
                        
                        Stage stage = (Stage) backButton.getScene().getWindow();
                        UserPageController controller = loader.getController();
                        controller.setUser(db.getUserDetails(userEmail));
        
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                // Not registered, ask more info
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegistrationView.fxml"));
                    Parent root = loader.load();
                    
                    Stage stage = (Stage) backButton.getScene().getWindow();
                    RegistrationController controller = loader.getController();
                    controller.setBooking(booking);
                    controller.setUserEmail(userEmail);
    
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) backButton.getScene().getWindow();

            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validateCode(String code) {
        try {
            Integer.parseInt(code);
        } catch (Exception e) {
            return false;
        }

        // if we got this far, it's all numbers

        if (code.length() == 6) {
            return true;
        }

        return false;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
