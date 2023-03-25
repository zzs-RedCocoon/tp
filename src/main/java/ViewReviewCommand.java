
public class ViewReviewCommand extends Command {

    private String indexString;

    public ViewReviewCommand(String indexString) {
        this.indexString = indexString;
    }

    @Override
    public void execute (WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.viewReview(indexString);
    }
}
