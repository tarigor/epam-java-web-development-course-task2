package by.epam.textParserProject.service;

import by.epam.textParserProject.constant.ParserExpression;

import java.util.regex.Pattern;

/**
 * Class provides service method of parser activity.
 */
public class ParserService {

    public ParserService() {
    }

    /**
     * Method check if line of text is beginning of paragraph.
     *
     * @param line text line.
     * @return result of checking.
     */
    public Boolean checkIfLineBeginningOfParagraph(String line) {
        return Pattern.compile(ParserExpression.PARAGRAPH.getParseExpression()).matcher(line).matches();
    }
}
