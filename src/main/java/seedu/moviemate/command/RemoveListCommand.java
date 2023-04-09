package seedu.moviemate.command;

import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.movie.WatchedList;
import seedu.moviemate.parser.Parser;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.MovieList;

public class RemoveListCommand implements Command {

    private String removeListType;

    public RemoveListCommand(String removeListType) {
        this.removeListType = removeListType;
    }

    public void removeMovieList(MovieList movieList, Ui ui){
        if (movieList.empty()) {
            ui.printRemoveMovieListEmpty();
            return;
        }
        Ui.showListMessage(movieList);
        System.out.println("Please enter the id of the movie you would like to remove");
        while (true) {
            String input = Ui.inputCommand();
            int removeIndex = Parser.parseIndex(input, 1, movieList.movieList.size());
            if (removeIndex < 0) {
                ui.printRequireValidIndex(1, movieList.movieList.size());
                continue;
            }
            if (removeIndex == 0) {
                ui.printExitInputIndex();
                break;
            }
            // happy path
            movieList.remove(removeIndex);
            break;

        }
    }


    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (removeListType) {
        case "watched":
            removeMovieList(watchedList, ui);
            break;
        case "towatch":
            removeMovieList(toWatchList, ui);
            break;
        default:
            System.out.println("Please follow the format: remove [watched/towatch]");
            break;
        }
    }


}
