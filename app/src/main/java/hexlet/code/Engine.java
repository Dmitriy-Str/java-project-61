package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final int ROUNDS_COUNT = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void run(Game game) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(game.getDescription());
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String[] round = game.generateRound();
            System.out.println("Question: " + round[0]);
            System.out.print("Your answer: ");
            var answer = SCANNER.next();
            if (!answer.equals(round[1])) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
