
/**
 *  models a single playing card
 */
public class Card {
    public static final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};
    public static final Integer[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private int[] ranks;
    private String[] suits;
    /**
     * constructor
     *
     * @param rank integer between 2-14
     * @param suit string of each suit (Spades, Hearts, Clubs, Diamonds)
     */
    public Card(Integer rank, String suit) {

        ranks = new int[1];
        ranks[0] = rank;
        suits = new String[1];
        suits[0] = suit;

    }

        /**
         * getter
         * @return rank int from 2-14
         */
    public Integer getRank() {
        return ranks[0];
    }

    /**
     * getter
     * @return suit int from 0-3 (0=Spades, 1=Hearts, 2=Clubs, 3=Diamonds)
     */
    public String getSuit() {
        return suits[0];
    }

    /**
     * get rank as string
     * @return rank as 2-10 or Jack, Queen, King, or Ace
     */
    private String getRankString(){
        int cardRank = this.getRank();
        if (cardRank==11) {
            return "Jack";
        }
        else if (cardRank==12) {
            return "Queen";
        }
        else if (cardRank==13) {
            return "King";
        }
        else if (cardRank==14) {
            return "Ace";
        }
        else {
            String rankAsString = "" + cardRank;
            return rankAsString;
        }
    }

    /**
     * return card in string format
     * @return card as string
     */
    public String toString()
    {
        return this.getRankString() + " of " + this.getSuit();
    }
}