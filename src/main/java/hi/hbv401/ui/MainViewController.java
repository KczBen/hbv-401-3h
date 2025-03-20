package hi.hbv401.ui;

import hi.hbv401.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    @FXML
    private TableView<Hotel> hotelTableView;


    @FXML
    private void initialize() {
        System.out.println("MainViewController initialized!");
        configureTable();
        configureRoomTypes();

        // Set initial value for spinner
        if (guestsSpinner.getValue() == null) {
            guestsSpinner.getValueFactory().setValue(1);
        }
    }

    private void configureRoomTypes() {
        // Initialize room types
        ObservableList<String> roomTypes = FXCollections.observableArrayList(
            "Standard Room", "Deluxe Room", "Suite", "Executive Suite", "Family Room"
        );
        roomTypeCombo.setItems(roomTypes);
        roomTypeCombo.getSelectionModel().selectFirst();
    }

    private void configureTable() {
        // Will implement table configuration as needed
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {
        System.out.println("Search button clicked!");

        String location = locationField.getText();
        String checkIn = checkInDate.getValue() != null ? checkInDate.getValue().toString() : "Not selected";
        String checkOut = checkOutDate.getValue() != null ? checkOutDate.getValue().toString() : "Not selected";
        int guests = guestsSpinner.getValue();
        String roomType = roomTypeCombo.getValue();

        System.out.println("Location: " + location);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Check-out: " + checkOut);
        System.out.println("Guests: " + guests);
        System.out.println("Room type: " + roomType);

        // We'll populate the table later
    }
}
