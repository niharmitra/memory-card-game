package com.niharmitra;

/**
 * Engine to run the game
 * Initializes rounds, tracks score, etc
 */
public class Game {
    private Deck deck = new Deck();
    private int score; // count flips
    private int matches;
    private Card flipped;

    public enum State {
        RUNNING, FINISHED;
    }
    private State state;

    // Returns true if the cards are a matching pair
    private boolean match(Card a, Card b) {
        if (a.getRank() != b.getRank())
            return false;
        if (a.getColor() != b.getColor())
            return false;
        return true;
    }

    public void start() {
        this.state = State.RUNNING;
        this.deck.shuffle();
        this.score = 0;
        this.flipped = null;
    }

    // return true if input was valid
    public boolean takeTurn(int index) {
        if (this.state == State.FINISHED) {
            System.out.println("You already finished the game in " + this.score + " moves." +
                    " Press R to restart or Q to quit!");
        }
        // Validate input
        if (index <= 0 || index > deck.size()) {
            System.out.println("Card choice out of range, try again");
            return false;
        }
        Card selection = deck.get(index);
        if (selection.isMatched()) {
            System.out.println("Already matched that card, try again");
            return false;
        }
        if (selection.equals(flipped)) {
            System.out.println("You picked the same card, try again");
            return false;
        }

        score++;

        if (flipped == null) {
            flipped = selection;
            System.out.println("You found " + flipped.toString());
            return true;
        }
        if (match(flipped, selection)) {
            flipped.setMatched(true);
            selection.setMatched(true);
            System.out.println("You matched " + flipped.toString() + " and " + selection.toString());
            flipped = null;
            matches++;
            if (matches >= deck.size()/2) {
                System.out.println("You finished the game in " + this.score + " moves!");
                this.state = State.FINISHED;
            }
            return true;
        } else {
            System.out.println("You found " + selection.toString());
            System.out.println(flipped.toString() + " and " + selection.toString() + " don't match!");
            flipped = null;
            return false;
        }

    }

    public void printUnmatchedCards() {
        int consecutive = 0;
        int index = 1;
        while (index <= deck.size()) {
            if (!deck.get(index).isMatched()) {
                if (consecutive == 10) {
                    System.out.print(" " + index + "\n");
                    consecutive = -1;
                } else if (consecutive != 0) {
                    System.out.print(" " + index);
                } else {
                    System.out.print(index);
                }
                consecutive++;
            }
            index++;
        }
        System.out.println("\n");
    }

    public int getScore() {
        return this.score;
    }

    public State getState() {
        return this.state;
    }

    public void explainRules() {
        System.out.println("Your goal is to find all the pairs in the lowest number of turns.\n" +
                "The 52 playing cards will be shuffled in a random order.\n" +
                "Type in a number between 1 and 52 to flip that card." +
                "Type in a different number to flip a second card.\nIf they match color and rank" +
                " (for example, jack of spades and jack of clubs) then the cards are removed.\n" +
                "Find all the pairs to win, and try to use the lowest number of flips!");
    }
}
