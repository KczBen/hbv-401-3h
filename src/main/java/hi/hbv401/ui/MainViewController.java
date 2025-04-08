package hi.hbv401.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.RangeSlider;

import javafx.scene.input.MouseEvent;

import hi.hbv401.Database;
import hi.hbv401.Hotel;
import hi.hbv401.SearchParameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.binding.Bindings;

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
    @FXML
    private RangeSlider priceRange;
    @FXML
    private Label minPriceLabel;
    @FXML
    private Label maxPriceLabel;

    private Database db = Database.getInstance();

    @FXML
    private void initialize() {
        System.out.println("MainViewController initialized!");
        configureTable();
        configureRoomTypes();
        configureLocations();
        configurePriceRange();

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

    private void configureRoomTypes() {
        // Initialize room types
        ObservableList<String> roomTypes = FXCollections.observableArrayList(
            db.getRoomTypes()
        );
        roomTypeCombo.setItems(roomTypes);
        roomTypeCombo.getSelectionModel().selectFirst();
    }

    private void configureLocations() {
        ObservableList<String> locations = FXCollections.observableArrayList(
            db.getLocations()
        );
        locationCombo.setItems(locations);
        locationCombo.getSelectionModel().selectFirst();
    }

    private void configureTable() {
        // Will implement table configuration as needed
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {
        System.out.println("Search button clicked!");

        String location = locationCombo.getValue();
        LocalDate checkIn = checkInDate.getValue() != null ? LocalDate.parse(checkInDate.getValue().toString()) : null;
        LocalDate checkOut = checkOutDate.getValue() != null ? LocalDate.parse(checkOutDate.getValue().toString()) : null;
        int guests = guestsSpinner.getValue();
        String roomType = roomTypeCombo.getValue();
        List<String> roomTypes = new ArrayList<String>();
        roomTypes.add(roomTypeCombo.getValue());

        System.out.println("Location: " + location);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Check-out: " + checkOut);
        System.out.println("Guests: " + guests);
        System.out.println("Room type: " + roomType);

        SearchParameters params = new SearchParameters(
            (int)priceRange.getLowValue(),
            (int)priceRange.getHighValue(),
            null,
            null,
            guestsSpinner.getValue(),
            null,
            checkIn,
            checkOut,
            roomTypes,
            locationCombo.getValue());

        List<Hotel> results = db.searchHotels(params);

        System.out.println(results);
        // We'll populate the table later
    }
}
