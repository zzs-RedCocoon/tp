import java.util.ArrayList;

public class WatchedList extends MovieList {

    public WatchedList() {
        super();
    }
    
    public WatchedList(ArrayList<String[]> loaded) {
        super(loaded);
    }

    public void setReview(String indexString) {
        //no movie, cannot add any review
        if(movieList.size() == 0){
            System.out.println("Sorry, there's no movie in watchedlist. Please add some movies first.");
            return;
        }

        //get valid movie index
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        if(index < 0){
            System.out.println(String.format("Please input valid index from 1 to %d.", movieList.size()));
            return;
        }

        Movie currentMovie = this.getMovie(index);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview();

        this.movieList.set(index - 1, reviewedMovie);
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
