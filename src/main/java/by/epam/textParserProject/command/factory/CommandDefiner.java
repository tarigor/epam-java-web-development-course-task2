package by.epam.textParserProject.command.factory;

import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.impl.ParseFromFile;

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
     * @param commandId command id
     * @return instance of the certain command.
     */
    public Command doCommand(int commandId) {
        switch (commandId) {
            case 1: {
                System.out.println("Command 1 selected");
                command = new ParseFromFile();
                break;
            }
            case 2: {
                System.out.println("Command 2 selected");
                break;
            }
            default: {
                System.out.println("There is not such a command, try again...");
            }
        }
        return command;
    }
}
