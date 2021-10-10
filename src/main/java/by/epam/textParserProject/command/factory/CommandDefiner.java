package by.epam.textParserProject.command.factory;

import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.Commands;
import by.epam.textParserProject.command.impl.*;

/**
 * Class provides a method for define a certain commands depending fro selected option in menu.
 */
public class CommandDefiner {
    private static final CommandDefiner commandDefiner = new CommandDefiner();
    private Command command;

    public CommandDefiner() {
    }

    public static CommandDefiner getInstance() {
        return commandDefiner;
    }

    /**
     * Method provides a selection of the command in depends of the selection made in a menu.
     *
     * @param commandName command id
     * @return instance of the certain command.
     */
    public Command selectCommand(Commands commandName) {
        switch (commandName) {
            case DOWNLOAD: {
                command = new FileDownload();
                break;
            }
            case PARSE: {
                command = new FileParse();
                break;
            }
            case SHOW_CONTENT_OF_DOWNLOADED_FILE: {
                command = new ShowContentOfDownloadedFile();
                break;
            }
            case SHOW_ELEMENTS_DETECTED_WHILE_PARSING: {
                command = new ShowElementsDetectedWhileParsing();
                break;
            }
            case SHOW_PARSED_TEXT: {
                command = new ShowParsedText();
                break;
            }
            default: {
                System.out.println("There is not such a command, try again...");
            }
        }
        return command;
    }
}
