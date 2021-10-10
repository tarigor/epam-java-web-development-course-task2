package by.epam.textParserProject.service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class provides methods for getting text data from file.
 */
public class TextFileService {
    private String fileContent;
    private final String PATH = System.getProperty("user.dir") + "/";

    public TextFileService() {
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String uploadFile(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        String fileName = "";
        String fileContent = "";
        try {
            List<FileItem> items = fileUpload.parseRequest(request);
            FileItem item = items.stream()
                    .filter(e -> "file".equals(e.getFieldName()))
                    .findFirst().get();
            fileName = item.getName();
            item.write(new File(PATH, fileName));
            fileContent = Files.readString(Paths.get(PATH + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setFileContent(fileContent);
        return fileContent;
    }
}
