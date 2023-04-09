package seedu.moviemate.movie;

import seedu.moviemate.parser.Parser;
import seedu.moviemate.storage.MovieDatabase;
import seedu.moviemate.ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
     *
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

    public boolean empty() {
        return this.movieList.isEmpty();
    }

    /**
     * Gets the index of a movie in the movieList
     * Also can be used to check if a movie is inside the list at all
     *
     * @param movie to get the index of
     * @return index in list, -1 if movie is not found
     */
    public int getIndex(Movie movie) {
        //must do this instead of simply this.movieList.indexOf because Movie with review
        //and same Movie without review are treated differently by program, so find/indexOf
        //will be unable to locate the movie with review even if it is actually in the list
        int index = 1;
        for (Movie mv : this.movieList) {
            if ((mv.getTitle()).equals(movie.getTitle())
                && mv.getYear() == movie.getYear()
                    && mv.getRunTimeMinutes() == movie.getRunTimeMinutes()
                        && (mv.getGenresString()).equals(movie.getGenresString())) {
                return index;
            }
            index += 1;
        }
        return -1;
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
            System.out.println("No relevant movie found, please try entering the movie name again!");
            return;
        }
        if (inputTitle.isBlank()) {
            System.out.println("<Movie Name> cannot be left blank. Please try entering " +
                    "the seedetail movie command and movie name again!");
            return;
        }
        int id = 1;
        for (Movie relevantMovie : relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        System.out.println("Please enter the id of the movie you're looking for\n" +
                "The program will then show the detail of the movie you chose, thanks!");
        Ui.printLine();

        String input = Ui.inputCommand();
        Movie movie;
        while (true) {
            int index = Parser.parseIndex(input, 1, relevantMovies.size());
            if (index < 0) {
                System.out.println(String.format(
                        "Please enter a valid index from 1 to %d", relevantMovies.size()));
                input = Ui.inputCommand();
            } else if (index == 0) {
                System.out.println("Exit input acknowledged. Cancelling last command...");
                return;
            } else {
                movie = relevantMovies.get(index - 1);
                if (movie.getMovieDetail() != null) {
                    System.out.println(movie.getMovieDetail());
                }
                Ui.printLine();
                Ui.printSeedetailSuccess();
                break;
            }
        }
    }

    /**
     * Add a movie to the contained list.
     *
     * @param movie a movie.
     */
    public void add(Movie movie) {
        this.movieList.add(movie);
    }

    /**
     * Adds a movie to the WATCHED list from the list of movies.
     *
     * @param inputTitle  title of movie as input by user.
     * @param watchedList list of watched movies
     * @param toWatchList list of movies user plans to watch
     * @param ui the Ui object to use for displaying messages to the user
     */
    public void addWatched(String inputTitle, WatchedList watchedList, ToWatchList toWatchList, Ui ui) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println("No relevant movie found, please try entering the watched " +
                    "command and movie name again!");
            return;
        }
        if (inputTitle.isBlank()) {
            System.out.println("<Movie Name> cannot be left blank, please try entering " +
                    "the watched command and movie name again!");
            return;
        }
        int id = 1;
        for (Movie relevantMovie : relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        ui.printPromptIndex();

        String input = ui.inputCommand();
        Movie movie;
        while (true) {
            int addIndex = Parser.parseIndex(input, 1, relevantMovies.size());
            if (addIndex < 0) {
                ui.printRequireValidIndex(1, relevantMovies.size());
                input = ui.inputCommand();
                continue;
            }
            if (addIndex == 0) {
                ui.printExitInputIndex();
                return;
            }
            // happy path
            movie = relevantMovies.get(addIndex - 1);
            break;

        }

        //if movie being added to watched list is in to-watch list, it is deleted in to-watch list
        if (toWatchList.getIndex(movie) != -1) {
            toWatchList.remove(movie);
        }
        if (watchedList.getIndex(movie) == -1) {
            watchedList.add(movie);
            Ui.showAddMovieMessage(movie.toString());
        } else {
            System.out.println("That movie is already in your watched list.");
        }

    }

    /**
     * Adds a movie to the TO-WATCH list from the list of movies.
     *
     * @param inputTitle  title of movie as input by user.
     * @param watchedList list of watched movies
     * @param toWatchList list of movies user plans to watch
     * @param ui the Ui object to use for displaying messages to the user
     */
    public void addToWatch(String inputTitle, WatchedList watchedList, ToWatchList toWatchList, Ui ui) {
        ArrayList<Movie> relevantMovies = MovieDatabase.find(inputTitle);
        if (relevantMovies.size() == 0) {
            System.out.println("No relevant movie found, please try entering the towatch " +
                    "command and movie name again!");
            return;
        }
        if (inputTitle.isBlank()) {
            System.out.println("<Movie Name> cannot be left blank, please try entering " +
                    "the towatch command and movie name again!");
            return;
        }
        int id = 1;
        for (Movie relevantMovie : relevantMovies) {
            System.out.println(id + ". " + relevantMovie.toString());
            id += 1;
        }
        ui.printPromptIndex();

        String input = ui.inputCommand();
        Movie movie;
        while (true) {
            int addIndex = Parser.parseIndex(input, 1, relevantMovies.size());
            if (addIndex < 0) {
                System.out.println(String.format(
                        "Please enter a valid index from 1 to %d", relevantMovies.size()));
                input = Ui.inputCommand();
                continue;
            }
            if (addIndex == 0) {
                ui.printExitInputIndex();
                return;
            }
            // happy path
            movie = relevantMovies.get(addIndex - 1);
            break;
        }

        //if movie being added to to-watch list is in watched list, user is prompted if they want
        //to remove it from watched list
        if (watchedList.getIndex(movie) != -1) {
            System.out.println("You have already watched this movie!\n" +
                    "Should we delete it from your watched list? [Y/N]");
            while (true) {
                input = Ui.inputCommand();
                if (input.equalsIgnoreCase("N")) {
                    return;
                }
                if (input.equalsIgnoreCase("Y")) {
                    //must delete any existing review for the movie, otherwise remove will bug out
                    int MovieIndex = watchedList.getIndex(movie);
                    Movie deletedMovie = new Movie(movie);
                    watchedList.movieList.set(MovieIndex - 1, deletedMovie);
                    watchedList.remove(deletedMovie);
                    break;
                } else {
                    System.out.println("Invalid format. Please enter either 'Y' or 'N'.");
                }
            }
        }
        if (toWatchList.getIndex(movie) == -1) {
            toWatchList.add(movie);
            Ui.showAddMovieMessage(movie.toString());
        } else {
            System.out.println("That movie is already in your to-watch list.");
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
        if (genre.isBlank()) {
            System.out.println("Genre description cannot be left blank. Please try entering " +
                    "the filter command and genre again!");
            return;
        }
        String classname = getClass().getName();
        if (classname.equals("seedu.moviemate.movie.WatchedList")) {
            System.out.println("In watched list:");
        } else if (classname.equals("seedu.moviemate.movie.ToWatchList")) {
            System.out.println("In to-watch list:");
        }
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
     *
     * @param movie a movie.
     */
    public void remove(Movie movie) {
        this.movieList.remove(movie);
    }

    /**
     * Remove a movie from the contained list.
     *
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

        assert movieStrings != null : "Movie strings array cannot be null";
        assert movieStrings.length == 5 : "Movie strings array must have length of 5";
        assert id != null : "Movie ID cannot be null";
        assert title != null : "Movie title cannot be null";
        assert genreStrings != null : "Movie genres string cannot be null";

        Movie movie = new Movie(id, title, year, runTime, genres);
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

        return null;
    }

    @Override
    public String toString() {
        return this.movieList.toString();
    }

    public String getMovieDetail(int index) {
        int i = index - 1;
        Movie movie = this.movieList.get(i);

        String detail = movie.getMovieDetail();
        return detail;
    }
}
