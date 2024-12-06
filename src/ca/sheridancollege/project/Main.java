package ca.sheridancollege.project;

import java.util.Scanner;  // Import Scanner for user input

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for user input
        
        // Prompt user to enter names for two players
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();  // Read name for Player 1
        
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();  // Read name for Player 2
        
        // Get the singleton instance of the game
        Game game = Game.getInstance("Blackjack");

        // Add players to the game using the entered names
        game.addPlayer(new Player(player1Name));  // Add Player 1 with the provided name
        game.addPlayer(new Player(player2Name));  // Add Player 2 with the provided name

        // Start the game and declare the winner
        game.play();
        game.declareWinner();

        scanner.close();  // Close the scanner
    }
}
