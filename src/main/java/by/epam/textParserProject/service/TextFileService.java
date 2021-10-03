package by.epam.textParserProject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class provides methods for getting text data from file.
 */
public class TextFileService {
    private final String TEXT_FILE_NAME = "text.txt";
    private final ArrayList<String> textInListLineByLine;
    private BufferedReader bufferedReader;

    public TextFileService() {
        textInListLineByLine = new ArrayList<>();
        readFileAndStoreInListLineByLine();
    }

    /**
     * Method reads text from file and store to ArrayList line by line.
     *
     * @return ArrayList of text line of whole text.
     */
    public ArrayList<String> readFileAndStoreInListLineByLine() {
        bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                Objects.requireNonNull(TextFileService.class.getClassLoader().getResourceAsStream(TEXT_FILE_NAME))
                        ));
        try {
            String singleLine;
            while ((singleLine = bufferedReader.readLine()) != null) {
                textInListLineByLine.add(singleLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textInListLineByLine;
    }

    public ArrayList<String> getTextInListLineByLine() {
        return textInListLineByLine;
    }
}
