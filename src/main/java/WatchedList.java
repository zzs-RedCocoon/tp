import java.util.Arrays;

public class WatchedList extends MovieList{
    public WatchedList() {
        super();
    }
    public void add(String userInputName, String filePath) {
        String[] movieInfo = ReadCSVFile.find(filePath, userInputName);
        Movie movie = new Movie(movieInfo[0], movieInfo[2], Integer.parseInt(movieInfo[4]),
                Integer.parseInt(movieInfo[5]), Arrays.copyOfRange(movieInfo, 5, movieInfo.length));
        this.movieList.add(movie);
        Ui.showAddMovieMessage(movie.toString(), "watched");
        Ui.printLine();
    }
}
