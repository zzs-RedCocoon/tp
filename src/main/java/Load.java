import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Load {

    //Reads in each line in text file separately. For each line, reinitializes the Movie class for that
    //particular movie, then adds its to the movieList/ToWatchList
    public static void readFileContents(ArrayList<Movie> List, String filepath) throws FileNotFoundException {
        File f = new File(filepath);
        Scanner s = new Scanner(f);
        String line;
        while (s.hasNext()) {
            line = s.nextLine();
            int slash1 = line.indexOf("/");
            int slash2 = line.indexOf("/", slash1 + 1);
            int slash3 = line.indexOf("/", slash2 + 1);
            int slash4 = line.indexOf("/", slash3 + 1);
            int slash5 = line.indexOf("/", slash4 + 1);
            int slash6 = line.indexOf("/", slash5 + 1);
            String titleID = line.substring(0, slash1);
            String title = line.substring(slash1 + 1, slash2);
            int year = Integer.parseInt(line.substring(slash2 + 1, slash3));
            int runTimeMinutes = Integer.parseInt(line.substring(slash3 + 1, slash4));
            String[] Genres = new String[3];
            Genres[0] = line.substring(slash4 + 1, slash5);
            Genres[1] = line.substring(slash5 + 1, slash6);
            Genres[2] = line.substring(slash6 + 1);
            Movie movie = new Movie(titleID, title, year, runTimeMinutes, Genres);
            List.add(movie);
        }
    }

    public Load(ArrayList<Movie> List, String filepath) {
        try {
            readFileContents(List, filepath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}