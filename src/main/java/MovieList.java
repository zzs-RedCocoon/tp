import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

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
     * Used for see detail by movie name.
     * The function will search in the database for the most relevant movies and then prompt
     * the user to enter the index of the movie. 
     *
     * @param inputTitle Movie name entered by the user
     * @return return a movie object that the user is looking for
     */
    public static Movie findMovie(String inputTitle) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println( "No relevant movie found, please try enter the movie name again!");
            Ui.printLine();
            return null;
        }
        Integer id = 1;
        for (Movie relevantMovie: relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        System.out.println("Please enter the id of the movie you're looking for\n" +
                "The program will then proceed with showing the detail of the movie you chose, thanks!");
        Ui.printLine();
        Scanner scan = new Scanner(System.in);;
        String s = scan.nextLine();
        Movie movie;
        try {
            movie = relevantMovies.get(Integer.parseInt(s) - 1);
            return movie;
        } catch (NumberFormatException e) { // cannot parse string to int
            System.out.println("Movie id should be number.");
            return null;
        } catch (IndexOutOfBoundsException e) { //id out of range
            System.out.println("Movie id is out of range.");
            return null;
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
     */
    public void add(String inputTitle) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println( "No relevant movie found, please try enter the movie name again!");
            Ui.printLine();
            return;
        }
        Integer id = 1;
        for (Movie relevantMovie: relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        System.out.println("Please enter the id of the movie you're looking for\n" +
                "The program will then proceed with adding the movie you chose, thanks!");
        Ui.printLine();
        Scanner scan = new Scanner(System.in);;
        String s = scan.nextLine();

        Movie movie;
        try {
            movie = relevantMovies.get(Integer.parseInt(s) - 1);
        } catch (NumberFormatException e) { // cannot parse string to int
            System.out.println("Movie id should be number.");
            return;
        } catch (IndexOutOfBoundsException e) { //id out of range
            System.out.println("Movie id is out of range.");
            return;
        }

        if (!movieList.contains(movie)) {
            this.movieList.add(movie);
        }
        Ui.showAddMovieMessage(movie.toString());
    }

    /**
     * Prints all the movies inside.
     */
    public void list() {
        int i = 1;
        for (Movie movie : movieList) {
            System.out.printf("%d. %s\n", i, movie.toString());
            i++;
        }
    }

    public void filter(String genre) {
        System.out.println("In " + getClass().getName() + ":");
        int i = 1;
        for (Movie movie : movieList) {
            if (Arrays.asList(movie.getGenres()).contains(genre)) {
                System.out.printf("%d. %s\n", i, movie.toString());
                i++;
            }
        }
        if (i == 1) {
            System.out.println("There are no movies of this genre in this list");
        }
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
        String[] genres = parseGenres(genreStrings);

        Movie movie = new Movie(id, title, year, runTime, genres);
        // Commenting this out first because Review is no longer a String.
        /*
        if (movieStrings.length == 5) {
            // Make a normal Movie
            return movie;
        } else {
            // movie entry.
            String review = movieStrings[6];
            return new MovieEntry(movie, review);
        }
        */
        return movie;
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

    /**
     * To be used by user-facing operations to automatically account for indexing problems.
     *
     * @param index
     * @return
     */
    public Movie getMovie(int index) {
        int i = index - 1;
        try {
            return this.movieList.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I don't think you got the right movie number.");
            e.getMessage();
        }

        // Do you want to return null or throw new exception?
        return null;
    }

    @Override
    public String toString() {
        return this.movieList.toString();
    }

    public String getMovieDetail(int index) {
        int i = index - 1;
        try {
            Movie movie = this.movieList.get(i);
            String detail = "Title: " + movie.getTitle() + "\n" +
                    "Year: " + movie.getYear() + "\n" +
                    "Genres: " + movie.getGenresString() + "\n" +
                    "Runtime Minutes: " + movie.getRunTimeMinutes();
            return detail;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I don't think you got the right movie number.");
            e.getMessage();
        }

        // Do you want to return null or throw new exception?
        return null;
    }
}
