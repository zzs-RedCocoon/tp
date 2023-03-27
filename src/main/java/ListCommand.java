
public class ListCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // list the watched list
        watchedList.list();
    }
}
