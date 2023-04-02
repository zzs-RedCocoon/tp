package seedu.moviemate.command;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class DeleteReviewCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.deleteReview(ui, watchedList);
    }
}
