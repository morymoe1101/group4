/**
 * Represents the Blackjack game, including gameplay and winner declaration.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final String name; // Encapsulation: The name of the game
    private ArrayList<Player> players; // Aggregation: A collection of Player objects
    private GroupOfCards deck; // Composition: The game owns the deck of cards

    /**
     * Constructor to initialize the game name and create the deck.
     * - Composition: The game owns and manages its deck.
     */
    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.deck = createDeck();
    }

    /**
     * Creates a standard 52-card deck.
     * - Cohesion: Keeps deck creation logic within the game class.
     */
    private GroupOfCards createDeck() {
        GroupOfCards newDeck = new GroupOfCards(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                newDeck.getCards().add(new Card(suit, ranks[i], values[i]));
            }
        }

        newDeck.shuffle();
        return newDeck;
    }

    /**
     * Adds a player to the game.
     * - Encapsulation: Provides controlled access to the player list.
     * - Flexibility: Allows dynamic addition of players.
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * Starts the game and handles gameplay.
     * - Cohesion: Focuses on the gameplay logic.
     * - Flexibility: Easily extendable for new rules or features.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            System.out.println(player.getName() + ", it's your turn!");
            int score = 0;
            boolean continuePlaying = true;

            while (continuePlaying && score <= 21) {
                Card card = deck.getCards().remove(0);
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

    /**
     * Declares the winner based on scores.
     * - Cohesion: Handles the winner declaration logic separately.
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

    /**
     * Getter for the game name.
     * - Encapsulation: Allows controlled access to the name field.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the list of players.
     * - Encapsulation: Ensures controlled access to the player list.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
