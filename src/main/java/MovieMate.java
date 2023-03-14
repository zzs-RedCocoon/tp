import java.util.Arrays;
import java.util.Scanner;
/**
 * Movie Mate class is the main class that starts running the program.
 *
 */
public class MovieMate {
    private static Storage storage = new Storage();
    private static String filePath = "data/movies.csv";
    private static String watchedListPath = "data/moviemate_data.txt";
    private static WatchedList watchedList = new WatchedList(storage.load(watchedListPath));
    private static ToWatchList toWatchList = new ToWatchList();
    public static void main(String[] args) {
        Ui.showWelcomeMessage();

        // Initialise Scanner
        Scanner scan = new Scanner(System.in);

        while(true) {
            // Get user input and parse it.
            String userInput = inputCommand(scan);
            String[] commandTypeAndParams = Parser.parseCommand(userInput);
            String commandType = commandTypeAndParams[0];
            String commandArg = commandTypeAndParams[1];

            switch (commandType) {
            case "watched":
                // add to watched list
                String[] movieInfo = ReadCSVFile.find(filePath, commandArg);
                Movie movie = new Movie(movieInfo[0], movieInfo[2], Integer.parseInt(movieInfo[4]),
                        Integer.parseInt(movieInfo[5]), Arrays.copyOfRange(movieInfo, 5, movieInfo.length));
                watchedList.add(movie);
                System.out.println("added: " + movie);
                System.out.println(watchedList);
                break;
            case "towatch":
                // add to to-watch list
                break;
            case "help":
                Ui.help();
                break;
            case "list":
                // list the watched list
                break;
            case "watchlist":
                // list the to-watch list
                break;
            case "exit":
                // fallthrough
            case "bye":
                System.out.println("Exiting");
                exit();
                break;
            default:
                Ui.help();
                break;
            }
        }

    }

    private static void exit() {
        Ui.showExitMessage();
        storage.writeToFile(watchedListPath, watchedList.getFileWriteFormat());
        System.exit(0);
    }

    /**
     * Scan in the user input and trim extra white space.
     * If there is no input, continue to scan the next line for input.
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
