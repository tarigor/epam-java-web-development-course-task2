package by.epam.textParserProject.service.factory;

import by.epam.textParserProject.service.MenuService;
import by.epam.textParserProject.service.ParserService;
import by.epam.textParserProject.service.PropertyFileService;
import by.epam.textParserProject.service.TextFileService;

/**
 * Factory class of different services.Provides methods for getting a required instance of service.
 */
public class ServiceFactory {
    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private final MenuService menuService;
    private final PropertyFileService propertyFileService;
    private final TextFileService textFileService;
    private final ParserService parserService;

    public ServiceFactory() {
        menuService = new MenuService();
        propertyFileService = new PropertyFileService();
        textFileService = new TextFileService();
        parserService = new ParserService();
    }

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public PropertyFileService getPropertyFileService() {
        return propertyFileService;
    }

    public TextFileService getTextFileService() {
        return textFileService;
    }

    public ParserService getParserService() {
        return parserService;
    }
}
