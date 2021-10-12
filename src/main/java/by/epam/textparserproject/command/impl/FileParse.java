package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method which is parsing a page content onto an object using Composite pattern and redirecting onto
 * a page with a text service dialog.
 * @author Igor Taren
 */
public class FileParse extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textFromDownloadedFile = textFileService.getFileContent();
        parserService.parseTextFromFile(textFromDownloadedFile);
        request.getRequestDispatcher("WEB-INF/jsp/after-parsing.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "FileParse";
    }
}
