package hi.hbv401.ui;

import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import hi.hbv401.Booking;
import hi.hbv401.Database;
import hi.hbv401.Hotel;
import hi.hbv401.Room;
import hi.hbv401.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookingController {
    // Booking details
    @FXML private Label hotelNameLabel;
    @FXML private Label roomNumberLabel;
    @FXML private Label checkinDateLabel;
    @FXML private Label checkoutDateLabel;
    @FXML private Label totalNightsLabel;
    @FXML private Label totalPriceLabel;

    // Inputs
    @FXML private TextField cardHolderField;
    @FXML private TextField cardNumberField;
    @FXML private ComboBox<Integer> expiryMonthCombo;
    @FXML private ComboBox<Integer> expiryYearCombo;
    @FXML private TextField cvvField;
    @FXML private TextArea billingAddressArea;

    // Buttons
    @FXML private Button cancelButton;
    @FXML private Button confirmButton;

    private Database db = Database.getInstance();
    private User user;
    private Booking booking;

    @FXML
    private void handleCancel() {
        // Take them back to the search page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();
            
            MainViewController controller = loader.getController();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            controller.setPrimaryStage(stage);
            
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleConfirm() {
        // mask, stays true only if all are valid
        boolean valid = true;
        valid &= validateCard(cardNumberField.getText());
        valid &= validateName(cardHolderField.getText());
        valid &= validateCardDates(expiryYearCombo.getValue(), expiryMonthCombo.getValue());
        valid &= validadteCvv(cvvField.getText());
        // Not validating the address, same rules apply as with the name
        valid &= validateName(billingAddressArea.getText());

        if (valid) {
            Booking newBooking = new Booking(booking.getBookedFrom(), booking.getBookedUntil(), user.getUserId(), booking.getHotelId(), booking.getRoomNumber());
            db.makeBooking(newBooking);
        }
    }

    public void init() {
        List<Integer> roomNumber = new ArrayList<Integer>();
        roomNumber.add(booking.getRoomNumber());
        Hotel hotel = db.getHotelDetailsFiltered(booking.getHotelId(), roomNumber);
        Room room = hotel.getRooms().get(0);
        hotelNameLabel.setText(hotel.getName());
        // this is stupid
        roomNumberLabel.setText("" + booking.getRoomNumber());
        checkinDateLabel.setText(booking.getBookedFrom().toString());
        checkoutDateLabel.setText(booking.getBookedUntil().toString());
        // this is also stupid
        int totalNights = Period.between(booking.getBookedFrom(), booking.getBookedUntil()).getDays();
        totalNightsLabel.setText("" + totalNights);
        totalPriceLabel.setText("" + totalNights * room.getPrice());

        expiryYearCombo.setItems(FXCollections.observableArrayList(
            java.util.stream.IntStream.rangeClosed(2025, 2032).boxed().toList()
        ));

        expiryMonthCombo.setItems(FXCollections.observableArrayList(
            java.util.stream.IntStream.rangeClosed(1, 12).boxed().toList()
        ));
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private boolean validateCard(String cardNumber) {
        if (cardNumber.length() != 16) {
            System.err.println("Card number too short");
            return false;
        }

        try {
            Long.parseLong(cardNumber);
        } catch (Exception e) {
            System.err.println("Card number contains non-integers");
            return false;
        }

        return true;
    }

    private boolean validateName(String name) {
        if (name.length() < 1 || name == null) {
            System.err.println("Name too short or null");
            return false;
        }

        return true;
    }

    private boolean validateCardDates(Integer year, Integer month) {
        if (year == null || month == null) {
            System.err.println("Date empty");
            return false;
        }

        return true;
    }

    private boolean validadteCvv(String cvv) {
        if (cvv.length() != 3 || cvv == null) {
            System.err.println("CVV too short or null");
            return false;
        }

        try {
            Integer.parseInt(cvv);
        } catch (Exception e) {
            System.err.println("CVV contains non-integers");
            return false;
        }

        return true;
    }
}
