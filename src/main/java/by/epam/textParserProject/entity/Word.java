package by.epam.textParserProject.entity;

public class Word implements Component {

    private String content;

    public Word(String content) {
        this.content = content;
    }

    @Override
    public void parse() {
        System.out.print(" " + content);
        Composite.wholeParsedText = Composite.wholeParsedText + " " + content;
    }

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return " " + content;
    }
}
