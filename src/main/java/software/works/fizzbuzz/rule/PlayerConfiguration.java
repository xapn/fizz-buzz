package software.works.fizzbuzz.rule;

class PlayerConfiguration {

    private static final String DEFAULT_WORD_SEPARATOR = " ";
    private static final String DEFAULT_FINAL_PUNCTUATION = "";

    private String wordSeparator;
    private String finalPunctuation;
    private boolean numbersMustBePrinted;
    private boolean wordsMustBePrintedOnlyOnce;

    public PlayerConfiguration() {
        setUpDefaultParameterValues();
    }

    private void setUpDefaultParameterValues() {
        wordSeparator = DEFAULT_WORD_SEPARATOR;
        finalPunctuation = DEFAULT_FINAL_PUNCTUATION;
    }

    String getWordSeparator() {
        return wordSeparator;
    }

    void setWordSeparator(String wordSeparator) {
        this.wordSeparator = wordSeparator;
    }

    String getFinalPunctuation() {
        return finalPunctuation;
    }

    void setFinalPunctuation(String finalPunctuation) {
        this.finalPunctuation = finalPunctuation;
    }

    boolean numbersMustBePrinted() {
        return numbersMustBePrinted;
    }

    void setNumbersMustBePrinted(boolean numbersMustBePrinted) {
        this.numbersMustBePrinted = numbersMustBePrinted;
    }

    boolean wordsMustBePrintedOnlyOnce() {
        return wordsMustBePrintedOnlyOnce;
    }

    void setWordsMustBePrintedOnlyOnce(boolean wordsMustBePrintedOnlyOnce) {
        this.wordsMustBePrintedOnlyOnce = wordsMustBePrintedOnlyOnce;
    }
}