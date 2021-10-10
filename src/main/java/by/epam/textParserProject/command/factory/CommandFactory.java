package by.epam.textParserProject.command.factory;

import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.Commands;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;

/**
 * Class provides a method for define a certain commands depending fro selected option in menu.
 */
public class CommandFactory {

    public Command selectCommand(HttpServletRequest request) {
        Command command;
        String commandName;
        if (ServletFileUpload.isMultipartContent(request)) {
            commandName = Commands.DOWNLOAD.toString();
        } else {
            commandName = request.getParameter("command").toUpperCase();
        }
        System.out.println("command->" + commandName);
        Commands currentEnumCommand = Commands.valueOf(commandName);
        command = currentEnumCommand.getCommand();
        return command;
    }
}
