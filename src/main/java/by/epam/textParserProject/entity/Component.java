package by.epam.textParserProject.entity;

public interface Component {
    void parse();

    void addComponent(Component component);

    void removeComponent(Component component);

    String getContent();

    Component getChild(int index);
}
