package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class AddReviewCommand implements Command {

    //maybe can do some parse to get the index from String here later.
    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        watchedList.setReview(ui, watchedList);
    }

}
