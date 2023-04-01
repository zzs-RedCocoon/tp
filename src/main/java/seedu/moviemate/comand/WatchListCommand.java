package seedu.moviemate.comand;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class WatchListCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // list the towatch list
        //toWatchList.list();
        Ui.showListMessage(toWatchList);
    }
}
