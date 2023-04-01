public class WatchListCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // list the towatch list
        toWatchList.list();
        Ui.showListMessage(toWatchList);
    }
}
