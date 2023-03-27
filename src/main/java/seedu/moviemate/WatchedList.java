package seedu.moviemate;

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
        if (movieList.size() == 0) {
            System.out.println("Sorry, there's no movie in watchedlist. Please add some movies first.");
            return;
        }

        //get valid movie index
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        if (index < 0) {
            System.out.println(String.format("Please input valid index from 1 to %d.", movieList.size()));
            return;
        }

        Movie currentMovie = this.getMovie(index);
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview();

        this.movieList.set(index - 1, reviewedMovie);
    }

    public void deleteReview(String indexString) {
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        if (index < 0) {
            System.out.println(String.format("Please input valid index from 1 to %d.", movieList.size()));
            return;
        }

        Movie currentMovie = this.getMovie(index);

        if (currentMovie instanceof MovieEntry) {
            Movie deletedMovie = new Movie(currentMovie);
            this.movieList.set(index - 1, deletedMovie);
            System.out.println(String.format("Successfully deleted the review of movie %d.", index));
        } else {
            System.out.println("The movie has no review. No need to delete!");
        }


    }

    public void viewReview(String indexString) {
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        if (index < 0) {
            System.out.println(String.format("Please input valid index from 1 to %d.", movieList.size()));
            return;
        }

        Movie currentMovie = this.getMovie(index);

        if (currentMovie instanceof MovieEntry) {
            MovieEntry reviewedMovie = (MovieEntry) currentMovie;
            System.out.println(reviewedMovie.getReview());
        } else {
            System.out.println("The movie has no review. You can add a review using 'addreview [index]'.");
        }
    }
}
