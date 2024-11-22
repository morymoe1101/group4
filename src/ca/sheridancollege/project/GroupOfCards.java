/**
 * This class manages the deck of cards.
 * It shuffles the deck and deals cards to players.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<Card> cards; // Aggregation: A collection of Card objects
    private int size; // Encapsulation: The maximum size of the deck

    /**
     * Constructor initializes the deck with a specific size.
     * - Encapsulation: Ensures size is set upon object creation.
     * - Aggregation: The deck contains a collection of independent Card objects.
     */
    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    /**
     * Returns the current list of cards in the deck.
     * - Encapsulation: Allows controlled access to the private cards field.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Shuffles the deck randomly.
     * - Flexibility: Uses `Collections.shuffle` for easy reusability and randomness.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
}