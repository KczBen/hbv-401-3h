package hi.hbv401.ui;

import hi.hbv401.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {

    @FXML
    private TextField locationField;
    @FXML
    private DatePicker checkInDate;
    @FXML
    private DatePicker checkOutDate;
    @FXML
    private Spinner<Integer> guestsSpinner;
    @FXML
    private ComboBox<String> roomTypeCombo;

    // Remove the TableView if you're not using it anymore
    // @FXML
    // private TableView<Hotel> hotelTableView;

    @FXML
    private VBox hotelListContainer; // For displaying "cards"

    @FXML
    private void initialize() {
        System.out.println("MainViewController initialized!");
        configureRoomTypes();

        // Initialize spinner if null
        if (guestsSpinner.getValue() == null) {
            guestsSpinner.getValueFactory().setValue(1);
        }
    }

    private void configureRoomTypes() {
        ObservableList<String> roomTypes = FXCollections.observableArrayList(
                "Standard Room", "Deluxe Room", "Suite", "Executive Suite", "Family Room"
        );
        roomTypeCombo.setItems(roomTypes);
        roomTypeCombo.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {
        System.out.println("Search button clicked!");

        String location = locationField.getText();
        String checkIn = (checkInDate.getValue() != null)
                ? checkInDate.getValue().toString() : "Not selected";
        String checkOut = (checkOutDate.getValue() != null)
                ? checkOutDate.getValue().toString() : "Not selected";
        int guests = guestsSpinner.getValue();
        String roomType = roomTypeCombo.getValue();

        System.out.println("Location: " + location);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Check-out: " + checkOut);
        System.out.println("Guests: " + guests);
        System.out.println("Room type: " + roomType);

        // Pretend we do a real search. For demonstration, we just get mock data:
        List<Hotel> results = getMockHotels();

        // Clear out old results
        hotelListContainer.getChildren().clear();

        // Add a "card" for each hotel
        for (Hotel h : results) {
            hotelListContainer.getChildren().add(createHotelCard(h));
        }
    }

    /**
     * Creates and returns a Pane (VBox, HBox, etc.) that visually represents the given Hotel.
     */
    private Pane createHotelCard(Hotel hotel) {
        // Create an ImageView if you have a photo
        ImageView imageView = new ImageView();
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        try {
            if (!hotel.photos.isEmpty()) {
                // Attempt to load the first photo
                Image img = new Image(getClass().getResourceAsStream(hotel.photos.get(0)));
                imageView.setImage(img);
            } else {
                // fallback
                imageView.setImage(new Image(getClass().getResourceAsStream("/images/no_photo.jpg")));
            }
        } catch (Exception e) {
            // fallback if path not found
            imageView.setImage(new Image(getClass().getResourceAsStream("/images/no_photo.jpg")));
        }

        Label nameLabel = new Label(hotel.name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label ratingLabel = new Label("Rating: " + hotel.rating);
        Label descLabel = new Label(hotel.description);
        descLabel.setWrapText(true);

        // Button to see more details
        Button detailsBtn = new Button("View Details");
        detailsBtn.setOnAction(e -> showHotelDetails(hotel));

        // Layout
        VBox textBox = new VBox(2, nameLabel, ratingLabel, descLabel, detailsBtn);
        textBox.setStyle("-fx-padding: 5;");

        // Put image + text side by side
        HBox cardRoot = new HBox(10, imageView, textBox);
        cardRoot.setStyle("-fx-border-color: #dddddd; -fx-background-color: #ffffff; -fx-padding: 10;");
        cardRoot.setPrefWidth(600);

        return cardRoot;
    }

    private void showHotelDetails(Hotel hotel) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hotel Details");
        alert.setHeaderText(hotel.name + " (Rating: " + hotel.rating + ")");
        alert.setContentText(
                "Price: " + hotel.startingPrice + "\n" +
                        "Description: " + hotel.description + "\n" +
                        "Phone: " + hotel.phone + "\n" +
                        "Email: " + hotel.email
        );
        alert.showAndWait();
    }

    /**
     * Temporary mock data, you can remove once you integrate real DB searches.
     */
    private List<Hotel> getMockHotels() {
        List<Hotel> list = new ArrayList<>();
        list.add(new Hotel(
                1,
                "Example Hotel",
                8.5f,
                "Cozy place near downtown.",
                List.of("/images/fake1.jpg"),
                20000,
                List.of(),
                1,
                "Free cancellation within 48 hours",
                "+354-555-0101",
                "example@hotel.is",
                "Reykjavik"
        ));
        list.add(new Hotel(
                2,
                "Seaside Resort",
                9.1f,
                "Beautiful beach resort with private pool.",
                List.of("/images/fake2.jpg"),
                35000,
                List.of(),
                1,
                "Non-refundable if canceled within 24 hours",
                "+354-555-0202",
                "resort@hotel.is",
                "Akureyri"
        ));
        return list;
    }
}
