package seedu.moviemate.command;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public abstract class Command {
    public abstract void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage);
}



