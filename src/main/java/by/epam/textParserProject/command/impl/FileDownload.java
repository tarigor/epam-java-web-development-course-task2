package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FileDownload extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        textFromDownloadedFile = textFileService.uploadFile(request);
        request.setAttribute("fullText", textFromDownloadedFile);
        request.getRequestDispatcher("WEB-INF/jsp/after-download.jsp").forward(request, response);
    }
}
