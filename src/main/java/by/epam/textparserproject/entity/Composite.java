package by.epam.textparserproject.entity;

import java.util.ArrayList;

/**
 * Class implements the base component methods and defines the child related operations.
 */
public class Composite implements Component {
    public static String wholeParsedText;
    private final ArrayList<Component> componentsList;

    public Composite() {
        componentsList = new ArrayList<>();
        wholeParsedText = "";
    }

    public String getWholeParsedText() {
        return wholeParsedText;
    }

    public static void setWholeParsedText(String wholeParsedText) {
        Composite.wholeParsedText = wholeParsedText;
    }

    public ArrayList<Component> getComponentsList() {
        return componentsList;
    }

    @Override
    public void parse() {
        for (Component component : componentsList) {
            component.parse();
        }
    }

    @Override
    public void addComponent(Component component) {
        componentsList.add(component);
    }

    @Override
    public String getContent() {
        throw new UnsupportedOperationException();
//        return "composite";
    }

    @Override
    public Component getChild(int index) {
        return componentsList.get(index);
    }


}
