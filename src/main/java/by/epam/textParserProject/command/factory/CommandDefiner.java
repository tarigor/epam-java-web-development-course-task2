package by.epam.textParserProject.command.factory;

import by.epam.textParserProject.command.Commands;
import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.impl.ParseFromFile;
import by.epam.textParserProject.command.impl.PrintOutFromCompositeObject;

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
            case PARSE_FROM_FILE: {
                command = new ParseFromFile();
                break;
            }
            case PRINT_TEXT_FROM_OBJECT: {
                command = new PrintOutFromCompositeObject();
                break;
            }
            default: {
                System.out.println("There is not such a command, try again...");
            }
        }
        return command;
    }
}
