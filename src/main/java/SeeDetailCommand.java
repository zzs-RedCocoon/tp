
public class SeeDetailCommand extends Command {

    private String movieListType;

    public SeeDetailCommand(String movieListType){
        this.movieListType = movieListType;
    }

    public void seeMovieDetail(MovieList movieList, Ui ui) {
        // list watched list for the user to choose
        ui.showListMessage(movieList);
        System.out.println("Please enter the movie index that you would like to see the detail of it!");
        int seeDetailWatchedIndex = Integer.parseInt(ui.inputCommand());
        System.out.println(movieList.getMovieDetail(seeDetailWatchedIndex));
        ui.showDetailMessage();
    }

    public void seeMovieDetailByName(Ui ui) {
        System.out.println("Please enter the movie name that you would like to see the detail of it!");
        String movieName = ui.inputCommand();
        MovieList.findMovieDetail(movieName);
        ui.showDetailMessage();
    }

    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (movieListType) {
        case "watched":
            seeMovieDetail(watchedList, ui);
            break;
        case "towatch":
            seeMovieDetail(toWatchList, ui);
            break;
        case "movie":
            seeMovieDetailByName(ui);
            break;
        default:
            System.out.println("Please follow the format: seedetail [watched/towatch/movie]");
            //assert false : "Command entered is not a correct format";
            break;
        }
    }
}
