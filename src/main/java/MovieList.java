import java.util.ArrayList;
/**
 * MovieList class containing the list of movies.
 *
 * A movie list can be either a watched list or a to-watch list.
 */
public class MovieList {
    protected ArrayList<Movie> movieList;
    public MovieList() {
        this.movieList = new ArrayList<Movie>();
    }
}
