package software.works.fizzbuzz.engine;

public class PlayConfiguration {

    private static final String DEFAULT_WORD_SEPARATOR = " ";
    private static final String DEFAULT_FINAL_PUNCTUATION = "";

    private String wordSeparator;
    private String finalPunctuation;
    private boolean numbersMustBePrinted;
    private boolean wordsMustBePrintedOnlyOnce;
    private boolean wordsMustBePrintedNTimes;
    private boolean wordsMustBeCollectedToList;

    public PlayConfiguration() {
        setUpDefaultParameterValues();
    }

    private void setUpDefaultParameterValues() {
        wordSeparator = DEFAULT_WORD_SEPARATOR;
        finalPunctuation = DEFAULT_FINAL_PUNCTUATION;
    }

    public String getWordSeparator() {
        return wordSeparator;
    }

    public void setWordSeparator(String wordSeparator) {
        this.wordSeparator = wordSeparator;
    }

    public String getFinalPunctuation() {
        return finalPunctuation;
    }

    public void setFinalPunctuation(String finalPunctuation) {
        this.finalPunctuation = finalPunctuation;
    }

    public boolean numbersMustBePrinted() {
        return numbersMustBePrinted;
    }

    public void setNumbersMustBePrinted(boolean numbersMustBePrinted) {
        this.numbersMustBePrinted = numbersMustBePrinted;
    }

    public boolean wordsMustBePrintedOnlyOnce() {
        return wordsMustBePrintedOnlyOnce;
    }

    public void setWordsMustBePrintedOnlyOnce(boolean wordsMustBePrintedOnlyOnce) {
        this.wordsMustBePrintedOnlyOnce = wordsMustBePrintedOnlyOnce;
    }

    public boolean wordsMustBePrintedNTimes() {
        return wordsMustBePrintedNTimes;
    }

    public void setWordsMustBePrintedNTimes(boolean wordsMustBePrintedNTimes) {
        this.wordsMustBePrintedNTimes = wordsMustBePrintedNTimes;
    }

    boolean wordsMustBeCollectedToList() {
        return wordsMustBeCollectedToList;
    }

    public void setWordsMustBeCollectedToList(boolean wordsMustBeCollectedToList) {
        this.wordsMustBeCollectedToList = wordsMustBeCollectedToList;
    }
}