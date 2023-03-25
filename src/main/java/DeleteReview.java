public class DeleteReview extends Command{
    private String indexString;

    public DeleteReview(String indexString) {
        this.indexString = indexString;
    }

    @Override
    public void execute (WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.deleteReview(indexString);
    }
}
