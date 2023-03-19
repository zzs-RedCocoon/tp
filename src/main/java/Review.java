import java.util.Scanner;

/**
 * A review encompasses a string (Text review).
 * and a star review (0 to 5 scale).
 */
public class Review {
    private String reviewText;
    private int reviewStars;

    /**
     * Review constructor. If either parameter is missing, it will construct with blank ones.
     * @param reviewText String review in text.
     * @param reviewStars Integer review (0 to 5 stars)
     */
    public Review(String reviewText, int reviewStars) {
        this.reviewText = reviewText;
        this.reviewStars = reviewStars;
    }

    public Review(String reviewText) {
        this.reviewText = reviewText;
        this.reviewStars = 0;
    }

    public Review(int reviewStars) {
        this.reviewText = "";
        this.reviewStars = reviewStars;
    }

    public Review() {
        this.reviewText = "";
        this.reviewStars = 0;
    }

    /**
     * Sets the star review from 0 to 5 (Inclusive).
     * Feedback to user (No change) if stars are not valid.
     * @param stars star rating of 0 to 5 inclusive.
     */
    public void setReviewStars(int stars) {
        // Bad path
        if (stars > 5 || stars < 0) {
            System.out.println("Hey! Reviews only from 0 to 5!");
            // Throw MovieMate exception?
        }
        this.reviewStars = stars;
    }


    /**
     * Sets the review text, which actually requires scanner.
     * @param scan the scanner object being used for user input.
     */
    public void setReviewText(Scanner scan) {
        String review = "";
        System.out.println("Write your review. Use as many lines as you need."
                + "To end, simply input a blank line.");
        String line = scan.nextLine();
        while (!line.trim().isEmpty()) {
            // Line separator is included in nextLine.
            review += scan.nextLine();
        }
        this.reviewText = review;
    }

    /**
     * Clears the review text to blank string.
     */
    public void deleteReviewText() {
        this.reviewText = "";
    }

    @Override
    public String toString() {
        return String.format("Review: "
                + "%s"
                + "(%d/5 stars)",
                this.reviewText, this.reviewStars);
    }
}
