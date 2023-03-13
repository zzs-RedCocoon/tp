import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {
    public static void showExitMessage() {
        System.out.println("Thanks for using Movie Mate!");
        System.out.println("Hope to see you again soon :))");
    }
    public static void showWelcomeMessage() {
        System.out.println("Hello from Movie Mate!");
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine() + ", welcome to movie mate");
        System.out.println("Please enter the command to proceed with MovieMate :))");
    }
    public static void help() {
        System.out.println("First time using Movie Mate?");
        System.out.println("Here is the link to the user guide: ");
        System.out.println("tbc");
        System.out.println("Hope it helps, and have a nice day!");
    }
}
