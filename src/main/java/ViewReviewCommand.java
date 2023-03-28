
public class ViewReviewCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.viewReview(ui, watchedList);
    }
}
