package software.works.fizzbuzz;

public class I {

    @SafeVarargs
    public static <T> String fizzbuzzify(T... values) {
        return new FizzBuzz().of(values);
    }
}