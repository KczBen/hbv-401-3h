package hi.hbv401.ui;

import hi.hbv401.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelBookingApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        Parent root = loader.load();

        MainViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        primaryStage.setTitle("Hotel Booking");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Database.initialize("sql/database.db");
        launch(args);
    }
}
