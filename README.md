[FizzBuzz](https://en.wikipedia.org/wiki/Fizz_buzz) is originally a game to help kids to learn the mathematical division by playing with numbers. If a number has a given factor, it is replaced with the matching word: "Fizz" when divisible by 3, "Buzz" when divisible by 5. Later FizzBuzz becomes a well-known short programming problem to select developer candidates. FizzBuzz is also used as an [icebreaker](https://en.wikipedia.org/wiki/Icebreaker_(facilitation)) for adult groups, in the training, facilitation or [Agile](http://agilemanifesto.org/iso/en/) background . As I was reading further information about FizzBuzz, I realized the problem could be more difficult thanks to many variations, for learning kids as much as for programmers. Thus this game is here an opportunity to play with the Java programming language features as well as some programming paradigms such as the object-oriented and functional ones, while building a fluent API. The whole has been made in the [Test-Driven Development](https://en.wikipedia.org/wiki/Test-driven_development) way and [Git-Flow](http://nvie.com/posts/a-successful-git-branching-model/) is choosen as the version control workflow. 

# Usage

## FizzBuzz basics

### FizzBuzz of one number

To get the result of FizzBuzz for a given number n: `fizzBuzz.of(n)` where `fizzBuzz` is an instance of the `FizzBuzz` class.  
For example: `fizzBuzz.of(3)` returns "Fizz" and `fizzBuzz.of(5)` returns "Buzz".

### FizzBuzz of several arbitrary numbers

To get the result of FizzBuzz for several given numbers n1, n2, ..., nx: `fizzBuzz.of(n1, n2, ..., nx)`.  
For example: `fizzBuzz.of(3, 5, 15)` returns "Fizz Buzz FizzBuzz".

### FizzBuzz of a range of numbers

To get the result of FizzBuzz for a given range of numbers: `fizzBuzz.from(start).to(end)`.  
For example: `fizzBuzz.from(1).to(15)` returns "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz".

Notice that the start and end numbers are *inclusive*.

## More rules

### FizzBuzz variations

You can choose the variation rules to be applied.
- **Classic FizzBuzz**: `fizzBuzz.whenNumberHasFactors()` is the rule by default. `fizzBuzz.whenNumberHasFactors().of(n)` has the same result than `fizzBuzz.of(n)`.
- **Variation according to digits**: `fizzBuzz.whenNumberContainsDigits()` is a variation according to the digits contained by a given number. For example: `fizzBuzz.whenNumberContainsDigits().from(1).to(15)` returns "1 2 Fizz 4 Buzz 6 7 8 9 10 11 12 Fizz 14 Buzz" and `fizzBuzz.whenNumberContainsDigits().of(35)` returns "FizzBuzz".
- **7Boom**: `fizzBuzz.boom()` is a variation to replace any number containing or divisible by 3, 5 or 7 with "Fizz", "Buzz" and "Boom". For example: `fizzBuzz.boom().from(1).to(15)` returns "1 2 Fizz 4 Buzz Fizz Boom 8 Fizz Buzz 11 Fizz Fizz Boom FizzBuzz" and `fizzBuzz.boom().of(7539)` returns "FizzBuzzBoom".
- **FizzBuzzWoof**: `fizzBuzz.woof()` is a variation to replace any number containing or divisible by 3, 5 or 7 with "Fizz", "Buzz" and "Woof", repeated as many times as the condition is true. For example: `fizzBuzz.woof().from(1).to(15)` returns "1 2 FizzFizz 4 BuzzBuzz Fizz WoofWoof 8 FizzFizz Buzz 11 Fizz Fizz Woof FizzBuzzBuzz" and `fizzBuzz.woof().of(35)` returns "FizzBuzzBuzzWoof".
- **FizzBuzzPopWhack**: `fizzBuzz.popWhack()` is a variation to replace any number divisible by 3, 5, 7 or 11 with "Fizz", "Buzz", "Pop" and "Whack" respectively. For example: `fizzBuzz.popWhack().from(1).to(15)` returns "1 2 Fizz 4 Buzz Fizz Pop 8 Fizz Buzz Whack Fizz 13 Pop FizzBuzz" and `fizzBuzz.popWhack().of(1155)` returns "FizzBuzzPopWhack".
- **FizzBuzzPopWhackZingChop**: `fizzBuzz.popWhackZingChop()` is a variation to replace any number divisible by 3, 5, 7, 8 , 11 or 13 with "Fizz", "Buzz", "Pop", "Zing", "Whack" and "Chop" respectively. For example: `fizzBuzz.popWhackZingChop().from(1).to(15)` returns "1 2 Fizz 4 Buzz Fizz Pop Zing Fizz Buzz Whack Fizz Chop Pop FizzBuzz" and `fizzBuzz.popWhackZingChop().of(120120)` returns "FizzBuzzPopWhackZingChop".

### Combining some FizzBuzz variations

You can combine some variation rules to be applied by chaining the corresponding methods.  
For example: `fizzBuzz.whenNumberHasFactors().whenNumberContainsDigits().of(3, 5, 15, 30, 315)` returns "FizzFizz BuzzBuzz FizzBuzzBuzz FizzFizzBuzz FizzFizzBuzzBuzz".

Notice that the variation rules are applied according to the FizzBuzz order: Fizz at first, Buzz after. Also notice that each time a condition is satisfied the matching word is repeated. If you will not, as playing at 7Boom, you can specify it: `fizzBuzz.wordsOnlyOnce().whenNumberHasFactors().whenNumberContainsDigits().of(55)` returns "Buzz" only, instead of "BuzzBuzz". On the contrary, if you wish a word was repeated as many times as a condition is true, you can also specify it: `fizzBuzz.wordsNTimes().whenNumberHasFactors().whenNumberContainsDigits().of(55)` returns "BuzzBuzzBuzz".

### Custom words

You can specify your own custom words, each associated to one number.  
For example: `fizzBuzz.word("Foo", 3).word("Bar", 5).of(3, 5, 15)` returns "Foo Bar FooBar".

## More customizations

### FizzBuzz result as a list

You can get a list of words as a FizzBuzz result instead of a string of words based on the concatenation. Splitting the string result is no longer needed.  
For example: `fizzBuzz.asList().of(3, 5)` returns `{ "Fizz", "Buzz" }`.

### Separating words while printing

You can print the words being separated by predefined or custom separators. The predefined separators are : comma, semi-colon, slash, backslash, dash.  
For example: `fizzBuzz.separatedByComma().of(3, 5)` returns "Fizz, Buzz" and `fizzBuzz.separatedBy("-*-").of(3, 5)` returns "Fizz-\*-Buzz".

The word separator can be a predefined or custom punctuation mark. In this case, the all sentence is completed with it. The predefined punctuation marks are : exclamation mark, full stop (period).  
For example: `fizzBuzz.punctuatedByExclamationMark().of(3, 5)` returns "Fizz! Buzz!" and `fizzBuzz.punctuatedBy("?").of(3, 5)` returns "Fizz? Buzz?".

Some French alternatives exist because of one space before some punctuation marks.  
For example: `fizzBuzz.separatedByFrenchSemiColon().of(3, 5)` returns "Fizz ; Buzz" and `fizzBuzz.separatedByFrenchExclamationMark().of(3, 5)` returns "Fizz ! Buzz !".

You can even print the fizzbuzzified numbers between brackets just after the FizzBuzz words.  
For example: `fizzBuzz.separatedByComma().withNumbers().from(1).to(5)` returns "1, 2, Fizz (3), 4, Buzz (5)". 

## More features

### Finding the most Fizzy-Buzzy

You can find the most Fizzy-Buzzy number in some given arbitrary numbers or in a given range of numbers, that is to say the number whose the corresponding expression after being fizzbuzzified contains the greater number of FizzBuzz words, such as "Fizz" or "Buzz".  
For example: `fizzBuzz.findTheMostFizzyBuzzy().of(1, 3).asNumber()` returns 3 and `fizzBuzz.findTheMostFizzyBuzzy().from(1).to(15).asNumber()` returns 15.

You can find the most Fizzy-Buzzy expression in some given arbitrary numbers or in a given range of numbers, that is to say the expression that contains the greater number of FizzBuzz words, such as "Fizz" or "Buzz".  
For example: `fizzBuzz.findTheMostFizzyBuzzy().of(1, 3).asWord()` returns "Fizz" and `fizzBuzz.findTheMostFizzyBuzzy().from(1).to(15).asWord()` returns "FizzBuzz".

# Release Notes

## Version 1.4

- The FizzBuzzPopWhack variation is implemented: every number divisible by 7 or 11 is replaced with "Pop" or "Whack" respectively, in addition to the FizzBuzz basics.
- The FizzBuzzPopWhackZingChop is implemented: every number divisible by 8 or 13 is replaced with "Zing" or "Chop" respectively, in addition to the FizzBuzzPopWhack basics.
- Custom words can be specified instead of the usual "Fizz" and "Buzz" words, and associated to one number.
- The fizzbuzzified numbers can be got as a list of strings, instead of one string.
- It is possible to find the most fizzbuzzified number in some arbitrary numbers or in a range of numbers.
- It is possible to find the most fizzy-buzzy word in some arbitrary numbers or in a range of numbers.

## Version 1.3

- Any specified word can be repeated as many times as a given number has a factor or contains a digit.
- The FizzBuzzWoof variation is implemented: every number divisible by 7 or containing the digit 7 is replaced with "Woof", in addition to the FizzBuzz basics, and a word is repeated as many times as one condition is true.

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
