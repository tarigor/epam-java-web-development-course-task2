package by.epam.textparserproject.entity;

/**
 * Class implements the base component and encapsulates a leaf element - paragraph.
 * @author Igor Taren
 */
public class Paragraph implements Component {

    private final String content;

    public Paragraph(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void parse() {
        Composite.wholeParsedText = Composite.wholeParsedText + "\n" + "   " + content + "";
    }

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return content + " ";
    }
}
