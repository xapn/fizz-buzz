package software.works.fizzbuzz;

public class I {

    @SafeVarargs
    public static <T> String fizzbuzzify(T... values) {
        return new FizzBuzz().whenNumberHasFactors().of(values);
    }

    public static <T> Until<T> fizzbuzzify(T start) {
        return new Until<T>(new FizzBuzz().whenNumberHasFactors()).from(start);
    }

    @SafeVarargs
    public static <T> String sevenboomify(T... values) {
        return new FizzBuzz().boom().of(values);
    }

    public static <T> Until<T> sevenboomify(T start) {
        return new Until<T>(new FizzBuzz().boom()).from(start);
    }

    @SafeVarargs
    public static <T> String fizzbuzzwoofify(T... values) {
        return new FizzBuzz().woof().of(values);
    }

    public static <T> Until<T> fizzbuzzwoofify(T start) {
        return new Until<T>(new FizzBuzz().woof()).from(start);
    }

    @SafeVarargs
    public static <T> String fizzbuzzpopwhackify(T... values) {
        return new FizzBuzz().popWhack().of(values);
    }

    public static <T> Until<T> fizzbuzzpopwhackify(T start) {
        return new Until<T>(new FizzBuzz().popWhack()).from(start);
    }

    @SafeVarargs
    public static <T> String fizzbuzzpopwhackzingchopify(T... values) {
        return new FizzBuzz().popWhackZingChop().of(values);
    }

    public static <T> Until<T> fizzbuzzpopwhackzingchopify(T start) {
        return new Until<T>(new FizzBuzz().popWhackZingChop()).from(start);
    }

    public static class Until<T> {

        private FizzBuzz fizzBuzz;
        private T start;

        private Until(FizzBuzz fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        private Until<T> from(T start) {
            this.start = start;
            return this;
        }

        public String until(T end) {
            return fizzBuzz.from(start).to(end);
        }
    }

    public static LearnDivision learnDivision() {
        return new LearnDivision();
    }

    public static class LearnDivision {

        @SafeVarargs
        public final <T> String byFizzbuzzifying(T... values) {
            return new FizzBuzz().whenNumberHasFactors().of(values);
        }

        public <T> Until<T> byFizzbuzzifying(T start) {
            return new Until<T>(new FizzBuzz().whenNumberHasFactors()).from(start);
        }
    }
}