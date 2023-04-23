package Blackjack;
import java.util.Scanner;

public class Blackjack implements Game {
    private Deck deck;
    private Hand player_hand;
    private Hand dealer_hand;
    private boolean player_stands;

    public Blackjack() {
        this.deck = new Deck();
        this.deck.shuffle();
        this.player_hand = new Hand();
        this.dealer_hand = new Hand();
        this.player_stands = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Classic Blackjack!");

        // Deal initial cards
        this.player_hand.addCard(this.deck.dealCard());
        this.dealer_hand.addCard(this.deck.dealCard());
        this.player_hand.addCard(this.deck.dealCard());
        this.dealer_hand.addCard(this.deck.dealCard());

        // Player's turn
        while (true) {
            System.out.println("Your hand:");
            this.player_hand.print();
            System.out.println("Your total: " + this.player_hand.getValue());

            if (this.player_stands) {
                break;
            }

            System.out.println("Do you want to hit or stand? (H/S)");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("H")) {
                this.player_hand.addCard(this.deck.dealCard());
                if (this.player_hand.getValue() > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (input.equals("S")) {
                this.player_stands = true;
            }
        }

        // Dealer's turn
        while (this.dealer_hand.getValue() < 17) {
            this.dealer_hand.addCard(this.deck.dealCard());
        }
        System.out.println("Dealer's hand:");
        this.dealer_hand.print();
        System.out.println("Dealer's total: " + this.dealer_hand.getValue());

        // Determine winner
        int player_total = this.player_hand.getValue();
        int dealer_total = this.dealer_hand.getValue();
        if (player_total > dealer_total || dealer_total > 21) {
            System.out.println("You win!");
        } else if (player_total < dealer_total) {
            System.out.println("You lose.");
        } else {
            System.out.println("Push.");
        }
    }
}