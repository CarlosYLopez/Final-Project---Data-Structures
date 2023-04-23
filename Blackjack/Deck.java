//FILE WRITTEN BY CARLOS Y. LOPEZ

package Blackjack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        //method to create a deck of cards
        //cards are intialized based on Suit,ranked, and a value

        this.cards = new ArrayList<Card>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        //loop through a combination of the three arrays to create all 52 cards
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                Card card = new Card(suits[i], ranks[j], values[j]);
                this.cards.add(card);
            }
        }
    }

    public void shuffle() {
        //shuffle the cards

        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        //deal the cards from the deck
        //remove the top card of the deck and returns

        Card card = this.cards.remove(0);
        return card;
    }
}