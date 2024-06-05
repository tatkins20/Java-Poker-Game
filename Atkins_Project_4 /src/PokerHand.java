import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand {
    private ArrayList<Card> PokerHand;
    private static final int FIRST_INDEX = 0;
    private static final int HANDLENGTH = 5;
    private static final int UNIDENTIFIED = 9999;
    private static final int FLUSH_VALUE = 5;
    private static final int TWO_PAIR_VALUE = 4;
    private static final int PAIR_VALUE = 3;
    private static final int HIGH_CARD_VALUE = 2;
    private static final int NO_PAIR = 0;
    private static final int PAIR = 2;
    /**
     * Takes in a list of cards to create a Poker hand.
     * @param cardList the list of cards the hand takes in
     */
    public PokerHand(ArrayList<Card> cardList) {
        this.PokerHand = cardList;
    }

    /**
     * Takes a card and adds it to the contents of a Hand
     *
     * @param card Takes in a card
     */
    public void addCard(Card card) {
        if (PokerHand.size() > HANDLENGTH) {
            System.out.println("Hand is full.");
        } else if (PokerHand.size() < HANDLENGTH) {
            PokerHand.add(card);
        }
    }

    /**
     * Gets the i-th card in the hand
     * @param index is the i-th card of the hand
     * @return the i-th card
     */
    public Card get_ith_card(int index){
        if (index < FIRST_INDEX){
            return null;
        }
        else{
            return PokerHand.get(index);
        }
    }

    /**
     * Checks to see if the hand is a flush
     * @return true if it is a flush, false
     * if it is not.
     */
    public boolean isFlush() {
        boolean flush = true;
            for (int i = FIRST_INDEX; i < HANDLENGTH -1; i++) {
                if (!flush){
                    return flush;
                }

                if (PokerHand.get(i).getSuit().equals(PokerHand.get(i + 1).getSuit())) {
                    flush = true;
                }

                else{
                    flush = false;
                }
            }
        return flush;}

    /**
     * Checks to see if the hand has a pair
     * @return true if it has a pair,
     * false if it does not.
     */
    public boolean isPair() {
        for (int rank : Card.RANKS) {
            int counter = NO_PAIR;
            for (Card card : this.PokerHand) {
                if (card.getRank() == rank) {
                    counter++;
                    if (counter == PAIR) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     * Gets the rank of the pair or two pair
     * @return the rank of the
     * pair or two pair
     */
    private int pairRank(){
        for(int rank: Card.RANKS){
            int counter = NO_PAIR;
            for(Card card: this.PokerHand){
                if (card.getRank() == rank){
                    counter ++;
                    if (counter == PAIR){
                        return rank;
                    }
                }
            }

        }
        return 0;
    }

    /**
     * Checks if the two pair is a four of a kind
     * @return true if it is a four of a kind, false if it is not.
     */
    private boolean fourkindTwoPair(){
        int counter1 = FIRST_INDEX;
        int counter2 = FIRST_INDEX;
        for (Card card: this.PokerHand){
            if (card.getRank().equals(this.PokerHand.get(FIRST_INDEX).getRank()))
                counter1 ++;
            if (card.getRank().equals(this.PokerHand.get(FIRST_INDEX+1).getRank()))
                counter2++;
        if(counter1 == PAIR + PAIR || counter2 == PAIR + PAIR){
            return true;
        }
        } return false;
    }

    /**
     * Gets the rank of the four of a kind two pair
     * @return the rank
     */
    private int fourkindRank(){
        int counter1 = FIRST_INDEX;
        int counter2 = FIRST_INDEX;
        for(Card card : this.PokerHand){
            if (card.getRank().equals(this.PokerHand.get(FIRST_INDEX).getRank()))
                counter1 ++;
            if (card.getRank().equals(this.PokerHand.get(FIRST_INDEX+1).getRank()))
                counter2 ++;
        if (counter1 == 4)
            return this.PokerHand.get(FIRST_INDEX).getRank();
        if (counter2 == 4)
            return this.PokerHand.get(FIRST_INDEX+1).getRank();
        }
        return fourkindRank();
    }

    /**
     * Checks to see if the hand has a two pair.
     * @return true if there is a two pair,
     * false if there is not.
     */
    private boolean twoPair(){
        if(this.fourkindTwoPair()){
            return true;
        }
        int skipRank = this.pairRank();
        for(int rank: Card.RANKS){
            int counter = NO_PAIR;
            for(Card card : this.PokerHand){
                if (card.getRank().equals(rank) && card.getRank()!=skipRank){
                    counter++;
                    if (counter == PAIR){
                        return true;
                    }
                }
            }
        }return false;
    }

    /**
     * Gets the rank of the second pair in a two
     * pair.
     * @return the rank
     */
    private int secondPairRank(){
        if (this.fourkindTwoPair()){
            return this.fourkindRank();
        }
        int skipRank = this.pairRank();
        for(int rank: Card.RANKS){
            int counter = NO_PAIR;
            for (Card card: this.PokerHand){
                if (card.getRank().equals(rank) &&card.getRank()!=skipRank){
                    counter++;
                    if (counter == PAIR){
                        return rank;
                    }
                }
            }
        } return 0;
    }

    /**
     * Creates the label of the type of the hand
     * @return string of the type of hand
     */
    private String labelHand(){
        if (this.isFlush())
            return "Flush";

        if (this.twoPair())
            return "Two Pair";

        if (this.isPair())
            return "Pair";

        else{return "High Card";}
    }

    /**
     * Turns the type of hand into the value
     * of the hand
     * @return the value of the hand
     */
    private int handValue(){
        if (this.labelHand().equals("Flush"))
            return FLUSH_VALUE;
        if (this.labelHand().equals("Two Pair"))
            return TWO_PAIR_VALUE;
        if (this.labelHand().equals("Pair"))
            return PAIR_VALUE;
        if (this.labelHand().equals("High Card"))
            return HIGH_CARD_VALUE;
        return UNIDENTIFIED;
    }

    /**
     * A list of card ranks in descending order
     * from the Hand
     * @return the list of sorted ranks
     */
    private ArrayList<Integer> handValuesSorted(){
        ArrayList<Integer> returnArray = new ArrayList<Integer>();
        for (Card card: this.PokerHand){
            returnArray.add(card.getRank());
        }
        Collections.sort(returnArray);
        Collections.reverse((returnArray));
        return returnArray;
    }

    /**
     * Creates a hand ready to compare by
     * sorting card ranks in descending order
     * @return the sorted list of card ranks
     */
    private ArrayList<Integer> comparableHand(){
        ArrayList<Integer> returnList= new ArrayList<Integer>(this.handValuesSorted());
        //System.out.println(returnList);
        if (this.labelHand().equals("Pair")){
            returnList.remove(((Integer) this.pairRank()));
            returnList.remove((Integer) this.pairRank());
            returnList.add(FIRST_INDEX,this.pairRank());
            returnList.add(FIRST_INDEX, this.pairRank());
            return returnList;
        }
        if (this.labelHand().equals("TwoPair")){
            if (this.pairRank()>this.secondPairRank()){
                returnList.remove(this.pairRank());
                returnList.remove(this.pairRank());
                returnList.remove(this.secondPairRank());
                returnList.remove(this.secondPairRank());
                returnList.add(FIRST_INDEX, this.secondPairRank());
                returnList.add(FIRST_INDEX, this.secondPairRank());
                returnList.add(FIRST_INDEX, this.pairRank());
                returnList.add(FIRST_INDEX, this.pairRank());
            }
            if(this.pairRank()<this.secondPairRank()){
                returnList.remove(this.pairRank());
                returnList.remove(this.pairRank());
                returnList.remove(this.secondPairRank());
                returnList.remove(this.secondPairRank());
                returnList.add(FIRST_INDEX, this.pairRank());
                returnList.add(FIRST_INDEX, this.pairRank());
                returnList.add(FIRST_INDEX, this.secondPairRank());
                returnList.add(FIRST_INDEX, this.secondPairRank());

            }
        }
        return returnList;}

    /**
     * Checks to see if the hand type
     * is equal to the other
     * @param other the "other" hand
     * @return true if the hand types are equal, false if not.
     */
    private boolean handTypeEqual(PokerHand other) {return(this.labelHand().equals(other.labelHand())); }


    /** * * *
     Determines how this hand compares to another hand,
     returns positive, negative, or zero depending on the comparison.
     *  @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth * MORE than other
     */

    public int compareTo(PokerHand other) {
        int index = FIRST_INDEX;

        if (!this.handTypeEqual(other)) {
            if (this.handValue() > other.handValue()) {
                return 1;
            }
            if (this.handValue() < other.handValue()) {
                return -1;
            }
        }
        if (this.handTypeEqual(other)) {
            while (index < HANDLENGTH) {
                if (this.comparableHand().get(index) > other.comparableHand().get(index)) {
                    return 1;
                }
                if (this.comparableHand().get(index) < other.comparableHand().get(index)) {
                    return -1;
                }
                index++;
            }

        }return 0;
    }


    /**
     * Pretty prints the hand
     * @return the hand in a string format for
     * readability.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        List<Card> stringHand = PokerHand;
        for (Card convertString : stringHand){
            sb.append(" | ");
            sb.append(convertString);
            sb.append(" | ");
        }
        return sb.toString();
    }
}

