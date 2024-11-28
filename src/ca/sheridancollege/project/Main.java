/*
  The entry point for the Blackjack game. Initializes players and starts the game.
 *Author: Group3
 
 */
package ca.sheridancollege.project;

public class Main {

    public static void main(String[] args) {
        
        Game game = Game.getInstance("Blackjack");// Get the instance of the game using Singleton
       
        game.addPlayer(new Player("Player 1")); // Add players to the game
        game.addPlayer(new Player("Player 2"));


        game.play();
        game.declareWinner();        // Start the game and declare the winners
    }
}
