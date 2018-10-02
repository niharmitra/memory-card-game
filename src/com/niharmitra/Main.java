package com.niharmitra;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the card game Memory!");
        System.out.println("Enter m to hear the rules or p to play a game.");

        boolean ready = false;
        while (!ready) {
            switch (userInput.nextLine()) {
                case "m":
                case "M":
                    game.explainRules();
                    System.out.println("Enter m to hear the rules again, or p to start a game.");
                    break;
                case "p":
                case "P":
                    System.out.println("Starting a game! Press q anytime to quit\n" +
                            "Enter a number from 1 to 52 to flip that card.\n" +
                            "Enter s anytime to check your current score.\n" +
                            "Enter h to see which numbers remain.");
                    ready = true;
                    break;
                case "q":
                case "Q":
                    userInput.close();
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Enter m to hear the rules, or p to play a game.");
                    break;
            }
        }

        game.start();
        while (true) {
            if (game.getState() == Game.State.FINISHED) {
                if (playAgain(userInput)) {
                    game.start();
                }
            }
            if (game.getState() == Game.State.RUNNING) {
                boolean tookTurn = false;
                while (!tookTurn) {
                    String input = userInput.nextLine().toLowerCase();
                    if (input.equals("q")) {
                        System.out.println("Quitting the game, play again later!");
                        userInput.close();
                        System.exit(0);
                    }
                    else if (input.equals("s")) {
                        System.out.println("Your current score is " + game.getScore());
                    }
                    else if (input.equals("h")) {
                        System.out.println("Here are the unmatched card numbers:");
                        game.printUnmatchedCards();
                    }
                    else {
                        try {
                            tookTurn = game.takeTurn(Integer.parseInt(input));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Enter a card from 1 to 52.");
                            continue;
                        }
                    }
                }
            }
        }
    }

    private static boolean playAgain(Scanner userInput) {
        System.out.println("Press p to play again, or q to quit.");
        while (true) {
            switch (userInput.nextLine()) {
                case "q":
                case "Q":
                    System.out.println("Play again later!");
                    return false;
                case "p":
                case "P":
                    System.out.println("Starting a game! Press q anytime to quit.");
                    return true;
                default:
                    System.out.println("Press p to play again, or q to quit.");
                    break;
            }
        }
    }
}
