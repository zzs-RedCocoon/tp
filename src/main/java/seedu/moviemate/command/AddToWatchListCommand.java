package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class AddToWatchListCommand implements Command {
    private String inputTitle;

    public AddToWatchListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        // add to to-watch list
        toWatchList.addToWatch(inputTitle, watchedList, toWatchList, ui);
    }
}
