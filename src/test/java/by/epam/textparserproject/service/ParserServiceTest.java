package by.epam.textparserproject.service;

import by.epam.textparserproject.entity.Composite;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ParserServiceTest {

    @Test
    void parseTextFromFile() {
        //GIVEN
        String expectedText = "Hello World! Belarus is living!";
        ParserService parserService = new ParserService();
        Composite composite;
        //WHEN
        composite = parserService.parseTextFromFile(expectedText);
        composite.parse();
        String inputText = expectedText.trim();
        System.out.printf("expected text -> %s \n", inputText);
        String resultingText = composite.getWholeParsedText().trim();
        System.out.printf("text after parsing and collecting -> %s \n", resultingText);
        //THEN
        Assert.assertTrue(inputText.contentEquals(resultingText));
    }


    @Test
    void testSwapWords() {
        //GIVEN
        ParserService parserService = new ParserService();
        String inputText = "Hello World! Belarus is living!";
        String expectedTextAfterSwapping = "World Hello! living is Belarus!";
        Composite composite = null;
        //WHEN
        parserService.parseTextFromFile(inputText);
        composite = parserService.getParagraphComposite();
        parserService.swapWords(composite).parse();
        //THEN
        System.out.printf("expected text after swapping -> %s \n", expectedTextAfterSwapping);
        String resultingText = composite.getWholeParsedText().trim();
        System.out.printf("text after swapping -> %s \n", resultingText);
        Assert.assertTrue(expectedTextAfterSwapping.contentEquals(resultingText));
    }
}
