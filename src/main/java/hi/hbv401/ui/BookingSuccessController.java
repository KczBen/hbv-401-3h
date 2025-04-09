package hi.hbv401.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookingSuccessController {
    @FXML private Button homeButton;

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
