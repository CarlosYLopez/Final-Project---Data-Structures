import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int value;

    public Hand() {
        this.cards = new ArrayList<Card>();
        this.value = 0;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.value += card.getValue();
        if (card.getRank().equals("Ace") && this.value <= 11) {
            this.value += 10;
        }
    }

    public int getValue() {
        return this.value;
    }

    public void clear() {
        this.cards.clear();
        this.value = 0;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }
}