package by.epam.textparserproject.service.factory;

import by.epam.textparserproject.service.ParserService;
import by.epam.textparserproject.service.TextFileService;

/**
 * Factory class of different services. Provides methods for getting a required instance of service classes.
 */
public class ServiceFactory {
    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private final TextFileService textFileService;
    private final ParserService parserService;

    public ServiceFactory() {
        textFileService = new TextFileService();
        parserService = new ParserService();
    }

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public TextFileService getTextFileService() {
        return textFileService;
    }

    public ParserService getParserService() {
        return parserService;
    }
}
