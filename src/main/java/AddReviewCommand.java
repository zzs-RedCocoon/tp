public class AddReviewCommand extends Command {

    //maybe can do some parse to get the index from String here later.
    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        watchedList.setReview(ui, watchedList);
    }

}
