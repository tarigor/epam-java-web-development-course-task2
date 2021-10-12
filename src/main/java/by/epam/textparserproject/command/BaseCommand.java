package by.epam.textparserproject.command;

import by.epam.textparserproject.service.ParserService;
import by.epam.textparserproject.service.TextFileService;
import by.epam.textparserproject.service.factory.ServiceFactory;

/**
 * Common abstract class of whole command classes which provides instances of the services classes.
 */
public abstract class BaseCommand {
    protected ParserService parserService = ServiceFactory.getInstance().getParserService();
    protected TextFileService textFileService = ServiceFactory.getInstance().getTextFileService();
}
