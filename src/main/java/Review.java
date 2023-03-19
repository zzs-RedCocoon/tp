import java.util.Scanner;

public class Review {
    private String review;

    public Review(String review) {
        this.review = review;
    }

    public Review() {
        this.review = "";
    }

    public void setReview(Scanner scan) {
        String line = "";
        System.out.println("Write your review. Use as many lines as you need."
                + "To end, simply input a blank line.");
        line = scan.nextLine();
    }
}
