package seedu.moviemate;

public class AddToWatchListCommand extends Command {
    private String inputTitle;

    public AddToWatchListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public  void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // add to to-watch list
        toWatchList.add(inputTitle);
    }
}
