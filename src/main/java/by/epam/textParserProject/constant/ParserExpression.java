package by.epam.textParserProject.constant;

/**
 * Consist constants of regex expressions.
 */
public enum ParserExpression {
    PARAGRAPH("^\\s{1,}([A-Z]|[А-Я]|[0-9]){1,}.*");

    private final String parseExpression;

    ParserExpression(String parseExpression) {
        this.parseExpression = parseExpression;
    }

    public String getParseExpression() {
        return parseExpression;
    }

    @Override
    public String toString() {
        return "ParserExpression{" +
                "parseExpression='" + parseExpression + '\'' +
                '}';
    }
}
