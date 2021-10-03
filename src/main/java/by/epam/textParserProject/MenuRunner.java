package by.epam.textParserProject;

import by.epam.textParserProject.service.MenuService;
import by.epam.textParserProject.service.factory.ServiceFactory;

/**
 * Class provides a menu cycle dialog.
 */
public class MenuRunner {
    private static MenuRunner menuRunner;
    private final MenuService menuService = ServiceFactory.getInstance().getMenuService();

    public MenuRunner() {
    }

    public static MenuRunner getMenuRunner() {
        if (menuRunner == null) {
            menuRunner = new MenuRunner();
        }
        return menuRunner;
    }

    /**
     * Methods provides continuous menu cycle dialog.
     */
    public void doMenuCycle() {
        while (true) {
            menuService
                    .storeMenuToMap()
                    .printMenu()
                    .doOptionSelection()
                    .execute();
        }
    }
}
