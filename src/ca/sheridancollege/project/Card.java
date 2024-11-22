/**
 * Represents a single card in the Blackjack game.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
package ca.sheridancollege.project;

public class Card {

    private String suit; // Encapsulation: Suit of the card (e.g., Hearts, Diamonds)
    private String rank; // Encapsulation: Rank of the card (e.g., 2, 10, King, Ace)
    private int value; // Encapsulation: Value of the card for scoring purposes

    /**
     * Constructor to initialize the card's attributes.
     * - Ensures encapsulation by setting private fields via the constructor.
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * Getter for the card's value.
     * - Encapsulation: Provides controlled access to the private value field.
     */
    public int getValue() {
        return value;
    }

    /**
     * Provides a readable string representation of the card.
     * - Cohesion: Clearly defines the card's representation.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
