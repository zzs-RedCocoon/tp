package seedu.moviemate.command;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class AddWatchedListCommand implements Command {

    private String inputTitle;

    public AddWatchedListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public  void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // add to watched list
        watchedList.addWatched(inputTitle, watchedList, toWatchList, ui);
    }
}
