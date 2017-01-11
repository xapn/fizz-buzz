package software.works.fizzbuzz;

public class I {

    @SafeVarargs
    public static <T> String fizzbuzzify(T... values) {
        return new FizzBuzz().of(values);
    }

    public static <T> Until<T> fizzbuzzify(T from) {
        return new Until<T>(from);
    }

    public static class Until<T> {

        private T start;

        private Until(T start) {
            this.start = start;
        }

        public String until(T end) {
            return new FizzBuzz().from(start).to(end);
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
    }
}