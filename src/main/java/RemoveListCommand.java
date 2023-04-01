
public class RemoveListCommand extends Command{

    private String removeListType;

    public RemoveListCommand(String removeListType) {
        this.removeListType = removeListType;
    }

    public void removeWatchedList(WatchedList watchedList, Ui ui, Storage storage) {
        //remove from watched list
        ui.showListMessage(watchedList);

        String inputIndex = ui.inputCommand();
        int removeWatchedIndex = Parser.parseIndex(inputIndex, 1, watchedList.movieList.size());
        if (removeWatchedIndex < 0) {
            System.out.println(String.format(
                    "Please try enter the remove command again and make sure the index is valid. \n" +
                    "The valid index range is 1 to %d", watchedList.movieList.size()));
            return;
        }
        watchedList.remove(removeWatchedIndex);
        ui.showDeleteMessage();
    }

    public void removeToWatchList(ToWatchList toWatchList, Ui ui, Storage storage) {
        //remove from towatch list
        ui.showListMessage(toWatchList);

        String inputIndex = ui.inputCommand();
        int removeToWatchIndex = Parser.parseIndex(inputIndex, 1, toWatchList.movieList.size());
        if (removeToWatchIndex < 0) {
            System.out.println(String.format(
                    "Please try enter the remove command again and make sure the index is valid. \n" +
                    "The valid index range is 1 to %d",  toWatchList.movieList.size()));
            return;
        }
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
