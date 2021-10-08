package by.epam.textParserProject.entity;

import java.util.ArrayList;

public class Composite implements Component {
    private final ArrayList<Component> componentsList;

    public Composite() {
        componentsList = new ArrayList<>();
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
    public void removeComponent(Component component) {
        componentsList.remove(component);
    }

    @Override
    public String getContent() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        return componentsList.get(index);
    }

}
