package seedu.moviemate;

public class DeleteReviewCommand extends Command {
    private String indexString;

    public DeleteReviewCommand(String indexString) {
        this.indexString = indexString;
    }

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.deleteReview(indexString);
    }
}
