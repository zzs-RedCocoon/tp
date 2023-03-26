import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Movie Mate class is the main class that starts running the program.
 */
public class MovieMate {
    private static Ui ui;
    private static Parser parser;
    private static Logger logger;
    private static Storage storage;

    private static WatchedList watchedList;
    private static ToWatchList toWatchList;
    private static MovieDatabase movieDatabase;

    private static String watchedListPath;
    private static String toWatchListPath;


    public MovieMate(String watchedListPath, String toWatchListPath){
        ui = new Ui();
        parser = new Parser();
        logger = Logger.getLogger("MovieMate");
        storage = new Storage();

        try {
            movieDatabase = new MovieDatabase(storage.loadDatabase());
        } catch (IOException e) {
            logger.log(Level.WARNING, "processing error");
            System.out.println("Critical error: You might be missing a database file.");
            System.exit(1);
        }

        watchedList = new WatchedList(storage.load(watchedListPath));
        toWatchList = new ToWatchList(storage.load(toWatchListPath));
    }

    private void start(){
        ui.showWelcomeMessage();
    }

    private static void exit() {
        ui.showExitMessage();
        ui.printLine();
        storage.writeToFile(watchedListPath, watchedList.getFileWriteFormat());
        storage.writeToFile(toWatchListPath, toWatchList.getFileWriteFormat());
        System.exit(0);
    }

    public void run(){
        start();
        Command command;
        do {
            String userInput = ui.inputCommand();
            command = parser.parseCommand(userInput);
            command.execute(watchedList, toWatchList, ui, storage);
        } while (!ExitCommand.isExit(command));
        exit();
    }

    public static void main(String[] args) {
        watchedListPath = "data/moviemate_watchlist.txt";
        toWatchListPath = "data/moviemate_towatch.txt";

        new MovieMate(watchedListPath, toWatchListPath).run();
    }
}
