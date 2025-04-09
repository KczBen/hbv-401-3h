package hi.hbv401.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import hi.hbv401.Booking;
import hi.hbv401.Hotel;
import hi.hbv401.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelCardController {
    @FXML private Label hotelName;
    @FXML private Label rating;
    @FXML private Label description;
    @FXML private Label startingPrice;
    @FXML private TitledPane roomPane;
    @FXML private VBox roomList;
    @FXML private ImageView indexPhoto;
    @FXML private Label cancelPolicy;
    @FXML private Label address;

    private LocalDate bookFrom;
    private LocalDate bookUntil;

    public void setBookFrom(LocalDate bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setBookUntil(LocalDate bookUntil) {
        this.bookUntil = bookUntil;
    }

    public void setHotel(Hotel hotel) {
        hotelName.setText(hotel.getName());
        rating.setText("Rating: " + hotel.getRating());
        description.setText(hotel.getDescription());
        startingPrice.setText("Starting at " + hotel.getStartingPrice());
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

        for (Room room : hotel.getRooms()) {
            VBox detailsBox = new VBox(3);
            HBox roomBox = new HBox(10);
            Label roomInfo = new Label(room.getType() + " - $" + room.getPrice() + " - Max " + room.getMaxGuests() + " guests");
            Label amenities = new Label("Includes " + room.getAmenities());
            Button bookButton = new Button("Book");
            
            bookButton.setOnAction(e -> {
                Booking booking = new Booking(bookFrom, bookUntil, 0, room.getHotelID(), room.getRoomNumber());

                // Take user to login page with an active booking
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
                    Parent root = loader.load();
                    
                    Stage stage = (Stage) bookButton.getScene().getWindow();
                    LoginController controller = loader.getController();
                    controller.setBooking(booking);

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            roomBox.getChildren().addAll(roomInfo, bookButton);
            detailsBox.getChildren().addAll(roomBox, amenities);
            roomList.getChildren().add(detailsBox);
        }
    }
}