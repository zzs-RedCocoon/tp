import java.util.Scanner;
/**
 * Movie Mate class is the main class that starts running the program.
 *
 */
public class MovieMate {
    public static void main(String[] args) {
        System.out.println("Hello from Movie Mate!");
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine() + ", welcome to movie mate");
    }
}
