package chapter11;
import java.util.*;
import java.util.function.*;
class Guess
{
    int number;
    int guess;
    public Guess(int n) { number = n; }
    public Guess(int g, int n) { guess = g; number = n; }
}
public class GuessANumber 
{
    public static void main(String[] args)
    {
        UnaryOperator<Guess> guessIt = x -> {
           System.out.print("Guess a number between 0 and 9:");
           return new Guess(new Scanner(System.in).nextInt(),
                            x.number); 
        };

        Predicate<Guess> guessIsCorrect = x -> x.guess != x.number;        
        
        Optional.of(new Guess(new Random().nextInt(10)))
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .ifPresent(x -> System.out.println(
                           "Sorry, couldn't guess " + x.number));
    }
}