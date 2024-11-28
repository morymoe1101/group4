/**
 * The entry point for the Blackjack game. Initializes players and starts the game.
 *Author: Group3
 
 */
package ca.sheridancollege.project;

public class Main {

    public static void main(String[] args) {
        // Get the instance of the game using Singleton
        Game game = Game.getInstance("Blackjack");
        // Add players to the game
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));

        // Start the game and declare the winner
        game.play();
        game.declareWinner();
    }
}
