package seedu.moviemate.command;

import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.movie.WatchedList;
import seedu.moviemate.parser.Parser;
import seedu.moviemate.storage.Storage;
import seedu.moviemate.ui.Ui;

public class RemoveListCommand extends Command {

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

        String input = Ui.inputCommand();
        while (true) {
            int removeIndex = Parser.parseIndex(input, 1, watchedList.movieList.size());
            if (removeIndex < 0) {
                System.out.println(String.format(
                        "Please enter a valid index from 1 to %d", watchedList.movieList.size()));
                input = Ui.inputCommand();
            } else {
                watchedList.remove(removeIndex);
                break;
            }
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
