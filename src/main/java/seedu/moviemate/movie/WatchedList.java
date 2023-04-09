package seedu.moviemate.movie;

import seedu.moviemate.parser.Parser;
import seedu.moviemate.ui.Ui;

import java.util.ArrayList;

/**
 * A list of movies the user has watched.
 */
public class WatchedList extends MovieList {

    public WatchedList() {
        super();
    }

    public WatchedList(ArrayList<String[]> loaded) {
        super(loaded);
    }

    public void setReview(Ui ui, WatchedList watchedList) {
        // no movie, cannot add any review
        if (watchedList.empty()) {
            System.out.println("There are no movies in your watched list. Please add some movies first.");
            return;
        }

        ui.showListMessage(watchedList);

        Movie currentMovie;
        // get valid movie index
        String indexString = ui.inputCommand();
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        while (true) {
            if (index < 0) {
                ui.printRequireValidIndex(1, movieList.size());
                indexString = ui.inputCommand();
                index = Parser.parseIndex(indexString, 1, movieList.size());
            } else if (index == 0) {
                ui.printExitInputIndex();
                return;
            } else {
                currentMovie = this.getMovie(index);
                break;
            }
        }

        System.out.println("This is the current movie that you want to review:");
        System.out.println(currentMovie.getTitle());
        MovieEntry reviewedMovie = new MovieEntry(currentMovie);

        // Do review here.
        reviewedMovie.setReview();

        this.movieList.set(index - 1, reviewedMovie);
    }

    public void deleteReview(Ui ui, WatchedList watchedList) {
        // no movie, cannot delete any review
        if (watchedList.empty()) {
            System.out.println("There are no movies in your watched list. PLease add some movies first.");
            return;
        }
        ui.showListMessage(watchedList);

        Movie currentMovie;
        // get valid movie index
        String indexString = ui.inputCommand();
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        while (true) {
            if (index < 0) {
                ui.printRequireValidIndex(1, movieList.size());
                indexString = ui.inputCommand();
                index = Parser.parseIndex(indexString, 1, movieList.size());
            } else if (index == 0) {
                ui.printExitInputIndex();
                return;
            } else {
                currentMovie = this.getMovie(index);
                break;
            }
        }

        if (currentMovie instanceof MovieEntry) {
            Movie deletedMovie = new Movie(currentMovie);
            this.movieList.set(index - 1, deletedMovie);
            System.out.println(String.format("Successfully deleted the review of movie %d.", index));
        } else {
            System.out.println("The movie has no review. No need to delete!");
        }

    }

    public void viewReview(Ui ui, WatchedList watchedList) {
        // no movie, cannot view review
        if (watchedList.empty()) {
            System.out.println("There are no movies in your watched list. Please add some movies first.");
            return;
        }
        ui.showListMessage(watchedList);

        Movie currentMovie;
        // get valid movie index
        String indexString = ui.inputCommand();
        int index = Parser.parseIndex(indexString, 1, movieList.size());
        while (true) {
            if (index < 0) {
                ui.printRequireValidIndex(1, movieList.size());
                indexString = ui.inputCommand();
                index = Parser.parseIndex(indexString, 1, movieList.size());
            } else if (index == 0) {
                ui.printExitInputIndex();
                return;
            } else {
                currentMovie = this.getMovie(index);
                break;
            }
        }

        if (currentMovie instanceof MovieEntry) {
            MovieEntry reviewedMovie = (MovieEntry) currentMovie;
            System.out.println(reviewedMovie.getReview());
        } else {
            System.out.println("The movie has no review. You can add a review using 'addreview'.");
        }
    }

}
