import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {
    /**
     * Show exit message to the user
     */
    public static void showExitMessage() {
        System.out.println("Thanks for using Movie Mate!");
        System.out.println("Hope to see you again soon :))");
    }

    /**
     * Show welcome message to the user
     */
    public static void showWelcomeMessage() {
        System.out.println("Hello from Movie Mate!");
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine() + ", welcome to movie mate");
        System.out.println("Please enter the command to proceed with MovieMate :))");
    }

    /**
     * Show help message to the user
     * TODO change tbc into user guide
     */
    public static void help() {
        System.out.println("First time using Movie Mate?");
        System.out.println("Here is the link to the user guide: ");
        System.out.println("tbc");
        System.out.println("Hope it helps, and have a nice day!");
    }

    /**
     * Shows successfully added movie to the watched/ to-watch list
     * @param movieInfo The String array containing movieID, movie title, year, runtime, and genre
     * @param command The type of list user added the movie into
     */
    public static void showAddMovieMessage(String[] movieInfo, String command) {
        System.out.println("You have successfully added the movie into your" + command + " list!");
        System.out.println("Here is the movie detail");
        for (String info: movieInfo) {
            System.out.println(info);
        }
        System.out.println("Feel free to continue with other features");
    }
}
