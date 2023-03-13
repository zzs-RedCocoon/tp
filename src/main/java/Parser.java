/**
 * Parses user input.
 */
public class Parser {

    public static String[] parseCommand(String userInputCommand) {
        final String[] split = userInputCommand.trim().split("\\s+", 2);
        final String[] commandTypeAndParams = split.length == 2 ? split : new String[]{split[0], ""};
        return commandTypeAndParams;
    }

    public static int parseRunTimeMinutes(String runTime){
        try{
            return Integer.parseInt(runTime);
        }catch (NumberFormatException e){
            return -1;
        }
    }

}
