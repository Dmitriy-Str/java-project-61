package hexlet.code.games;

import hexlet.code.Game;
import java.util.Random;

public class Gcd implements Game {
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    private static int minDivisor(int operand1, int operand2) {
        if (operand2 == 0) {
            return operand1;
        }
        return minDivisor(operand2, operand1 % operand2);
    }

    public String[] generateRound() {
        var operand1 = RANDOM.nextInt(MAX_NUMBER);
        var operand2 = RANDOM.nextInt(MAX_NUMBER);
        var answer = minDivisor(operand1, operand2);
        return new String[] {String.valueOf(operand1 + " " + operand2), String.valueOf(answer)};
    }
}
