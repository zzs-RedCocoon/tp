package seedu.moviemate.parser;

import seedu.moviemate.command.AddToWatchListCommand;
import seedu.moviemate.command.AddWatchedListCommand;
import seedu.moviemate.command.RandomMovieCommand;
import seedu.moviemate.command.DeleteReviewCommand;
import seedu.moviemate.command.Command;
import seedu.moviemate.command.HelpCommand;
import seedu.moviemate.command.SeeDetailCommand;
import seedu.moviemate.command.RemoveListCommand;
import seedu.moviemate.command.ViewReviewCommand;
import seedu.moviemate.command.WatchListCommand;
import seedu.moviemate.command.ExitCommand;
import seedu.moviemate.command.ListCommand;
import seedu.moviemate.command.FilterCommand;
import seedu.moviemate.command.AddReviewCommand;
import seedu.moviemate.ui.Ui;

/**
 * Parses user input.
 */
public class Parser {

    public static Command parseCommand(String userInputCommand, Ui ui) {
        final String[] split = userInputCommand.trim().split("\\s+", 2);
        final String[] commandTypeAndParams = split.length == 2 ? split : new String[]{split[0], ""};

        String commandType = commandTypeAndParams[0];
        String commandArg = commandTypeAndParams[1];

        switch (commandType) {
        case "watched":
            return new AddWatchedListCommand(commandArg);
        case "remove":
            return new RemoveListCommand(commandArg);
        case "towatch":
            return new AddToWatchListCommand(commandArg);
        case "help":
            return new HelpCommand();
        case "list":
            return new ListCommand();
        case "watchlist":
            return new WatchListCommand();
        case "seedetail":
            return new SeeDetailCommand(commandArg);
        case "addreview":
            return new AddReviewCommand();
        case "deletereview":
            return new DeleteReviewCommand();
        case "viewreview":
            return new ViewReviewCommand();
        case "filter":
            return new FilterCommand(commandArg);
        case "random":
            return new RandomMovieCommand(commandArg);
        case "exit": // fallthrough
        case "bye":
            return new ExitCommand();
        default:
            return new HelpCommand(); // or return UnknownCommand()
        }
    }


    public static int parseIndex(String indexString, int l, int r) {
        int index = 0;

        //cannot parse string to index
        try {
            index = Integer.parseInt(indexString);
        } catch (NumberFormatException e) {
            System.out.println("Movie id should be number");
            return -1;
        }

        //index out of range
        if (index < l - 1 || index > r) { //edited so return 0 is possible for cancelling command
            System.out.println("Movie id out of range");
            return -1;
        }
        return index;
    }

}
