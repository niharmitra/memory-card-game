package com.niharmitra;

/**
 * Representation of a card in the game
 */
public class Card {
    public enum Suite {
        SPADES, HEARTS, CLUBS, DIAMONDS;
        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
    private Suite suite;
    private int rank;
    public enum Color {
        BLACK, RED
    }
    private Color color;

    private boolean matched;

    Card(Suite suite, int rank) {
        this.suite = suite;
        if (rank <= 1 || rank > 14) {
            throw new IllegalArgumentException("Invalid card rank");
        }
        this.rank = rank;
        this.matched = false;
        if (this.suite == Suite.CLUBS || this.suite == Suite.SPADES) {
            this.color = Color.BLACK;
        } else {
            this.color = Color.RED;
        }
    }

    public Suite getSuite() {
        return this.suite;
    }

    public int getRank() {
        return this.rank;
    }

    public Color getColor() {
        return this.color;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isMatched() {
        return this.matched;
    }

    @Override
    public String toString() {
        String cardName = "";

        if (this.rank < 10) {
            cardName += this.rank;
        } else {
            switch (this.rank) {
                case 11:
                    cardName += "jack";
                    break;
                case 12:
                    cardName += "queen";
                    break;
                case 13:
                    cardName += "king";
                    break;
                case 14:
                    cardName += "ace";
                    break;
                default:
                    cardName += this.rank;
            }
        }

        cardName += " of ";

        cardName += this.suite.toString();

        return cardName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        return (this.suite == ((Card) obj).getSuite()) &&
                (this.rank == ((Card) obj).getRank());
    }
}
