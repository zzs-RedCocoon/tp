package seedu.moviemate;

public class AddReviewCommand extends Command {
    private String indexString;

    public AddReviewCommand(String indexString) {
        this.indexString = indexString;
    }

    //maybe can do some parse to get the index from String here later.
    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.setReview(indexString);
    }

}
