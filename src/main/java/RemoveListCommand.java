
public class RemoveListCommand extends Command{

    private String removeListType;

    public RemoveListCommand(String removeListType) {
        this.removeListType = removeListType;
    }

    public void removeWatchedList(WatchedList watchedList, Ui ui, Storage storage) {
        //remove from watched list
        ui.showListMessage(watchedList);
        int removeWatchedIndex = Integer.parseInt(ui.inputCommand());
        watchedList.remove(removeWatchedIndex);
        ui.showDeleteMessage();
    }

    public void removeToWatchList(ToWatchList toWatchList, Ui ui, Storage storage) {
        //remove from towatch list
        ui.showListMessage(toWatchList);
        int removeToWatchIndex = Integer.parseInt(ui.inputCommand());
        toWatchList.remove(removeToWatchIndex);
        ui.showDeleteMessage();
    }

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        switch (removeListType) {
        case "watched":
            removeWatchedList(watchedList, ui, storage);
            break;
        case "towatch":
            removeToWatchList(toWatchList, ui, storage);
            break;
        default:
            System.out.println("Please follow the format: remove [watched/towatch]");
            break;
        }
    }




}
