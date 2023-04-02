package seedu.moviemate.movie;

import seedu.moviemate.parser.Parser;
import seedu.moviemate.ui.Ui;

import java.util.ArrayList;

public class WatchedList extends MovieList {

    public WatchedList() {
        super();
    }
    
    public WatchedList(ArrayList<String[]> loaded) {
        super(loaded);
    }

    public void setReview(Ui ui, WatchedList watchedList) {
        //no movie, cannot add any review
        if (movieList.size() == 0) {
            System.out.println("Sorry, there's no movie in watched list. Please add some movies first.");
            return;
        }

        ui.showListMessage(watchedList);
        //get valid movie index

        String indexString = ui.inputCommand();
        int index = Parser.parseIndex(indexString, 1, movieList.size());

        if (index < 0) {
            System.out.println(String.format(
                    "Please enter the command again and input valid index from 1 to %d.", movieList.size()));
            return;
        }

        Movie currentMovie = this.getMovie(index);
        System.out.println("This is the current movie that you want to write review for it");
        System.out.println(currentMovie.getTitle());
        System.out.println("Please proceed to write your review");
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview();

        this.movieList.set(index - 1, reviewedMovie);
    }

    public void deleteReview(Ui ui, WatchedList watchedList) {
        ui.showListMessage(watchedList);
        String indexString = ui.inputCommand();
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

    public void viewReview(Ui ui, WatchedList watchedList) {
        ui.showListMessage(watchedList);
        String indexString = ui.inputCommand();
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
