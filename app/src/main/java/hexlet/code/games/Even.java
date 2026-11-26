package hexlet.code.games;

import hexlet.code.Game;
import java.util.Random;

public class Even implements Game {
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public String getDescription() {
        return "Answer \"yes\" if the number is even, otherwise answer \"no\".";
    }

    public String[] generateRound() {
        var randomNumber = RANDOM.nextInt(MAX_NUMBER);
        var answer = randomNumber % 2 == 0 ? "yes" : "no";
        return new String[] {String.valueOf(randomNumber), answer};
    }
}
