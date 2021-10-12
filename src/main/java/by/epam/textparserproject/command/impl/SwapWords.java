package by.epam.textparserproject.command.impl;

import by.epam.textparserproject.command.BaseCommand;
import by.epam.textparserproject.command.Command;
import by.epam.textparserproject.entity.Composite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides a method which is calls a services method which swaps the first word of each sentence of the text
 * with the last one, then redirects onto a page with listing of the modified text.
 */
public class SwapWords extends BaseCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Composite composite = parserService.getParagraphComposite();
        parserService.swapWords(composite);
        String content = composite.getWholeParsedText();
        request.setAttribute("content", content);
        request.setAttribute("description", "Parsed Text After Words Swapped");
        request.getRequestDispatcher("WEB-INF/jsp/show-content.jsp").forward(request, response);
    }

    @Override
    public String toString() {
        return "SwapWords";
    }
}
