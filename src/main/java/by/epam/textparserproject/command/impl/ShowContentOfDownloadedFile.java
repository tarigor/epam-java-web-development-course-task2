package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method which redirects to a page with listing of the content of the downloaded file.
 * @author Igor Taren
 */
public class ShowContentOfDownloadedFile extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = textFileService.getFileContent();
        request.setAttribute("content", content);
        request.setAttribute("description", "Content Of Text File");
        request.getRequestDispatcher("WEB-INF/jsp/show-content.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "ShowContentOfDownloadedFile";
    }
}
