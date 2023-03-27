package seedu.moviemate;

public class FilterCommand extends Command {
    private String genre;

    public FilterCommand(String genre) {
        this.genre = genre;
    }

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.filter(genre);
        toWatchList.filter(genre);
    }
}
