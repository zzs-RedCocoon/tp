package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class AddWatchedListCommand implements Command {

    private String inputTitle;

    public AddWatchedListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public  void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        // add to watched list
        watchedList.addWatched(inputTitle, watchedList, toWatchList, ui);
    }
}
