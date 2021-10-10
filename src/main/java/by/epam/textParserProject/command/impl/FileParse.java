package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FileParse extends BaseCommand implements Command {
    /**
     * Method parse the text onto Composite object based on Composite pattern.
     *
     * @param request
     * @param response
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textFromDownloadedFile = textFileService.getFileContent();
        parserService.parseTextFromFile(textFromDownloadedFile);
        request.getRequestDispatcher("WEB-INF/jsp/after-parsing.jsp").forward(request, response);
    }
}
