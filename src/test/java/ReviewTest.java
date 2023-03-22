import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ReviewTest {

    private Review review;

    @Test
    public void setReviewStars_outOfBounds_noChange() throws NumberFormatException {
        review = new Review();
        review.setReviewStars(3);
        assert review.getReviewStars() == 3;

        review.setReviewStars(6);
        assert review.getReviewStars() == 3;
    }


}
