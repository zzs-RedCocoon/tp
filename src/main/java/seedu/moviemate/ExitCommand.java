package seedu.moviemate;

public class ExitCommand extends Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        //Ui...
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
