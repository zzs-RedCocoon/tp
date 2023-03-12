import java.util.Date;

/**
 * User-interacted Movie to be listed in {@link MovieList} MovieList.
 */
public class MovieEntry extends Movie {
    private Date dateWatched;
    private String review;

    public MovieEntry(String titleID, String title, int year, int runTimeMinutes, String[] genres) {
        super(titleID, title, year, runTimeMinutes, genres);
    }

    public MovieEntry(Movie movie) {
        super(movie);
    }
}
