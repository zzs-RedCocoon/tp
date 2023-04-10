package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class DeleteReviewCommand implements Command {

    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        watchedList.deleteReview(ui, watchedList);
    }
}
