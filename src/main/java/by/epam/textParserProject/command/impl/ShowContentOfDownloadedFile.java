package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowContentOfDownloadedFile extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = textFileService.getFileContent();
        request.setAttribute("content", content);
        request.setAttribute("description", "Content Of Text File");
        request.getRequestDispatcher("WEB-INF/jsp/show-content.jsp").forward(request, response);
    }
}
