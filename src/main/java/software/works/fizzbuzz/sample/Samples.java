package software.works.fizzbuzz.sample;

import software.works.fizzbuzz.FizzBuzz;

public class Samples {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();

        System.out.println(fizzBuzz.from(1).to(100));

        System.out.println(fizzBuzz.whenNumberHasFactors().from(1).to(100));

        System.out.println(fizzBuzz.whenNumberContainsDigits().from(1).to(100));
    }
}