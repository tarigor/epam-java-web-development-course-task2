package by.epam.textParserProject.service;

import by.epam.textParserProject.constant.ParserExpression;
import by.epam.textParserProject.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class provides service method of parser activity.
 */
public class ParserService {
    private final String PARAGRAPH = ParserExpression.PARAGRAPH.getParseExpression();
    private final String SENTENCE = ParserExpression.SENTENCE.getParseExpression();
    private final String WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE = ParserExpression.WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE.getParseExpression();
    private final String SPLIT_WORD_AND_PUNCTUATION = ParserExpression.SPLIT_WORD_AND_PUNCTUATION.getParseExpression();
    private final String WORD = ParserExpression.WORD.getParseExpression();
    private final String PUNCTUATION = ParserExpression.PUNCTUATION.getParseExpression();

    private final Composite paragraphComposite;

    public ParserService() {
        paragraphComposite = new Composite();
    }

    public Composite getParagraphComposite() {
        return paragraphComposite;
    }

    public Matcher doMatching(String parserExpression, String text) {
        Pattern pattern = Pattern.compile(parserExpression, Pattern.MULTILINE);
        return pattern.matcher(text);
    }

    /**
     * Method divide text onto paragraphs.
     *
     * @param text input text as String.
     * @return resulting Composite object consists whole text divided by paragraph,sentence,word,punctuation
     * based on Composite pattern.
     */
    public Composite parseToParagraph(String text) {
        Matcher paragraphMatcher = doMatching(PARAGRAPH, text);
        int i = 1;
        while (paragraphMatcher.find()) {
            String singleParagraph = paragraphMatcher.group();
            Component paragraph = new Paragraph(singleParagraph);
            System.out.println("paragraph " + i + " ->" + paragraph.getContent());
            paragraphComposite.addComponent(parseToSentences(paragraph));
            i++;
        }
        return paragraphComposite;
    }

    /**
     * Method divide paragraphs onto sentence.
     *
     * @param paragraph text consist paragraph content.
     * @return Composite instance consists text divided by sentence,word,punctuation.
     */
    private Component parseToSentences(Component paragraph) {
        Composite sentenceComposite = new Composite();
        Matcher sentenceMatcher = doMatching(SENTENCE, paragraph.getContent());
        int i = 1;
        while (sentenceMatcher.find()) {
            String singleSentence = sentenceMatcher.group();
            Component sentence = new Sentence(singleSentence);
            System.out.println("sentence " + i + " ->" + sentence.getContent());
            sentenceComposite.addComponent(parseToWordWithPunctuation(sentence));
            i++;
        }
        return sentenceComposite;
    }

    /**
     * Method divide sentence onto words and punctuations.
     *
     * @param sentence text consist sentence content.
     * @return Composite instance consists text divided by words and punctuations.
     */
    private Component parseToWordWithPunctuation(Component sentence) {
        Composite wordAndPunctuationComposite = new Composite();
        Matcher wordAndPunctuationMatcher = doMatching(WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE, sentence.getContent());
        int i = 1;
        while (wordAndPunctuationMatcher.find()) {
            String singleWordAndPunctuation = wordAndPunctuationMatcher.group();
            System.out.println("word with punctuation " + i + " ->" + singleWordAndPunctuation);
            wordAndPunctuationComposite = checkForPunctuationExisting(singleWordAndPunctuation, wordAndPunctuationComposite);
            i++;
        }
        return wordAndPunctuationComposite;
    }

    /**
     * Method divide words consist punctuations onto words and punctuations separately.
     *
     * @param singleWordAndPunctuation    String consist word or word and punctuation.
     * @param wordAndPunctuationComposite paragraph Composite instance.
     * @return Composite instance consists words and punctuations separately.
     */
    private Composite checkForPunctuationExisting(String singleWordAndPunctuation, Composite wordAndPunctuationComposite) {
        Matcher parseByWordAndPunctuationMatcher = doMatching(SPLIT_WORD_AND_PUNCTUATION, singleWordAndPunctuation);
        while (parseByWordAndPunctuationMatcher.find()) {
            Matcher wordMatcher = doMatching(WORD, parseByWordAndPunctuationMatcher.group());
            Matcher punctuationMatcher = doMatching(PUNCTUATION, parseByWordAndPunctuationMatcher.group());
            if (wordMatcher.matches()) {
                Component word = new Word(parseByWordAndPunctuationMatcher.group());
                wordAndPunctuationComposite.addComponent(word);
                System.out.println("word->" + parseByWordAndPunctuationMatcher.group());
            } else if (punctuationMatcher.matches()) {
                Component punctuation = new Punctuation(parseByWordAndPunctuationMatcher.group());
                wordAndPunctuationComposite.addComponent(punctuation);
                System.out.println("punctuation->" + parseByWordAndPunctuationMatcher.group());
            }
        }
        return wordAndPunctuationComposite;
    }


}
