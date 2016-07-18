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
- Classic FizzBuzz: fizzBuzz.whenNumberHasFactors() is the rule by default. fizzBuzz.whenNumberHasFactors().of(n) has the same result than fizzBuzz.of(n).
- Variation according to digits: fizzBuzz.whenNumberContainsDigits() is a variation according to the digits contained by a given number. For example: fizzBuzz.whenNumberContainsDigits().from(1).to(15) returns "1 2 Fizz 4 Buzz 6 7 8 9 10 11 12 Fizz 14 Buzz" and fizzBuzz.whenNumberContainsDigits().of(35) returns "FizzBuzz".
- 7Boom: fizzBuzz.boom() is a variation to replace any number containing or divisible by 3, 5 or 7 with "Fizz", "Buzz" and "Boom". For example: fizzBuzz.boom().from(1).to(15) returns "1 2 Fizz 4 Buzz Fizz Boom 8 Fizz Buzz 11 Fizz Fizz Boom FizzBuzz" and fizzBuzz.boom().of(7539) returns "FizzBuzzBoom".

## Combining some FizzBuzz variations

You can combine some variation rules to be applied by chaining the corresponding methods.  
For example: fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().of(3, 5, 15, 30, 315) returns "FizzFizz BuzzBuzz FizzBuzzBuzz FizzFizzBuzz FizzFizzBuzzBuzz".

Notice that the variation rules are applied according to the FizzBuzz order: Fizz at first, Buzz after. Also notice that each time a condition is satisfied the matching word is repeated. If you will not, as playing at 7Boom, you can specify it : fizzBuzz.wordsOnlyOnce().whenNumberHasFactors().whenNumberContainsDigits().of(55) returns "Buzz" only, instead of "BuzzBuzz".

## Separating words while printing

You can print the words being separated by predefined or custom separators. The predefined separators are : comma, semi-colon, slash, backslash, dash.  
For example: fizzBuzz.separatedByComma().of(3, 5) returns "Fizz, Buzz" and fizzBuzz.separatedBy("-\*-").of(3, 5) returns "Fizz-\*-Buzz".

The word separartor can be a predefined or custom punctuation mark. In this case, the all sentence is completed with it. The predefined punctuation marks are : exclamation mark, full stop (period). 
For example: fizzBuzz.punctuatedByExclamationMark().of(3, 5) returns "Fizz! Buzz!" and fizzBuzz.punctuatedBy("?").of(3, 5) returns "Fizz? Buzz?".  

Some French alternatives exist because of one space before some punctuation marks.  
For example: fizzBuzz.separatedByFrenchSemiColon().of(3, 5) returns "Fizz ; Buzz" and fizzBuzz.separatedByFrenchExclamationMark().of(3, 5) returns "Fizz ! Buzz !".

You can even print the fizzbuzzified numbers between brackets just after the FizzBuzz words.  
For example: fizzBuzz.separatedByComma().withNumbers().from(1).to(5) returns "1, 2, Fizz (3), 4, Buzz (5)". 

# Release Notes

## Version 1.2

- The 7Boom variation is implemented: every number divisible by 7 or containing the digit 7 is replaced with "Boom", in addition to the FizzBuzz basics.
- Variation combinations can be played by repeating or not the words each time a number satisfies a condition.
- The words can be printed being separated by predefined separators or custom separators. If the separator is a punctuation mark, the all sentence is completed with it.
- The printed FizzBuzz words can be followed by the fizzbuzzified number between brackets.

## Version 1.1

- Instead of replacing numbers that have 3 or 5 as a factor, the game can be played by replacing numbers containing the digit 3 or 5 with "Fizz" or "Buzz".
- Any number that contains the number or is divisible by that number is replaced by the matching word.

## Version 1.0

- Write a program that prints the numbers from 1 to 100.
- But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
- For numbers which are multiples of both three and five print “FizzBuzz”.
