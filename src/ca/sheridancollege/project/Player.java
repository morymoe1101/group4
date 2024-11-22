/**
 * Represents a player in the Blackjack game.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
package ca.sheridancollege.project;

public class Player {

    private String name; // Encapsulation: Unique identifier for the player
    private int score; // Encapsulation: The player's current score

    /**
     * Constructor to initialize the player's name and starting score.
     * - Encapsulation: Ensures fields are set via the constructor.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Getter for the player's name.
     * - Encapsulation: Provides controlled access to the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the player's name.
     * - Flexibility: Allows updates to the player's name when needed.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the player's score.
     * - Encapsulation: Allows controlled access to the player's current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the player's score.
     * - Encapsulation: Ensures the score is updated safely.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Placeholder for player-specific logic.
     * - Cohesion: Keeps player-related logic within the Player class.
     * - Flexibility: Allows future customization of player behavior.
     */
    public void play() {
        // Logic for player actions can be implemented if needed in the future
    }
}
