package hi.hbv401.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.RangeSlider;

import hi.hbv401.Database;
import hi.hbv401.Hotel;
import hi.hbv401.SearchParameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewController {

    @FXML
    private ComboBox<String> locationCombo;
    @FXML
    private DatePicker checkInDate;
    @FXML
    private DatePicker checkOutDate;
    @FXML
    private Spinner<Integer> guestsSpinner;
    @FXML
    private ComboBox<String> roomTypeCombo;
    @FXML
    private TableView<Hotel> hotelTableView;
    // Price
    @FXML
    private RangeSlider priceRange;
    @FXML
    private Label minPriceLabel;
    @FXML
    private Label maxPriceLabel;
    // Rating
    @FXML
    private RangeSlider ratingRange;
    @FXML
    private Label minRatingLabel;
    @FXML
    private Label maxRatingLabel;

    private Database db = Database.getInstance();

    // Display
    @FXML
    private VBox hotelListContainer;

    @FXML
    private void initialize() {
        System.out.println("MainViewController initialized!");
        configureRoomTypes();
        configureLocations();
        configurePriceRange();
        configureRatingRange();

        // Set initial value for spinner
        if (guestsSpinner.getValue() == null) {
            guestsSpinner.getValueFactory().setValue(1);
        }

    }
    
    private void configurePriceRange() {
        List<Integer> prices = db.getPriceRange();

        priceRange.lowValueProperty().addListener((obs, oldVal, newVal) -> {
            minPriceLabel.setText(String.format("%.0f", newVal.doubleValue()));
        });

        priceRange.highValueProperty().addListener((obs, oldVal, newVal) -> {
            maxPriceLabel.setText(String.format("%.0f", newVal.doubleValue()));
        });

        priceRange.setMin((double)prices.get(0));
        priceRange.setMax((double)prices.get(1));
    
        priceRange.setLowValue((double)prices.get(0));
        priceRange.setHighValue((double)prices.get(1));
    }

    private void configureRatingRange() {
        List<Double> ratings = new ArrayList<Double>();
        ratings.add(0.0);
        ratings.add(10.0);

        ratingRange.lowValueProperty().addListener((obs, oldVal, newVal) -> {
            minRatingLabel.setText(String.format("%.1f", newVal.doubleValue()));
        });

        ratingRange.highValueProperty().addListener((obs, oldVal, newVal) -> {
            maxRatingLabel.setText(String.format("%.1f", newVal.doubleValue()));
        });

        ratingRange.setMin(ratings.get(0));
        ratingRange.setMax(ratings.get(1));
    
        ratingRange.setLowValue((double)ratings.get(0));
        ratingRange.setHighValue((double)ratings.get(1));
    }

    private void configureRoomTypes() {
        // Initialize room types
        ObservableList<String> roomTypes = FXCollections.observableArrayList(
            db.getRoomTypes()
        );
        roomTypes.add(0, "Any");
        roomTypeCombo.setItems(roomTypes);
        roomTypeCombo.getSelectionModel().selectFirst();
    }

    private void configureLocations() {
        ObservableList<String> locations = FXCollections.observableArrayList(
            db.getLocations()
        );
        locations.add(0, "Any");
        locationCombo.setItems(locations);
        locationCombo.getSelectionModel().selectFirst();
    }

    private void configureTable(List<Hotel> hotels) {
        hotelListContainer.getChildren().clear();

        for (Hotel hotel : hotels) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HotelCard.fxml"));
                VBox hotelCard = loader.load();

                HotelCardController controller = loader.getController();
                controller.setHotel(hotel);

                hotelListContainer.getChildren().add(hotelCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {
        System.out.println("Search button clicked!");

        String location = locationCombo.getValue() != "Any" ? locationCombo.getValue() : null;
        LocalDate checkIn = checkInDate.getValue() != null ? LocalDate.parse(checkInDate.getValue().toString()) : null;
        LocalDate checkOut = checkOutDate.getValue() != null ? LocalDate.parse(checkOutDate.getValue().toString()) : null;
        int guests = guestsSpinner.getValue();

        // Handle multiple room types
        String roomType = roomTypeCombo.getValue() != "Any" ? roomTypeCombo.getValue() : null;
        List<String> roomTypes = new ArrayList<String>();
        if (roomType == null) {
            roomTypes.addAll(db.getRoomTypes());
        }

        else {
            roomTypes.add(roomType);
        }

        System.out.println("Location: " + location);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Check-out: " + checkOut);
        System.out.println("Guests: " + guests);
        System.out.println("Room type: " + roomType);

        SearchParameters params = new SearchParameters(
            (int)priceRange.getLowValue(),
            (int)priceRange.getHighValue(),
            ratingRange.getLowValue(),
            ratingRange.getHighValue(),
            guests,
            null,
            checkIn,
            checkOut,
            roomTypes,
            location);

        List<Hotel> results = db.searchHotels(params);

        System.out.println(results);
        

        configureTable(results);
    }
}
