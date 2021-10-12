package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;
import by.epam.textparserproject.entity.Composite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method redirects to a page with listing of the the parsed text.
 */
public class ShowParsedText extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Composite composite = parserService.getParagraphComposite();
        composite.parse();
        String content = composite.getWholeParsedText();
        request.setAttribute("content", content);
        request.setAttribute("description", "Parsed Text");
        request.getRequestDispatcher("WEB-INF/jsp/show-content.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "ShowParsedText";
    }
}
