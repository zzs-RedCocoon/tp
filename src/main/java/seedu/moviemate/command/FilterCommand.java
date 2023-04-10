package seedu.moviemate.command;

import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class FilterCommand implements Command {
    private String genre;

    public FilterCommand(String genre) {
        this.genre = genre;
    }

    @Override
    public void execute(MovieList watchedList, MovieList toWatchList, Ui ui, Storage storage) {
        watchedList.filter(genre);
        System.out.println("");
        toWatchList.filter(genre);
    }
}
