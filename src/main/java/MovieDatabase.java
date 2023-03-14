import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MovieDatabase {

    // Movie will be sorted, found by its String name.
    private TreeMap<String, Movie> movieDatabase;

    public MovieDatabase(ArrayList<String[]> movieStrings) throws IOException {
        System.out.print("Loading movie database...");
        TreeMap<String, Movie> movies = new TreeMap<String, Movie>();

        // Get the headers first.
        // Not sure if this is required, but good to have I guess?
        // tconst, primaryTitle, startYear, runtimeMinutes, genres
        String[] headers = movieStrings.get(0);
        if (headers.length <  5) {
            System.out.println("There's something wrong with the CSV file.");
            throw (new IOException());
        }

        // Start from 1 to ignore headers.
        for (int i = 1; i < movieStrings.size(); i++) {
            String[] movieString = movieStrings.get(i);
            Movie movie = new Movie(movieString);

            movies.put(movie.toString(), movie);
        }
        this.movieDatabase = movies;
        System.out.println(" Okay, movie database loaded.");
    }
}
