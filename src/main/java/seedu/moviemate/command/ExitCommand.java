package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class ExitCommand implements Command {

    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        //Ui...
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
