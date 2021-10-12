package by.epam.textparserproject.service;

import by.epam.textparserproject.constant.ParserExpression;
import by.epam.textparserproject.entity.*;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class provides the methods executing a business logic of the parsing actions.
 */
public class ParserService {

    static final Logger logger = Logger.getLogger(ParserService.class);

    private final String PARAGRAPH = ParserExpression.PARAGRAPH.getParseExpression();
    private final String SENTENCE = ParserExpression.SENTENCE.getParseExpression();
    private final String WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE = ParserExpression.WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE.getParseExpression();
    private final String SPLIT_WORD_AND_PUNCTUATION = ParserExpression.SPLIT_WORD_AND_PUNCTUATION.getParseExpression();
    private final String WORD = ParserExpression.WORD.getParseExpression();
    private final String PUNCTUATION = ParserExpression.PUNCTUATION.getParseExpression();

    private final Composite paragraphComposite;
    private final StringBuilder textBuilder;
    private String textElementsWhileParsing = "";

    public ParserService() {
        paragraphComposite = new Composite();
        textBuilder = new StringBuilder();
    }

    public String getTextElementsWhileParsing() {
        return textElementsWhileParsing;
    }

    public Composite getParagraphComposite() {
        return paragraphComposite;
    }

    public Matcher doMatching(String parserExpression, String text) {
        Pattern pattern = Pattern.compile(parserExpression, Pattern.MULTILINE);
        return pattern.matcher(text);
    }

    /**
     * Method divides text onto paragraphs.
     *
     * @param text input text as String.
     * @return resulting Composite object consists whole text divided by paragraph,sentence,word,punctuation
     * based on Composite pattern.
     */
    public Composite parseTextFromFile(String text) {
        Matcher paragraphMatcher = doMatching(PARAGRAPH, text);
        int i = 1;
        while (paragraphMatcher.find()) {
            String singleParagraph = paragraphMatcher.group();
            Component paragraph = new Paragraph(singleParagraph);
            composeTextElementsWhileParsing("paragraph ", String.valueOf(i), "-> ", paragraph.getContent());
            paragraphComposite.addComponent(parseToSentences(paragraph));
            i++;
        }
        logger.info("The text file has been parsed");
        return paragraphComposite;
    }


    /**
     * Method divides paragraphs onto sentence.
     *
     * @param paragraph text consists a paragraph content.
     * @return Composite instance consists text divided by sentence,word,punctuation.
     */
    private Component parseToSentences(Component paragraph) {
        Composite sentenceComposite = new Composite();
        Matcher sentenceMatcher = doMatching(SENTENCE, paragraph.getContent());
        int i = 1;
        while (sentenceMatcher.find()) {
            String singleSentence = sentenceMatcher.group();
            Component sentence = new Sentence(singleSentence);
            composeTextElementsWhileParsing("sentence ", String.valueOf(i), " -> ", sentence.getContent());
            sentenceComposite.addComponent(parseToWordWithPunctuation(sentence));
            i++;
        }
        return sentenceComposite;
    }

    /**
     * Method divides sentence onto words and punctuations.
     *
     * @param sentence text consist a sentence content.
     * @return Composite instance consists text divided by words and punctuations.
     */
    private Component parseToWordWithPunctuation(Component sentence) {
        Composite wordAndPunctuationComposite = new Composite();
        Matcher wordAndPunctuationMatcher = doMatching(WORD_WITH_PUNCTUATION_DIVIDED_BY_SPACE, sentence.getContent());
        int i = 1;
        while (wordAndPunctuationMatcher.find()) {
            String singleWordAndPunctuation = wordAndPunctuationMatcher.group();
            wordAndPunctuationComposite = checkForPunctuationExisting(singleWordAndPunctuation, wordAndPunctuationComposite);
            i++;
        }
        return wordAndPunctuationComposite;
    }

    /**
     * Method divides words which are consist punctuations onto words and punctuations separately.
     *
     * @param singleWordAndPunctuation    String consists word or word and punctuation.
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
                composeTextElementsWhileParsing("word-> ", parseByWordAndPunctuationMatcher.group());
            } else if (punctuationMatcher.matches()) {
                Component punctuation = new Punctuation(parseByWordAndPunctuationMatcher.group());
                wordAndPunctuationComposite.addComponent(punctuation);
                composeTextElementsWhileParsing("punctuation-> ", parseByWordAndPunctuationMatcher.group());
            }
        }
        return wordAndPunctuationComposite;
    }

    /**
     * Methods swaps the first word of each sentence in text with the last word of the sentence.
     *
     * @param composite Composite instance consist whole text based on Composite pattern.
     * @return modified Composite instance in which the first word of each sentence swapped with the last word of sentence.
     */
    public Composite swapWords(Composite composite) {
        for (int i = 0; i < composite.getComponentsList().size(); i++) {
            for (Component component : ((Composite) composite.getChild(i)).getComponentsList()) {
                int k = 0;
                String lastWord;
                String firstWord = component.getChild(0).toString();
                if (component.getChild(((Composite) component).getComponentsList().size() - 2).getClass().getName().contains("Word")) {
                    lastWord = component.getChild(((Composite) component).getComponentsList().size() - 2).toString();
                } else {
                    while (true) {
                        lastWord = component.getChild(((Composite) component).getComponentsList().size() - (2 + k)).toString();
                        if (component.getChild(((Composite) component).getComponentsList().size() - (2 + k)).getClass().getName().contains("Word")) {
                            break;
                        }
                        k++;
                    }
                }
                ((Word) ((Composite) component).getComponentsList().get(0)).setContent(lastWord);
                ((Word) ((Composite) component).getComponentsList().get(((Composite) component).getComponentsList().size() - (2 + k))).setContent(firstWord);
                logger.info(textBuilder.append("has been swapped -> ").append(firstWord.trim()).append(" and ").append(lastWord.trim()).append("\n"));
            }
        }
        return composite;
    }

    /**
     * method provides the concatenation of the String data.
     *
     * @param s String data to be concatenated.
     */
    private void composeTextElementsWhileParsing(String... s) {
        for (String single : s) {
            textElementsWhileParsing = textBuilder.append(single).toString();
        }
        textElementsWhileParsing = textBuilder.append("\n").toString();
    }
}
