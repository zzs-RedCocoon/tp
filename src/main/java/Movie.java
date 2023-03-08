/**
 * Movie class containing the basic essentials of a movie.
 *
 * A movie is categorised by its title (name), titleID (Alphanumeric way to categorise)
 * Year of release, runtime/length (in minutes), and an array of up to 3 Genres.
 * Data is provided by IMDB.
 */
public class Movie {
    private final String titleID;
    private final String title;
    private final int year;
    private final int runTimeMinutes;
    private final String[] genres;

    public Movie(String titleID, String title, int year, int runTimeMinutes, String[] genres) {
        this.titleID = titleID;
        this.title = title;
        this.year = year;
        this.runTimeMinutes = runTimeMinutes;
        this.genres = genres;
    }
}
