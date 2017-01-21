package software.works.fizzbuzz.engine;

class PlayerConfiguration {

    private static final String DEFAULT_WORD_SEPARATOR = " ";
    private static final String DEFAULT_FINAL_PUNCTUATION = "";

    private String wordSeparator;
    private String finalPunctuation;
    private boolean numbersMustBePrinted;
    private boolean wordsMustBePrintedOnlyOnce;
    private boolean wordsMustBePrintedNTimes;
    private boolean wordsMustBeCollectedToList;

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

    boolean wordsMustBePrintedNTimes() {
        return wordsMustBePrintedNTimes;
    }

    void setWordsMustBePrintedNTimes(boolean wordsMustBePrintedNTimes) {
        this.wordsMustBePrintedNTimes = wordsMustBePrintedNTimes;
    }

    boolean wordsMustBeCollectedToList() {
        return wordsMustBeCollectedToList;
    }

    public void setWordsMustBeCollectedToList(boolean wordsMustBeCollectedToList) {
        this.wordsMustBeCollectedToList = wordsMustBeCollectedToList;
    }
}