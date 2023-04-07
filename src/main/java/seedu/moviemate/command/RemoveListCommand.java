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

    public void removeMovieList(MovieList movieList){
        //remove from towatch list
        if (movieList.empty()) {
            System.out.println("This list is empty. Nothing to remove!");
            return;
        }
        Ui.showListMessage(movieList);

        String input = Ui.inputCommand();
        while (true) {
            int removeIndex = Parser.parseIndex(input, 1, movieList.movieList.size());
            if (removeIndex < 0) {
                System.out.println(String.format(
                        "Please enter a valid index from 1 to %d", movieList.movieList.size()));
                input = Ui.inputCommand();
            } else {
                movieList.remove(removeIndex);
                break;
            }
        }
    }
    
    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (removeListType) {
        case "watched":
            removeMovieList(watchedList);
            break;
        case "towatch":
            removeMovieList(toWatchList);
            break;
        default:
            System.out.println("Please follow the format: remove [watched/towatch]");
            break;
        }
    }


}
