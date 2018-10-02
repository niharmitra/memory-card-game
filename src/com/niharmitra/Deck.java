package com.niharmitra;

import java.util.Collections;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>(52);
        for (int i=0; i<4; i++) {
            for (int j=2; j<=14; j++) {
                cards.add(new Card(Card.Suite.values()[i], j));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deck is not 0 indexed, by card game convention
    public Card get(int index) {
        return cards.get(index-1);
    }

    public int size() {
        return cards.size();
    }
}
