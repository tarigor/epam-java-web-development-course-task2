package by.epam.textParserProject.command;

import by.epam.textParserProject.entity.Composite;
import by.epam.textParserProject.service.ParserService;
import by.epam.textParserProject.service.TextFileService;
import by.epam.textParserProject.service.factory.ServiceFactory;

/**
 * Common class of whole commands which provides the ArrayList of text lines of whole Text.
 */
public abstract class BaseCommand {
    protected String textFromDownloadedFile;
    protected Composite instanceWithTextParsed;
    protected ParserService parserService = ServiceFactory.getInstance().getParserService();
    protected TextFileService textFileService = ServiceFactory.getInstance().getTextFileService();
}
