package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Map;

public class App {

    private static void printMenu() {
        String[] menuItems = {
            "1 - Greet",
            "2 - Even",
            "3 - Calc",
            "4 - GCD",
            "5 - Progression",
            "6 - Prime",
            "0 - Exit"
        };
        for (String menu : menuItems) {
            System.out.println(menu);
        }
    }

    private static void processChoice(String gameNumber) {
        Map<String, Runnable> games =
                Map.of(
                        "1", Cli::main,
                        "2", () -> Engine.run(new Even()),
                        "3", () -> Engine.run(new Calc()),
                        "4", () -> Engine.run(new Gcd()),
                        "5", () -> Engine.run(new Progression()),
                        "6", () -> Engine.run(new Prime()),
                        "0", () -> System.out.println("Goodbye"));
        games.getOrDefault(gameNumber, () -> System.out.println("Unknown choice: " + gameNumber))
                .run();
    }

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        printMenu();
        String gameNumber = Engine.SCANNER.next();
        System.out.println("Your choice: " + gameNumber + "\n");
        processChoice(gameNumber);
    }
}
