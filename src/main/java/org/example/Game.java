package org.example;

import org.example.type.Range;

import java.util.Random;

public class Game {
    private final Range range;
    private final int secretNumber;
    private final int maxAttempts;
    private int attempts;
    private int guessedNumber;

    private Game(Range range, int secretNumber, int maxAttempts) {
        this.range = range;
        this.secretNumber = secretNumber;
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
        this.guessedNumber = range.getMin() - 1;
    }

    public static Game of(Range range, int maxAttempts) {
        Random generator = new Random();
        int secretNumber = generator.nextInt(range.getMax()) + range.getMin();

        System.out.println("Guess the number (between 1 and 100)!");
        System.out.println("debug : the expected secret number is " + secretNumber);

        return new Game(range, secretNumber, maxAttempts);
    }

    public void Play() {
        do {
            tryToGuess();
            attempts++;
        } while (!isOver());

        if (guessedNumber == secretNumber) {
            System.out.println("You found it after " + attempts + " tries!");
        } else {
            System.out.println("You lost! The secret number was " + secretNumber);
        }
    }

    private boolean isOver() {
        return guessedNumber != secretNumber && attempts >= maxAttempts;
    }

    private void tryToGuess() {
        try {
            this.guessedNumber = Integer.parseInt(Console.getUserInput("Enter your guess: "));
            if (!range.numberIsInRange(guessedNumber)) {
                String divergence = guessedNumber < secretNumber ? "smaller" : "greater";
                System.out.println("Wrong! Your number is " + divergence + " than the correct one. " + (maxAttempts - attempts) + "/" + maxAttempts + " tries left");
            }
        } catch (NumberFormatException e) {
            System.out.println("Your input was '" + guessedNumber + "', please enter a valid integer. " + (maxAttempts - attempts) + "/" + maxAttempts + " tries left");
        }
    }
}
