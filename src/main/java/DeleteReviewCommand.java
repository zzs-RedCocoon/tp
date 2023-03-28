public class DeleteReviewCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.deleteReview(ui, watchedList);
    }
}
