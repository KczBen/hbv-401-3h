# Run
Do a test run on your own first! You need the build tools and stuff downloaded and installed.
```
mvn javafx:run
```

## Demo
Here's some info on each page and what you should probably do. Make the window fullscreen so everything shows nicely.

### Search
This is the starting page of the app. You can select nothing (leave as is) and it will show you all the hotels.

For demoing the booking, I recommend selecting the *Guesthouse* type as there is only one of these.

After that, show that the options work. *The Demoman* as the demo hotel is called, has 10 guests max and costs an obscene amount. Show that the options work by trying to:
 * Book a cheaper hotel
 * Book a hotel with higher than 6.5 minimum rating
 * Book a hotel with lower than 6.5 max rating

You can also select a different location.

### Booking
Now you have The Demoman. Click on the Rooms and click Book.

You'll now be prompted to enter an email address. The **format is actually validated**. example@example.com will work. Remember what email you used here, you'll need it later.

Next you'll be prompted to enter a 6-digit code that we "sent" you to your email. Any 6-digit number will work, 123456 for example.

You're making a new account (nobody has example@example.com in the database), so enter a name and a phone number. Neither of these are validated in any form other than they exist. You can put any string in both boxes.

Finally, you're at the booking page. The top part shows details about your booking. At the bottom, put in a name, card number, expiration date, CVV and address. Some of these are validated, so keep that in mind.
 * Name - Any string
 * Card number - Any 16 digit number. Do 1111222233334444 for example. No spaces, no dashes, just the number.
 * Expiry date - Just don't leave it empty
 * CVV - Any 3 digit number. Do 123
 * Addres - Any string

### Cancelation
First, search for the same hotel in a time slot that it is **NOT** available. If you booked it from April 10 to April 15, search for April 11 to 13. It shouldn't show up.

Now you want to log in. Click the button at the top. You'll be prompted for the email again. **Enter the same email you used for booking.** Enter a 6 digit number again.

This puts you on your Bookings page. Click Cancel booking on the hotel you booked. Now you can go back to search and show that it's available again.

## Cleanup

You should do a test run of this on your own. Since you're in git, just revert the changes to the database and you'll be back to a clean state.