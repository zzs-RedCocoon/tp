
public class SeeDetailCommand extends Command {

    private String movieListType;
    //@@author chao2048
    public SeeDetailCommand(String movieListType){
        this.movieListType = movieListType;
    }
    public void seeMovieDetail(MovieList movieList, Ui ui) {
        // list watched list for the user to choose
        ui.showListMessage(movieList);
        System.out.println("Please enter the movie index that you would like to see the detail of it!");
        String inputIndex = ui.inputCommand();
        int seeDetailWatchedIndex = Parser.parseIndex(inputIndex, 1, movieList.movieList.size());
        if (seeDetailWatchedIndex < 0) {
            System.out.println(String.format("Please try enter the seedetail command again and make sure the index is valid. \n" +
                            "The valid index range is 1 to %d", movieList.movieList.size()));
            return;
        }
        System.out.println(movieList.getMovieDetail(seeDetailWatchedIndex));
        ui.showDetailMessage();
        ui.printLine();
    }

    public void seeMovieDetailByName(Ui ui) {
        System.out.println("Please enter the movie name that you would like to see the detail of it!");
        String movieName = ui.inputCommand();
        MovieList.findMovieDetail(movieName);
        ui.printLine();
        ui.showDetailMessage();
        ui.printLine();
    }
    //@@author chao2048

    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (movieListType) {
        case "watched":
            assert movieListType.equals("watched");
            seeMovieDetail(watchedList, ui);
            break;
        case "towatch":
            assert movieListType.equals("towatch");
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
