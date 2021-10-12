package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method redirects to a page with listing of the parsed text with details of the parsed
 * elements (paragraphs,sentences, words, punctuations).
 * @author Igor Taren
 */
public class ShowElementsDetectedWhileParsing extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = parserService.getTextElementsWhileParsing();
        request.setAttribute("content", content);
        request.setAttribute("description", "Text Elements Found While Parsing");
        request.getRequestDispatcher("WEB-INF/jsp/show-content.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "ShowElementsDetectedWhileParsing";
    }
}
