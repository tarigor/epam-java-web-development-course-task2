package by.epam.textParserProject.service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

    public String getTextFromFileToString() {
        String fileContent = null;
        try {
            fileContent = Files.readString(Paths.get("src/main/resources/text.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public ArrayList<String> getTextInListLineByLine() {
        return textInListLineByLine;
    }

    public String uploadFile(HttpServletRequest request) {
//        if(ServletFileUpload.isMultipartContent(request)) {
//            try {
//                List<FileItem> multiParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//                for (FileItem item : multiParts) {
//                    if (item.isFormField()) {
//                        item.write(new File("/home/igor/Documents/project/epamJavaWebDevCourse/epam-java-web-development-course-task2/src/main/resources" + File.separator + "fname"));
//                    }
//                }
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        String path = "/home/igor/Documents/project/epamJavaWebDevCourse/epam-java-web-development-course-task2/src/main/resources";
        InputStream inputStream = null;
        try {
            List<FileItem> items = fileUpload.parseRequest(request);
            FileItem item = items.stream()
                    .filter(e -> "file".equals(e.getFieldName()))
                    .findFirst().get();
//            item.write(new File(System.getProperty("user.dir"), fileName));
            item.write(new File(path, item.getName()));
            inputStream = item.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTextFromFile(inputStream);
    }

    private String getTextFromFile(InputStream inputStream) {
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
                String line;
                while ((line = br.readLine())!=null){
                    stringBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return stringBuilder.toString();
    }


}
