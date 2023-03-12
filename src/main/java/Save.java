import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    private static void writeToFile(String filepath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filepath);
        fw.write(textToAdd);
        fw.close();
    }

    //method that saves current content of movieList/ToWatchList into a text file
    //For each movie, content occupies one line in the text file like this:
    // TitleID/Title/Year/RunTimeMinutes/Genre1/Genre2/Genre3
    public Save(ArrayList<Movie> List, String filepath) {
        String SaveData = "";
        for (Movie movie : List) {
            SaveData = SaveData + movie.getTitleID() + "/";
            SaveData = SaveData + movie.getTitle() + "/";
            SaveData = SaveData + movie.getYear() + "/";
            SaveData = SaveData + movie.getRunTimeMinutes() + "/";
            String[] GenreArr = movie.getGenres();
            for (String Genre : GenreArr) {
                SaveData = SaveData + Genre + "/";
            }
            SaveData = SaveData + "\n";
        }
        try {
            writeToFile(filepath, SaveData);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}