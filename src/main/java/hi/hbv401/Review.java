package hi.hbv401;

import java.time.LocalDateTime;

public class Review {
    private final User user;
    private final Hotel hotel;
    private final int rating;
    private final String comment;
    private final LocalDateTime createdAt;

    public Review(User user, Hotel hotel, int rating, String comment, LocalDateTime createdAt) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        this.user = user;
        this.hotel = hotel;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
