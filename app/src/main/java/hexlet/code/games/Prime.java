package hexlet.code.games;

import hexlet.code.Game;
import java.util.Random;

public class Prime implements Game {
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public String[] generateRound() {
        var randomNumber = RANDOM.nextInt(MAX_NUMBER);
        var answer = isPrime(randomNumber) ? "yes" : "no";
        return new String[] {String.valueOf(randomNumber), answer};
    }
}
