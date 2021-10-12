package by.epam.textparserproject.entity;

/**
 * The base interface for all objects in the composition.
 * @author Igor Taren
 */
public interface Component {
    void parse();

    void addComponent(Component component);

    String getContent();

    Component getChild(int index);

    String toString();
}
