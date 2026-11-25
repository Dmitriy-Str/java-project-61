package hexlet.code;

import hexlet.code.games.Even;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void printMenu() {
        String[] menuItems = {
                "1 - Greet",
                "2 - Even",
                "0 - Exit"
        };
        for (String menu: menuItems) {
            System.out.println(menu);
        }
    }

    private static void processChoice(String gameNumber) {
        Map<String, Runnable> games = Map.of(
                "1", Cli::main,
                "2", () -> Engine.run(new Even()),
                "0", () -> System.out.println("Goodbye")
        );
        games.getOrDefault(gameNumber, () -> {
            throw new RuntimeException("Unknown choice: " + gameNumber);
        }).run();
    }

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        printMenu();
        String gameNumber = SCANNER.next();
        System.out.println("Your choice: " + gameNumber + "\n");
        processChoice(gameNumber);
    }
}
