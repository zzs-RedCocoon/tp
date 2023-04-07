package seedu.moviemate;

import org.junit.jupiter.api.Test;
import seedu.moviemate.movie.Movie;
import seedu.moviemate.movie.MovieList;
import seedu.moviemate.storage.MovieDatabase;
import seedu.moviemate.storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieListTest {
    private static MovieDatabase movieDatabase;

    static {
        try {
            movieDatabase = new MovieDatabase(new Storage().loadDatabase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveByIndex() {

        // Create a new MovieList object with the movie list
        MovieList movieListObj = new MovieList();
        movieListObj.add(MovieDatabase.find("cat").get(0));
        movieListObj.add(MovieDatabase.find("cat").get(1));
        movieListObj.add(MovieDatabase.find("cat").get(2));
        System.out.println(movieListObj.movieList.size());

        String title1 = movieListObj.movieList.get(0).getTitle();
        String title2 = movieListObj.movieList.get(1).getTitle();
        String title3 = movieListObj.movieList.get(2).getTitle();

        // Remove the second movie (index 1)
        movieListObj.remove(2);

        // Assert that the movie list now contains only 2 movies
        assertEquals(2, movieListObj.movieList.size());
        
        // Assert that the second movie (index 1) has been removed
        assertEquals(title1, movieListObj.movieList.get(0).getTitle());
        assertEquals(title3, movieListObj.movieList.get(1).getTitle());
    }
}

