package by.epam.textparserproject.constant;

/**
 * Consist constants of regex expressions.
 * @author Igor Taren
 */
public enum ParserExpression {
    PARAGRAPH("(\\s\\n|^).*?(?=\\n|$)"),
    SENTENCE("[а-яА-Яa-zA-Z][^\\.!?:;]*[\\.!?:;]"),
    WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE("[А-Яа-яa-zA-Z][^\\s]*"),
    SPLIT_WORD_AND_PUNCTUATION("[а-яА-Яa-zA-Z][^\\s\\.,:;?!()]*|\\W"),
    WORD("[а-яА-Яa-zA-Z][^\\s\\.,:;?!()]*"),
    PUNCTUATION("[\\.,:;?!()]");

    private final String parseExpression;

    ParserExpression(String parseExpression) {
        this.parseExpression = parseExpression;
    }

    public String getParseExpression() {
        return parseExpression;
    }

    @Override
    public String toString() {
        return parseExpression;
    }
}
