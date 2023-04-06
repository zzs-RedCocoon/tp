package seedu.moviemate.command;

import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.movie.WatchedList;
import seedu.moviemate.parser.Parser;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class RemoveListCommand extends Command{

    private String removeListType;

    public RemoveListCommand(String removeListType) {
        this.removeListType = removeListType;
    }

    public void removeWatchedList(WatchedList watchedList) {
        //remove from watched list
        if (watchedList.empty()) {
            System.out.println("Your watched list is empty. Nothing to remove!");
            return;
        }
        Ui.showListMessage(watchedList);

        String inputIndex = Ui.inputCommand();
        int removeWatchedIndex = Parser.parseIndex(inputIndex, 1, watchedList.movieList.size());
        if (removeWatchedIndex < 0) {
            System.out.println(String.format(
                    "Please try entering the remove command again and make sure the index is valid. \n" +
                    "The valid index range is 1 to %d", watchedList.movieList.size()));
            return;
        }
        watchedList.remove(removeWatchedIndex);
    }

    public void removeToWatchList(ToWatchList toWatchList) {
        //remove from towatch list
        if (toWatchList.empty()) {
            System.out.println("Your to-watch list is empty. Nothing to remove!");
            return;
        }
        Ui.showListMessage(toWatchList);

        String inputIndex = Ui.inputCommand();
        int removeToWatchIndex = Parser.parseIndex(inputIndex, 1, toWatchList.movieList.size());
        if (removeToWatchIndex < 0) {
            System.out.println(String.format(
                    "Please try entering the remove command again and make sure the index is valid. \n" +
                    "The valid index range is 1 to %d",  toWatchList.movieList.size()));
            return;
        }
        toWatchList.remove(removeToWatchIndex);
    }

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (removeListType) {
        case "watched":
            removeWatchedList(watchedList);
            break;
        case "towatch":
            removeToWatchList(toWatchList);
            break;
        default:
            System.out.println("Please follow the format: remove [watched/towatch]");
            break;
        }
    }




}
