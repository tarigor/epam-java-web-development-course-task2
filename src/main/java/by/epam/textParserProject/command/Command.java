package by.epam.textParserProject.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Common interface of the commands.
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
