package seedu.moviemate.command;

import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.movie.WatchedList;
import seedu.moviemate.parser.Parser;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.MovieList;

public class RemoveListCommand extends Command {

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
                System.out.println("Exit input acknowledged. Cancelling last command...");
                break;
            }
            // happy path
            movieList.remove(removeIndex);
            break;

        }
    }

    public void removeToWatchList(ToWatchList toWatchList) {
        //remove from towatch list
        if (toWatchList.empty()) {
            System.out.println("Your to-watch list is empty. Nothing to remove!");
            return;
        }
        Ui.showListMessage(toWatchList);

        String input = Ui.inputCommand();
        while (true) {
            int removeIndex = Parser.parseIndex(input, 1, toWatchList.movieList.size());
            if (removeIndex < 0) {
                System.out.println(String.format(
                        "Please enter a valid index from 1 to %d", toWatchList.movieList.size()));
                input = Ui.inputCommand();
            } else if (removeIndex == 0) {
                System.out.println("Exit input acknowledged. Cancelling last command...");
                return;
            } else {
                toWatchList.remove(removeIndex);
                break;
            }
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
