import java.util.ArrayList;

public class WatchedList extends MovieList {

    public WatchedList() {
        super();
    }
    
    public WatchedList(ArrayList<String[]> loaded) {
        super(loaded);
    }

    public void setReview(int index) {
        Movie currentMovie = this.getMovie(index);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview();

        this.movieList.set(index, reviewedMovie);
    }

    public void deleteReview(int index) {
        Movie currentMovie = this.getMovie(index);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        reviewedMovie.deleteReview();

        this.movieList.set(index, reviewedMovie);
    }

    public String viewReview(int index) {
        Movie currentMovie = this.getMovie(index);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        return reviewedMovie.getReview();
    }
}
