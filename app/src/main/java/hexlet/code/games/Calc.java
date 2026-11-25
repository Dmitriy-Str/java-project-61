package hexlet.code.games;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import hexlet.code.Game;

public class Calc implements Game {
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();
    private static final String[] OPERATORS =  {"+", "-", "*"};

    public String getDescription() {
        return "What is the result of the expression?";
    }

    private static int calculate(int operand1, int operand2, String operator) {
        Map<String, Supplier<Integer>> operations = Map.of(
                "+", () -> operand1 + operand2,
                "-", () -> operand1 - operand2,
                "*", () -> operand1 * operand2
        );
        return operations.getOrDefault(operator, () -> {
            throw new IllegalArgumentException("Unknown operator: " + operator);
        }).get();
    }

    public String[] generateRound() {
        var operand1 = RANDOM.nextInt(MAX_NUMBER);
        var operand2 = RANDOM.nextInt(MAX_NUMBER);
        var operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
        var question = operand1 + " " + operator + " " + operand2;
        var answer = calculate(operand1, operand2, operator);
        return new String[] {question, String.valueOf(answer)};
    }
}
