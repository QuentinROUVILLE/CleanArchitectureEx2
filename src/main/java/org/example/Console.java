package org.example;

import java.util.Scanner;

public class Console {
    public static String getUserInput(String inputInfoMessage) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(inputInfoMessage);
        String input = scanner.nextLine();

        scanner.close();

        return input;
    }

    public static void printWelcomeMessage() {
        System.out.println("-===========================-");
        System.out.println("=== GUESS THE NUMBER GAME ===");
        System.out.println("-===========================-");
    }
}
