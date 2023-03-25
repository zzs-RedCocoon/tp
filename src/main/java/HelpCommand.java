
public class HelpCommand extends Command {

    @Override
    public void execute (WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        Ui.help();
        Ui.printLine();
    }
}
