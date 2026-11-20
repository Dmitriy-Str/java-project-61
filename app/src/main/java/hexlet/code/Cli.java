package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void main() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");
        sc.close();
    }
}
