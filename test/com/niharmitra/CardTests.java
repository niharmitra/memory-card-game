package com.niharmitra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTests {
    @Test
    void testConstructor() {
        // check all valid cards don't throw exceptions
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i <= 14; i++) {
                new Card(Card.Suite.values()[j], i);
            }
        }

        // test various invalid cards
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Card.Suite.CLUBS, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Card.Suite.CLUBS, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Card.Suite.DIAMONDS, -10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Card.Suite.CLUBS, 15);
        });
    }

    @Test
    void testToString() {
        assertEquals(new Card(Card.Suite.DIAMONDS, 2).toString(), "2 of diamonds");
        assertEquals(new Card(Card.Suite.DIAMONDS, 9).toString(), "9 of diamonds");
        assertEquals(new Card(Card.Suite.HEARTS, 10).toString(), "10 of hearts");
        assertEquals(new Card(Card.Suite.HEARTS, 11).toString(), "jack of hearts");
        assertEquals(new Card(Card.Suite.CLUBS, 13).toString(), "king of clubs");
        assertEquals(new Card(Card.Suite.SPADES, 14).toString(), "ace of spades");
        assertEquals(new Card(Card.Suite.SPADES, 12).toString(), "queen of spades");
    }

    @Test
    void testEquals() {
        assertTrue(new Card(Card.Suite.CLUBS, 2).equals(new Card(Card.Suite.CLUBS, 2)));
        assertTrue(new Card(Card.Suite.CLUBS, 10).equals(new Card(Card.Suite.CLUBS, 10)));
        assertTrue(new Card(Card.Suite.DIAMONDS, 11).equals(new Card(Card.Suite.DIAMONDS, 11)));
        assertTrue(new Card(Card.Suite.SPADES, 13).equals(new Card(Card.Suite.SPADES, 13)));
        assertTrue(new Card(Card.Suite.HEARTS, 14).equals(new Card(Card.Suite.HEARTS, 14)));

        assertFalse(new Card(Card.Suite.HEARTS, 14).equals(new Card(Card.Suite.HEARTS, 13)));
        assertFalse(new Card(Card.Suite.HEARTS, 11).equals(new Card(Card.Suite.HEARTS, 13)));
        assertFalse(new Card(Card.Suite.DIAMONDS, 14).equals(new Card(Card.Suite.HEARTS, 14)));
        assertFalse(new Card(Card.Suite.SPADES, 2).equals(new Card(Card.Suite.CLUBS, 2)));
    }

}