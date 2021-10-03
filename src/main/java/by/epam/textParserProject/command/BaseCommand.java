package by.epam.textParserProject.command;

import by.epam.textParserProject.service.factory.ServiceFactory;

import java.util.ArrayList;

/**
 * Common class of whole commands which provides the ArrayList of text lines of whole Text.
 */
public abstract class BaseCommand {
    protected ArrayList<String> textInListLineByLine = ServiceFactory.getInstance().getTextFileService().getTextInListLineByLine();
}
