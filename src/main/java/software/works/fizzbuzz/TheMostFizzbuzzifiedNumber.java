package software.works.fizzbuzz;

import static java.util.stream.Collectors.joining;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import software.works.fizzbuzz.rule.PlayerBuilder;

class TheMostFizzbuzzifiedNumber {

    private static final String DIGIT_REGEX = "\\d";

    private PlayerBuilder playerBuilder;
    private int start;

    TheMostFizzbuzzifiedNumber(PlayerBuilder playerBuilder) {
        this.playerBuilder = playerBuilder;
    }

    public Optional<Integer> in(int... values) {
        List<String> madeWords = playerBuilder.chosenPlayer().playAtFizzBuzzToList(values);
        Pattern knownWords = knownWords();
        Iterator<Integer> valueIterator = IntStream.of(values).iterator();

        Optional<FizzbuzzifiedNumber> theMostFizzbuzzified = madeWords.stream() //
                .map(word -> new FizzbuzzifiedNumber(valueIterator.next(), word, knownWords)) //
                .max(Comparator.naturalOrder());

        return isFizzbuzzified(theMostFizzbuzzified) ? Optional.of(theMostFizzbuzzified.get().getNumber())
                : Optional.empty();
    }

    private Pattern knownWords() {
        List<String> knownWords = playerBuilder.getKnownWords();
        String knownWordsRegex = knownWords.stream().collect(joining("|", "(", ")"));
        return Pattern.compile(knownWordsRegex);
    }

    private boolean isFizzbuzzified(Optional<FizzbuzzifiedNumber> theMostFizzbuzzified) {
        return theMostFizzbuzzified.isPresent() && !theMostFizzbuzzified.get().getFizzbuzzified().matches(DIGIT_REGEX);
    }

    public TheMostFizzbuzzifiedNumber from(int start) {
        this.start = start;
        return this;
    }

    public Optional<Integer> to(int end) {
        return in(IntStream.rangeClosed(start, end).toArray());
    }
}