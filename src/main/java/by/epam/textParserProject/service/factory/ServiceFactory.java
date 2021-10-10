package by.epam.textParserProject.service.factory;

import by.epam.textParserProject.service.ParserService;
import by.epam.textParserProject.service.TextFileService;

/**
 * Factory class of different services.Provides methods for getting a required instance of service.
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
