package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

public class PrintOutFromCompositeObject extends BaseCommand implements Command {
    /**
     * Method composes a text from Composite object.
     */
    @Override
    public void execute() {
        parserService.getParagraphComposite().parse();
    }
}
