/**
 * The entry point for the Blackjack game.
 * Initializes players and starts the game.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
package ca.sheridancollege.project;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("Blackjack");
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));

        game.play();
        game.declareWinner();
    }
}

