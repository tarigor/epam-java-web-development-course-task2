package by.epam.textParserProject.service;

import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.factory.CommandDefiner;
import by.epam.textParserProject.service.factory.ServiceFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class provides methods for handling with a menu.
 */
public class MenuService {
    private final String MENU_FILE_PROPERTIES = "menu.properties";
    private final HashMap<Integer, String> menuHierarchy;
    private final Scanner scanner;
    private Properties property;

    public MenuService() {
        this.menuHierarchy = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method store a menu description from a property file to HashMap
     *
     * @return current object provides a builder pattern.
     */
    public MenuService storeMenuToMap() {
        property = ServiceFactory.getInstance().getPropertyFileService().readFromPropertyFile(MENU_FILE_PROPERTIES);
        for (Map.Entry entry : property.entrySet()) {
            menuHierarchy.put(Integer.parseInt((String) entry.getKey()), ((String) entry.getValue()));
        }
        return this;
    }

    /**
     * Method prints a men hierarchy to a console.
     *
     * @return current object provides a builder pattern.
     */
    public MenuService printMenu() {
        menuHierarchy.forEach((K, V) -> {
            System.out.println(K + ". " + V);
        });
        return this;
    }

    /**
     * Method request for input an option selected from a menu.
     *
     * @return instance of Command class provides a builder pattern.
     */
    public Command doOptionSelection() {
        System.out.print("Select an option:");
        return CommandDefiner.getInstance().doCommand(scanner.nextInt());
    }

}
