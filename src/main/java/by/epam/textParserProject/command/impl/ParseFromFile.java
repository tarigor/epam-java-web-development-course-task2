package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

public class ParseFromFile extends BaseCommand implements Command {
    /**
     * Method parse the text onto Composite object based on Composite pattern.
     */
    @Override
    public void execute() {
        parserService.parseToParagraph(textFileService.getTextFromFileToString());
    }
}
