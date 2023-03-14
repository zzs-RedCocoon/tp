import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * MovieList class containing the list of movies.
 * A movie list can be either a watched list or a to-watch list.
 */
public class MovieList {
    protected ArrayList<Movie> movieList;

    /**
     * Default constructed for empty MovieList.
     */
    public MovieList() {
        this.movieList = new ArrayList<Movie>();
    }

    /**
     * Overloaded constructor with filled MovieList.
     * @param movieList List of movies.
     */
    public MovieList(Collection<Movie> movieList) {
        this.movieList = new ArrayList<Movie>(movieList);
    }

    public MovieList(ArrayList<String[]> movieStrings) {
        this.movieList = new ArrayList<Movie>();
        for (String[] movieString : movieStrings) {
            this.movieList.add(createMovie(movieString));
        }
    }

    /**
     * Add a movie to the contained list.
     * @param movie a movie.
     */
    public void add(Movie movie) {
        this.movieList.add(movie);
    }

    /**
     * Adds a movie from the list of movies.
     * @param inputTitle title of movie as input by user.
     * @param filePath where the CSV File is located.
     */
    public void add(String inputTitle, String filePath) {
        String[] movieInfo = ReadCSVFile.find(filePath, inputTitle);
        Movie movie = new Movie(movieInfo[0], movieInfo[2], Integer.parseInt(movieInfo[4]),
                Integer.parseInt(movieInfo[5]), Arrays.copyOfRange(movieInfo, 5, movieInfo.length));
        this.movieList.add(movie);
    }

    /**
     * Remove a specific movie from the contained list.
     * @param movie a movie.
     */
    public void remove(Movie movie) {
        this.movieList.remove(movie);
    }

    /**
     * Remove a movie from the contained list.
     * @param index 1-indexed index of the movie in list.
     */
    public void remove(int index) {
        index = index - 1; // Offset 1-index
        this.movieList.remove(index);
    }

    public Movie createMovie(String[] movieStrings) {
        String id = movieStrings[0];
        String title = movieStrings[1];
        int year = Integer.parseInt(movieStrings[2]);
        int runTime = Integer.parseInt(movieStrings[3]);
        String genreStrings = movieStrings[4];
        String[] genres = parseGenres(movieStrings[5]);

        Movie movie = new Movie(id, title, year, runTime, genres);
        if (movieStrings.length == 5) {
            // Make a normal Movie
            return movie;
        } else {
            // movie entry.
            String review = movieStrings[6];
            return new MovieEntry(movie, review);
        }
    }

    private String[] parseGenres(String genreStrings) {
        String[] genres = genreStrings.split(",");
        return genres;
    }

    public String getFileWriteFormat() {
        String output = "";
        for (Movie movie : this.movieList) {
            output += movie.getWriteFormat() + '\n';
        }
        return output;
    }

    @Override
    public String toString() {
        return this.movieList.toString();
    }
}
