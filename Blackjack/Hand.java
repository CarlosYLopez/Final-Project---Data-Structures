//FILE WRITTEN BY CARLOS Y. LOPEZ

package Blackjack;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int value;

    public Hand() {
        this.cards = new ArrayList<Card>();
        this.value = 0;
    }

    //add a card to the hand update teh value of the hand

    public void addCard(Card card) {
        this.cards.add(card);
        this.value += card.getValue();

        //if card is an ACE, check if the value would be over 21 if so it is 1 if not it is 11
        if (card.getRank().equals("Ace") && this.value <= 11) {
            this.value += 10;
        }
    }

    public int getValue() {
        return this.value;
    }

    //clear the cards from hand setting the value to 0
    public void clear() {
        this.cards.clear();
        this.value = 0;
    }

    //return card in hand
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    //print cards in the hand
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }
}