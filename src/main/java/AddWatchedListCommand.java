
public class AddWatchedListCommand extends Command {

    private String inputTitle;

    public AddWatchedListCommand(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    @Override
    public  void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // add to watched list
        watchedList.add(inputTitle);
    }
}
