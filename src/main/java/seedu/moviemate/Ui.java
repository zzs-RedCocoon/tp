package seedu.moviemate;

import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {

    /**
     * Scan in the user input and trim extra white space.
     * If there is no input, continue to scan the next line for input.
     *
     * @return The string that the user entered
     */
    public static String inputCommand() {
        Scanner scan = new Scanner(System.in);
        String s = "";
        s = scan.nextLine();

        while (s.trim().isEmpty() || s.trim().charAt(0) == '#') {
            if (scan.hasNextLine()) {
                s = scan.nextLine();
            }
        }
        return s;
    }

    /**
     * Show exit message to the user
     */
    public static void showExitMessage() {
        System.out.println("Thanks for using Movie Mate!");
        System.out.println("Hope to see you again soon :))");
    }
    public static void printLine() {
        System.out.println("-------------------------------------------------------------------------");
    }

    /**
     * Show welcome message to the user
     */
    public static void showWelcomeMessage() {
        System.out.println("Hello from Movie Mate!");
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println("Hello " + name + ", welcome to movie mate");
        System.out.println("Please enter the command to proceed with MovieMate :))");
    }

    /**
     * Show help message to the user
     * TODO change tbc into user guide
     */
    public static void printHelp() {
        System.out.println("First time using Movie Mate?");
        System.out.println("Here is the link to the user guide: ");
        System.out.println("tbc");
        System.out.println("Hope it helps, and have a nice day!");
    }

    /**
     * Shows successfully added movie to the watched/ to-watch list
     * @param movie The String containing movie title, year, runtime, and genre
     */
    public static void showAddMovieMessage(String movie) {
        System.out.println("You have successfully added the movie into your list!");
        System.out.println("Here is the movie detail");
        System.out.println(movie);
        System.out.println("Feel free to continue with other features");
    }

    /**
     * Show the movie list, watched or to-watch, to the user.
     * @param movieList The movie list to show
     */
    public static void showListMessage(MovieList movieList) {
        Integer watchId = 1;
        for (Movie watched: movieList.movieList) {
            System.out.print(watchId);
            System.out.print(". ");
            System.out.println(watched.getTitle());
            watchId += 1;
        }
        printLine();
        System.out.println("These are the movies in your list, hope it helps!");
    }

    /**
     * Show successfully deleted movie from list to the user
     */
    public static void showDeleteMessage() {
        System.out.println("The movie has been deleted for you!");
    }
    /**
     * Show feedback message to the user after showing the movie detail
     */
    public static void showDetailMessage() {
        System.out.println("The movie details are showed above!");
        System.out.println("Please feel free to continue with other features :))");
    }
}
