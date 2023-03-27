import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Movie Mate class is the main class that starts running the program.
 */
public class MovieMate {
    private static final Logger logger = Logger.getLogger("MovieMate");

    private static final Storage storage = new Storage();
    private static String watchedListPath = "data/moviemate_watchlist.txt";
    private static String toWatchListPath = "data/moviemate_towatch.txt";
    private static WatchedList watchedList = new WatchedList(storage.load(watchedListPath));
    private static ToWatchList toWatchList = new ToWatchList(storage.load(toWatchListPath));
    private static MovieDatabase movieDatabase;

    static {
        try {
            movieDatabase = new MovieDatabase(storage.loadDatabase());
        } catch (IOException e) {
            logger.log(Level.WARNING, "processing error");
            System.out.println("Critical error: You might be missing a database file.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        //assert true: "dummy assertion set to true";

        Ui.showWelcomeMessage();

        // Initialise Scanner
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Get user input and parse it.
            String userInput = inputCommand(scan);
            String[] commandTypeAndParams = Parser.parseCommand(userInput);
            String commandType = commandTypeAndParams[0];
            String commandArg = commandTypeAndParams[1];

            switch (commandType) {
            case "watched":
                // add to watched list
                watchedList.add(commandArg);
                break;
            case "remove":
                switch (commandArg) {
                case "watched":
                    //remove from watched list
                    int removeWatchedIndex = Integer.parseInt(inputCommand(scan));
                    watchedList.remove(removeWatchedIndex);
                    Ui.showDeleteMessage();
                    break;
                case "towatch":
                    //remove from towatch list
                    int removeToWatchIndex = Integer.parseInt(inputCommand(scan));
                    toWatchList.remove(removeToWatchIndex);
                    Ui.showDeleteMessage();
                    break;
                default:
                    System.out.println("'remove watched' to remove from your watched list");
                    System.out.println("'removed unwatched' to remove from your to-watch list");
                    break;
                }
                // fallthrough
            case "towatch":
                // add to to-watch list
                toWatchList.add(commandArg);
                break;
            case "help":
                Ui.help();
                Ui.printLine();
                break;
            case "list":
                // list the watched list
                watchedList.list();
                Ui.printLine();
                break;
            case "watchlist":
                // list the to-watch list
                toWatchList.list();
                Ui.printLine();
                break;
            case "seedetail":
                switch (commandArg) {
                case "watched":
                    // list watched list for the user to choose
                    Ui.showListMessage(watchedList);
                    System.out.println("Please enter the movie index that you would like to see the detail of it!");
                    int seeDetailWatchedIndex = Integer.parseInt(inputCommand(scan));
                    System.out.println(watchedList.getMovieDetail(seeDetailWatchedIndex));
                    Ui.showDetailMessage();
                    break;
                case "towatch":
                    // list to-watch list for the user to choose
                    Ui.showListMessage(toWatchList);
                    System.out.println("Please enter the movie index that you would like to see the detail of it!");
                    int seeDetailToWatchIndex = Integer.parseInt(inputCommand(scan));
                    System.out.println(toWatchList.getMovieDetail(seeDetailToWatchIndex));
                    Ui.showDetailMessage();
                    break;
                case "movie":
                    System.out.println("Please enter the movie name that you would like to see the detail of it!");
                    String movieName = inputCommand(scan);
                    MovieList.findMovieDetail(movieName);
                    Ui.showDetailMessage();
                    break;
                default:
                    System.out.println("Please follow the format: seedetail [watched/towatch/movie]");
                    assert false: "Command entered is not a correct format";
                    break;
                }
                // fallthrough
                break;
            case "addreview":
                watchedList.setReview(commandArg);
                Ui.printLine();
                break;
            case "deletereview":
                watchedList.deleteReview(commandArg);
                Ui.printLine();
                break;
            case "viewreview":
                watchedList.viewReview(commandArg);
                Ui.printLine();
                break;
            case "filter":
                watchedList.filter(commandArg);
                toWatchList.filter(commandArg);
                Ui.printLine();
                break;
            case "exit":
                // fallthrough
            case "bye":
                exit();
                break;
            default:
                assert false: "Command is invalid";
                Ui.help();
                break;
            }
        }

    }

    private static void exit() {
        Ui.showExitMessage();
        Ui.printLine();
        storage.writeToFile(watchedListPath, watchedList.getFileWriteFormat());
        storage.writeToFile(toWatchListPath, toWatchList.getFileWriteFormat());
        System.exit(0);
    }

    /**
     * Scan in the user input and trim extra white space.
     * If there is no input, continue to scan the next line for input.
     *
     * @return The string that the user entered
     */
    private static String inputCommand(Scanner scan) {
        String s = "";
        s = scan.nextLine();
        while (s.trim().isEmpty() || s.trim().charAt(0) == '#') {
            s = scan.nextLine();
        }
        return s;
    }
}
