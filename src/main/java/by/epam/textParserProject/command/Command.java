package by.epam.textParserProject.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Common interface of the commands.
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
