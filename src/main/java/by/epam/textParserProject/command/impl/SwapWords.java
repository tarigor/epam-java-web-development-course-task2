package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.entity.Composite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
