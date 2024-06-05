import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


/**
 *  models a deck of playing cards
 */
public class Deck {
    private static final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private static final Integer[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 51;
    /**
     * constructor
     * creates a deck of cards for each rank and suit
     *
     * @param ArrayList Card
     * @param Integer nextToDeal
     */
    private ArrayList<Card> cards;
    private int nextToDeal;

    public Deck() {
        cards = new ArrayList<>();
        this.nextToDeal = FIRST_INDEX;
        for (Integer rank : RANKS) {
            for (String suit : SUITS) {
                this.cards.add(new Card(rank, suit));
            }
        }

    }


    /**
     * Prints the deck as a string.
     *
     * @return string form of the deck.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Card> undealtDeck = cards.subList(nextToDeal, this.size());
        for (Card convertString : undealtDeck){
            sb.append(" | ");
            sb.append(convertString);
            sb.append(" | ");
            sb.append("\n");
        }
    return sb.toString();
    }

    /**
     * shuffles the deck by randomly swapping
     * the location of each card's index.
     */
    public void shuffle() {

        List changingDeck = cards.subList(nextToDeal, LAST_INDEX);
        int changingDeckSize = changingDeck.size();
        for (int i = 0; i < changingDeckSize; i++) {
            int randCard = ThreadLocalRandom.current().nextInt(nextToDeal, LAST_INDEX - 1);
            Card swapper = cards.get(i);
            cards.set(i, cards.get(randCard));
            cards.set(randCard, swapper);
        }
    }

    /**
     * Checks if there are any cards left in the deck
     *
     * @return true if deck is empty, false if it is not.
     */
    public boolean isEmpty() {
        if (this.cards.size() - this.nextToDeal == FIRST_INDEX) {
            return true;
        }
        return false;
    }

    public int size() {
        return cards.size();
    }

    /**
     * Access the card at nextToDeal
     * and then increase the card to deal by 1.
     * @return the card at the index of nextToDeal. (top of the deck)
     */
    public Card dealCard() {

        if (isEmpty()) {
            System.out.println("The deck is empty! Try again.");
            return null;
        } else {
                int cardToDeal = nextToDeal;
                nextToDeal++;
                return cards.get(cardToDeal);
            }

        }

    /**
     * Gathers the deck back together.
     */
    public void gather(){
        nextToDeal = FIRST_INDEX;
    }

    }




