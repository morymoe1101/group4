/*
  Represents the Blackjack game, including gameplay and winner declaration.
  Author: Group3
 
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static Game instance; // Singleton: Only one instance of Game
    private final String name; // The name of the game
    private ArrayList<Player> players; // List of players
    private GroupOfCards deck; // The deck of cards (Composition)

    /*
      Private constructor for Singleton.
     */
    private Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.deck = CardFactory.createDeck(); // Use the Factory method to create the deck
    }

    /*
      Singleton method to get the instance of the Game.
     */
    public static Game getInstance(String name) {
        if (instance == null) {
            instance = new Game(name); // Create a new instance if it doesn't exist
        }
        return instance;
    }

    /*
      Adds a player to the game.
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /*
      Starts the game and handles gameplay.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            System.out.println(player.getName() + ", it's your turn!");
            int score = 0;
            boolean continuePlaying = true;

            while (continuePlaying && score <= 21) {
                Card card = deck.getCards().remove(0); // Deal the top card
                System.out.println("You drew: " + card);
                score += card.getValue();
                System.out.println("Your current score: " + score);

                if (score >= 21) break;

                System.out.print("Do you want to draw another card? (yes/no): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("no")) {
                    continuePlaying = false;
                }
            }

            if (score > 21) {
                System.out.println(player.getName() + " has busted with a score of " + score + "!");
            } else {
                System.out.println(player.getName() + "'s final score is: " + score);
            }

            player.setScore(score);
        }

        scanner.close();
    }

    /*
      Declares the winner based on scores.
     */
    public void declareWinner() {
        Player winner = null;
        int highestScore = 0;

        for (Player player : players) {
            int score = player.getScore();
            if (score > highestScore && score <= 21) {
                highestScore = score;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + highestScore + "!");
        } else {
            System.out.println("No one wins this round. Everyone busted!");
        }
    }

    /*
      Getter for the game name.
     */
    public String getName() {
        return name;
    }

    /*
      Getter for the list of players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
