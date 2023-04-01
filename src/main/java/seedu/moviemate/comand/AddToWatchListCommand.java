package seedu.moviemate.comand;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class AddToWatchListCommand extends Command {
    private String inputTitle;

    public AddToWatchListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public  void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // add to to-watch list
        toWatchList.add(inputTitle);
    }
}
