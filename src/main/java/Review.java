import java.util.Scanner;

/**
 * A review encompasses a string (Text review).
 * and a star review (0 to 5 scale).
 */
public class Review implements Comparable<Review> {
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
     * Set review for both text and stars.
     */
    public void setReview() {
        Scanner scan = new Scanner(System.in);

        // Set Review Text First
        this.setReviewText(scan);
        System.out.println("Text review added.");

        this.setReviewStars(scan);
        System.out.println("Star review added.");

        scan.close();
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

    public void setReviewStars(Scanner scan) {
        // Sorry for arrow nesting it.
        while (true) {
            System.out.print("Please rate the movie [0 to 5]: ");
            if (scan.hasNextInt()) {
                int stars = scan.nextInt();

                // Bad path
                if (stars > 5 || stars < 0) {
                    System.out.println("Hey! Reviews only from 0 to 5!");
                    // Throw MovieMate exception?
                    continue;
                }
                this.reviewStars = stars;
                return;
            } else {
                System.out.println("Please input a number [0 to 5]!");
            }
        }

    }

    public int getReviewStars() {
        return this.reviewStars;
    }

    /**
     * Sets the review text, which actually requires scanner.
     */
    public void setReviewText(Scanner scan) {

        String review = "";
        System.out.println("Write your review. Use as many lines as you need. "
                + "To end, simply input a blank line.");
        // String line = scan.nextLine();

        // Stop when empty.
        while (true) {
            System.out.print("> ");
            String line = scan.nextLine();

            // has next as long as it's not whitespace only.
            if (line.trim().isEmpty()) {
                break;
            }
            review += line;
        }
        this.reviewText = review;
    }

    public String getReviewText() {
        return this.reviewText;
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


    /**
     * Simply sort based on star value.
     */
    @Override
    public int compareTo(Review r2) {
        return (this.reviewStars - r2.getReviewStars());
    }
}
