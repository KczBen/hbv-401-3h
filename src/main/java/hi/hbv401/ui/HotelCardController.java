package hi.hbv401.ui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import hi.hbv401.Hotel;
import hi.hbv401.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HotelCardController {
    @FXML private Label hotelName;
    @FXML private Label rating;
    @FXML private Label description;
    @FXML private Label startingPrice;
    @FXML private TitledPane roomPane;
    @FXML private VBox roomList;
    @FXML private ImageView indexPhoto;


    public void setHotel(Hotel hotel) {
        hotelName.setText(hotel.getName());
        rating.setText("Rating: " + hotel.getRating());
        description.setText(hotel.getDescription());
        startingPrice.setText("Starting at " + hotel.getStartingPrice());
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
            HBox roomBox = new HBox(10);
            Label roomInfo = new Label(room.getType() + " - $" + room.getPrice() + " - Max " + room.getMaxGuests() + " guests");
            Button bookButton = new Button("Book");
            
            bookButton.setOnAction(e -> {
                // no booking yet, should take you to a "payment" page
                System.out.println("Booking room " + room.getRoomNumber() + " at hotel " + hotel.getName());
            });

            roomBox.getChildren().addAll(roomInfo, bookButton);
            roomList.getChildren().add(roomBox);
        }
    }
}