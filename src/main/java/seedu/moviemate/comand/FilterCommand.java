package seedu.moviemate.comand;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class FilterCommand extends Command {
    private String genre;

    public FilterCommand(String genre) {
        this.genre = genre;
    }

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.filter(genre);
        toWatchList.filter(genre);
    }
}
