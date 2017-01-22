package software.works.fizzbuzz.engine.play;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import software.works.fizzbuzz.FizzBuzzPlayer;
import software.works.fizzbuzz.FizzbuzzifiedNumber;
import software.works.fizzbuzz.engine.FizzBuzzFunction;
import software.works.fizzbuzz.engine.PlayConfiguration;

public class OrdinaryPlayer implements FizzBuzzPlayer {

    protected List<FizzBuzzFunction> fizzBuzzFunctions;
    private PlayConfiguration configuration;

    protected OrdinaryPlayer() {}

    public OrdinaryPlayer(List<FizzBuzzFunction> fizzBuzzFunctions, PlayConfiguration configuration) {
        this.fizzBuzzFunctions = fizzBuzzFunctions;
        this.configuration = configuration;
    }

    @Override
    public String playAtFizzBuzz(BigInteger value) {
        String fizzBuzz = fizzBuzzFunctions.stream() //
                .map(function -> function.fizzBuzzOf(value)) //
                .collect(joining());

        if (fizzBuzz.isEmpty()) {
            fizzBuzz = value.toString();
        } else if (configuration.numbersMustBePrinted()) {
            fizzBuzz += " (" + value + ")";
        }
        return fizzBuzz;
    }

    @Override
    public String playAtFizzBuzz(List<BigInteger> values) {
        return values.stream() //
                .map(this::playAtFizzBuzz) //
                .collect(joining(configuration.getWordSeparator())) //
                + configuration.getFinalPunctuation();
    }

    @Override
    public List<String> playAtFizzBuzzToList(List<BigInteger> values) {
        return values.stream() //
                .map(this::wordPunctuated) //
                .collect(toList());
    }

    @Override
    public List<FizzbuzzifiedNumber> fizzbuzzify(List<BigInteger> values) {
        return values.stream() //
                .map(this::toFizzbuzzifiedNumber) //
                .collect(toList());
    }

    private FizzbuzzifiedNumber toFizzbuzzifiedNumber(BigInteger value) {
        return new FizzbuzzifiedNumber(value, wordPunctuated(value));
    }

    private String wordPunctuated(BigInteger value) {
        return configuration.getFinalPunctuation().isEmpty() ? playAtFizzBuzz(value)
                : playAtFizzBuzz(value) + configuration.getFinalPunctuation();
    }

    public List<FizzBuzzFunction> getFizzBuzzFunctions() {
        return Collections.unmodifiableList(fizzBuzzFunctions);
    }

    public void setFizzBuzzFunctions(List<FizzBuzzFunction> fizzBuzzFunctions) {
        this.fizzBuzzFunctions = fizzBuzzFunctions;
    }

    public void setConfiguration(PlayConfiguration configuration) {
        this.configuration = configuration;
    }
}