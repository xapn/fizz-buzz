[FizzBuzz](https://en.wikipedia.org/wiki/Fizz_buzz)

# Usage

## FizzBuzz of one number

To get the result of FizzBuzz for a given number n: fizzBuzz.of(n) where fizzBuzz is an instance of the FizzBuzz class.  
For example: fizzBuzz.of(3) returns "Fizz" and fizzBuzz.of(5) returns "Buzz".

## FizzBuzz of several arbitrary numbers

To get the result of FizzBuzz for several given numbers n1, n2, ..., nx: fizzBuzz.of(n1, n2, ..., nx).  
For example: fizzBuzz.of(3, 5, 15) returns "Fizz Buzz FizzBuzz".

## FizzBuzz of a range of numbers

To get the result of FizzBuzz for a a given range of numbers : fizzBuzz.from(start).to(end).  
For example: fizzBuzz.from(1).to(15) returns "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz".

Notice that the start and end numbers are inclusive.

## FizzBuzz variations

You can choose the variation rules to be applied.
- fizzBuzz.whenNumberHasFactors() is the rule by default. fizzBuzz.whenNumberHasFactors().of(n) has the same result than fizzBuzz.of(n).
- fizzBuzz.whenNumberContainsDigits() is a variation according to the digits contained by a given number. For example: fizzBuzz.whenNumberContainsDigits().from(1).to(10) returns "1 2 Fizz 4 Buzz 6 7 8 9 10 11 12 Fizz 14 Buzz" and fizzBuzz.whenNumberContainsDigits().of(35) returns "FizzBuzz".

## Combining some FizzBuzz variations

You can combine some variation rules to be applied by chaining the corresponding methods.  
For example: fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().of(3, 5, 15, 30, 315) returns "FizzFizz BuzzBuzz FizzBuzzBuzz FizzFizzBuzz FizzFizzBuzzBuzz".

Notice that the variation rules are applied according to the FizzBuzz order: Fizz at first, Buzz after.

# Release Notes

## Version 1.1

- Instead of replacing numbers that have 3 or 5 as a factor, the game can be played by replacing numbers containing the digit 3 or 5 with "fizz" or "buzz".
- Any number that contains the number or is divisible by that number is replaced by the matching word.

## Version 1.0

- Write a program that prints the numbers from 1 to 100.
- But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
- For numbers which are multiples of both three and five print “FizzBuzz”.
