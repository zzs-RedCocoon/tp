/**
 * Parses user input.
 */
public class Parser {

    public static String[] parseCommand(String userInputCommand) {
        final String[] split = userInputCommand.trim().split("\\s+", 2);
        final String[] commandTypeAndParams = split.length == 2 ? split : new String[]{split[0], ""};
        return commandTypeAndParams;
    }


    public static int parseIndex(String indexString, int l, int r) {
        int index = 0;

        //cannot parse string to index
        try{
            index = Integer.parseInt(indexString);
        }catch(NumberFormatException e){
            return -1;
        }

        //index out of range
        if(index < l || index > r){
            return -1;
        }
        return index;
    }

}
