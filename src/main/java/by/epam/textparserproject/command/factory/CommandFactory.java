package by.epam.textparserproject.command.factory;

import by.epam.textparserproject.command.Command;
import by.epam.textparserproject.command.Commands;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Class provides a method for define a command based on parameter "command" received via http from jsp page.
 * @author Igor Taren
 */
public class CommandFactory {
    private static Logger logger = Logger.getLogger(CommandFactory.class);

    public Command selectCommand(HttpServletRequest request) {
        Command command;
        String commandName;
        if (ServletFileUpload.isMultipartContent(request)) {
            commandName = Commands.DOWNLOAD.toString();
        } else {
            commandName = request.getParameter("command").toUpperCase();
        }
        logger.info(String.format("The command from http request is -> %s", commandName));
        Commands currentEnumCommand = Commands.valueOf(commandName);
        command = currentEnumCommand.getCommand();
        logger.info(String.format("The command -> %s has been defined", command.toString()));
        return command;
    }
}
