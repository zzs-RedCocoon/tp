import java.util.ArrayList;

public class WatchedList extends MovieList {

    public WatchedList() {
        super();
    }
    
    public WatchedList(ArrayList<String[]> loaded) {
        super(loaded);
    }

    public void setReview(int index, String review) {
        // Offset one-indexing.
        int i = index - 1;
        Movie currentMovie = this.movieList.get(i);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview(review);

        this.movieList.set(i, reviewedMovie);
    }
}
