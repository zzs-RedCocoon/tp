import java.sql.SQLOutput;
import java.util.Scanner;
/**
 * Movie Mate class is the main class that starts running the program.
 *
 */
public class MovieMate {

    private WatchedList watchedList = new WatchedList();
    private ToWatchList toWatchList = new ToWatchList();
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
                // list the to-wathc list
                break;
            case "exit":
            case "bye":
                // Fallthrough
                // TODO: Extract this process and print message, save data, upon exit.
                System.out.println("Bye!");
                System.exit(0);
            default:
                Ui.help();
                break;
            }
        }
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
