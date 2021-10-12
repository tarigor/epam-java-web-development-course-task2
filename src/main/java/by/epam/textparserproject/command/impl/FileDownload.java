package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method executes command of the file download from web page dialog, storing its content in String data,
 * shown content of file on the web page.
 *
 * @author Igor Taren
 */
public class FileDownload extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textFromDownloadedFile = textFileService.uploadFile(request);
        request.setAttribute("fullText", textFromDownloadedFile);
        request.getRequestDispatcher("WEB-INF/jsp/after-download.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "FileDownload";
    }
}
