import java.util.Arrays;

/**
 * A list of movies the user plans to watch.
 */
public class ToWatchList extends MovieList{

    public ToWatchList() {
        super();
    }
    public void add(String userInputName, String filePath) {
        String[] movieInfo = ReadCSVFile.find(filePath, userInputName);
        Movie movie = new Movie(movieInfo[0], movieInfo[2], Integer.parseInt(movieInfo[4]),
                Integer.parseInt(movieInfo[5]), Arrays.copyOfRange(movieInfo, 5, movieInfo.length));
        this.movieList.add(movie);
        Ui.showAddMovieMessage(movie.toString(), "to-watch");
        Ui.printLine();
    }
}
