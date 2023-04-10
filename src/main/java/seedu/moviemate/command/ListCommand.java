package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class ListCommand implements Command {

    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        // list the watched list
        Ui.showListMessage(watchedList);
    }
}
