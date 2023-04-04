package seedu.moviemate.movie;

import seedu.moviemate.storage.MovieDatabase;
import seedu.moviemate.ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * MovieList class containing the list of movies.
 * A movie list can be either a watched list or a to-watch list.
 */
public class MovieList {
    public ArrayList<Movie> movieList;

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
     * @return true is relevant list is empty
     */
    public boolean empty() {
        return this.movieList.isEmpty();
    }

    /**
     *
     * @param movie
     * @return true if movie can be found in the related list
     */
    public boolean contains(Movie movie) {
        return this.movieList.contains(movie);
    }

    /**
     * Used for see detail by movie name.
     * The function will search in the database for the most relevant movies and then prompt
     * the user to enter the index of the movie.
     * It will then show the movie detail to the user
     *
     * @param inputTitle Movie name entered by the user
     */
    public static void findMovieDetail(String inputTitle) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println( "No relevant movie found, please try entering the movie name again!");
            return;
        }
        int id = 1;
        for (Movie relevantMovie: relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        System.out.println("Please enter the id of the movie you're looking for\n" +
                "The program will then show the detail of the movie you chose, thanks!");
        Ui.printLine();
        Scanner scan = new Scanner(System.in);;
        String s = scan.nextLine();
        Movie movie;
        try {
            movie = relevantMovies.get(Integer.parseInt(s) - 1);
            if (movie.getMovieDetail() != null) {
                System.out.println(movie.getMovieDetail());
            }
            Ui.printLine();
            Ui.showDetailMessage();
            return;
        } catch (NumberFormatException e) { // cannot parse string to int
            System.out.println("Movie id should be number.\n" + "Please try entering the command again.");
            return;
        } catch (IndexOutOfBoundsException e) { //id out of range
            System.out.println("Movie id is out of range.\n" + "Please try entering the command again.");
            return;
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
     * Adds a movie to watched list from the list of movies.
     * @param inputTitle title of movie as input by user.
     * @param watchedList the list of watched movies.
     * @param toWatchList the list of movies user plans to watch
     */
    public void addwatched(String inputTitle, WatchedList watchedList, ToWatchList toWatchList) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println("No relevant movie found, please try entering the movie name again!");
            Ui.printLine();
            return;
        }
        int id = 1;
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
            System.out.println("Movie id should be number.\n" +
                    "Please try entering the command again to add movie!");
            return;
        } catch (IndexOutOfBoundsException e) { //id out of range
            System.out.println("Movie id is out of range.\n" +
                    "Please try entering the command again to add movie!");
            return;
        }

        //if movie being added to watched list is in to-watch list, it is deleted in to-watch list
        if (toWatchList.contains(movie)) {
            toWatchList.remove(movie);
        }
        if (!watchedList.contains(movie)) {
            watchedList.add(movie);
            Ui.showAddMovieMessage(movie.toString());
        }
        else {
            System.out.println("That movie is already in your list.");
        }

    }

    /**
     * Adds a movie to to-watch list from the list of movies.
     * @param inputTitle title of movie as input by user.
     * @param watchedList the list of watched movies.
     * @param toWatchList the list of movies user plans to watch
     */
    public void addtowatch(String inputTitle, WatchedList watchedList, ToWatchList toWatchList) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println("No relevant movie found, please try entering the movie name again!");
            Ui.printLine();
            return;
        }
        int id = 1;
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
            System.out.println("Movie id should be number.\n" +
                    "Please try entering the command again to add movie!");
            return;
        } catch (IndexOutOfBoundsException e) { //id out of range
            System.out.println("Movie id is out of range.\n" +
                    "Please try entering the command again to add movie!");
            return;
        }

        //if movie being added to to-watch list is in watched list, user is prompted if they want
        //to remove it from watched list
        if (watchedList.contains(movie)) {
            System.out.println("You have already watched this movie!\n" +
                    "Should we delete it from your watched list? [Y/N]");
            while (true) {
                s = scan.nextLine();
                if (s.equalsIgnoreCase("N")) {
                    return;
                }
                if (s.equalsIgnoreCase("Y")) {
                    break;
                } else {
                    System.out.println("Invalid format. Please enter either 'Y' or 'N'.");
                }
            }
        }
        if (!toWatchList.contains(movie)) {
            toWatchList.add(movie);
            Ui.showAddMovieMessage(movie.toString());
        }
        else {
            System.out.println("That movie is already in your list.");
        }

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
            if (Arrays.asList(movie.getGenresFilter()).contains(genre.toLowerCase())) {
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
        try {
            this.movieList.remove(index);
            Ui.showDeleteMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Movie id out of range");
        }
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
            System.out.println("I don't think you got the right movie number.\n" +
                    "Please try entering the command again");
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
