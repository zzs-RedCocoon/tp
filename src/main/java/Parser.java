/**
 * Parses user input.
 */
public class Parser {

    public static Command parseCommand(String userInputCommand) {
        final String[] split = userInputCommand.trim().split("\\s+", 2);
        final String[] commandTypeAndParams = split.length == 2 ? split : new String[]{split[0], ""};

        String commandType = commandTypeAndParams[0];
        String commandArg = commandTypeAndParams[1];

        switch (commandType) {
            case "watched":
                return new AddWatchedListCommand(commandArg);
//            case "remove":
//                switch (commandArg) {
//                    case "watched":
//                        //remove from watched list
//                        Ui.showListMessage(watchedList);
//                        int removeWatchedIndex = Integer.parseInt(inputCommand(scan));
//                        watchedList.remove(removeWatchedIndex);
//                        Ui.showDeleteMessage();
//                        break;
//                    case "towatch":
//                        //remove from towatch list
//                        Ui.showListMessage(toWatchList);
//                        int removeToWatchIndex = Integer.parseInt(inputCommand(scan));
//                        toWatchList.remove(removeToWatchIndex);
//                        Ui.showDeleteMessage();
//                        break;
//                    default:
//                        break;
//                }
//                // fallthrough
            case "towatch":
                return new AddToWatchListCommand(commandArg);
            case "help":
                return new HelpCommand();
            case "list":
                return new ListCommand();
            case "watchlist":
                return new WatchListCommand();
//            case "seedetail":
//                switch (commandArg) {
//                    case "watched":
//                        // list watched list for the user to choose
//                        Ui.showListMessage(watchedList);
//                        System.out.println("Please enter the movie index that you would like to see the detail of it!");
//                        int seeDetailWatchedIndex = Integer.parseInt(inputCommand(scan));
//                        System.out.println(watchedList.getMovieDetail(seeDetailWatchedIndex));
//                        Ui.showDetailMessage();
//                        break;
//                    case "towatch":
//                        // list to-watch list for the user to choose
//                        Ui.showListMessage(toWatchList);
//                        System.out.println("Please enter the movie index that you would like to see the detail of it!");
//                        int seeDetailToWatchIndex = Integer.parseInt(inputCommand(scan));
//                        System.out.println(toWatchList.getMovieDetail(seeDetailToWatchIndex));
//                        Ui.showDetailMessage();
//                        break;
//                    case "movie":
//                        System.out.println("Please enter the movie name that you would like to see the detail of it!");
//                        String movieName = inputCommand(scan);
//                        MovieList.findMovieDetail(movieName);
//                        Ui.showDetailMessage();
//                        break;
//                    default:
//                        System.out.println("Please follow the format: seedetail [watched/towatch/movie]");
//                        assert false: "Command entered is not a correct format";
//                        break;
//                }
//                // fallthrough
//                break;
            case "addreview":
                return new AddReviewCommand(commandArg);
            case "deletereview":
                return new DeleteReviewCommand(commandArg);
            case "viewreview":
                return new ViewReviewCommand(commandArg);
            case "filter":
                return new FilterCommand(commandArg);
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
            return -1;
        }

        //index out of range
        if (index < l || index > r) {
            return -1;
        }
        return index;
    }

}
