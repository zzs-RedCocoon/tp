
public class SeeDetailCommand extends Command {

    private String movieListType;

    public SeeDetailCommand(String movieListType){
        this.movieListType = movieListType;
    }

    public void seeWatchedMovieDetail(WatchedList watchedList, Ui ui) {
        // list watched list for the user to choose
        Ui.showListMessage(watchedList);
        System.out.println("Please enter the movie index that you would like to see the detail of it!");
        int seeDetailWatchedIndex = Integer.parseInt(ui.inputCommand());
        System.out.println(watchedList.getMovieDetail(seeDetailWatchedIndex));
        Ui.showDetailMessage();
    }

    public void seeToWatchMovieDetail(ToWatchList toWatchList, Ui ui) {
        // list to-watch list for the user to choose
        Ui.showListMessage(toWatchList);
        System.out.println("Please enter the movie index that you would like to see the detail of it!");
        int seeDetailToWatchIndex = Integer.parseInt(ui.inputCommand());
        System.out.println(toWatchList.getMovieDetail(seeDetailToWatchIndex));
        Ui.showDetailMessage();
    }

    public void seeMovieDetailByName(Ui ui) {
        System.out.println("Please enter the movie name that you would like to see the detail of it!");
        String movieName = ui.inputCommand();
        MovieList.findMovieDetail(movieName);
        Ui.showDetailMessage();
    }

    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (movieListType) {
        case "watched":
            seeWatchedMovieDetail(watchedList, ui);
            break;
        case "towatch":
            seeToWatchMovieDetail(toWatchList, ui);
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
