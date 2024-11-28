/**
 * Factory class to create cards and decks for the Blackjack game.
 * Author: Group3
=
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public class CardFactory {

    /**
     * Creates a standard 52-card deck and shuffles it.
     */
    public static GroupOfCards createDeck() {
        GroupOfCards newDeck = new GroupOfCards(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; // Ace = 11

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                newDeck.getCards().add(new Card(suit, ranks[i], values[i]));
            }
        }

        newDeck.shuffle();
        return newDeck;
    }
}
