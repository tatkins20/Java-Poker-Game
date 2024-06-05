import java.util.ArrayList;
import java.util.List;

public class StudPokerHand {
    private CommunityCardSet communityCards;
    private ArrayList<Card> holeCards;
    public static final int HANDSIZE = 5;
    public static final int STUDHANDSIZE = 2;
    public static final int FIRST_INDEX = 0;
    public static final int FIRST_HOLECARD = 0;
    public static final int SECOND_HOLECARD = 0;

    /**
     * Constructs a StudPokerHand with the community cards
     *
     * @param communityCards the cards used to create the stud poker hand.
     * @param cardList       the list of cards for hole cards.
     */
    public StudPokerHand(CommunityCardSet communityCards, ArrayList<Card> cardList) {
        this.holeCards = cardList;
        this.communityCards = communityCards;
    }

    /**
     * Constructs a StudPokerHand with the community cards
     *
     * @param communityCards the cards used to create the stud poker hand.
     */
    public StudPokerHand(CommunityCardSet communityCards) {
        this.holeCards = new ArrayList<Card>();
        this.communityCards = communityCards;
    }

    /**
     * Takes in a card and adds it to the hole card list.
     * @param card takes in a card
     */
    public void addCard(Card card) {
        this.holeCards.add(card);
    }

    /**
     * Removes the card from the hand at specified index.
     *
     * @param ithcard the index of the card
     */
    public void removeCard(int ithcard) {
        if (ithcard < FIRST_INDEX) {
            return;
        } else {
            this.holeCards.remove(ithcard);
        }
    }

    /**
     * Removes the first card in the hand.
     */
    public void removeFirstCard() {
        this.removeCard(FIRST_INDEX);
    }

    /**
     *
     * @return True if the hole cards are full, false if it is not.
     */
    public boolean full(){
        return this.holeCards.size()==STUDHANDSIZE;
    }

    /**
     * Gets every single combination of PokerHands
     * @return the collection of combinations in a list.
     */
    private ArrayList<PokerHand> getAll5CardHands() {
        ArrayList<PokerHand> returnHand = new ArrayList<PokerHand>();
        ArrayList<Card> allCards = this.communityCards.getCardSet();
        allCards.add(this.holeCards.get(FIRST_HOLECARD));
        allCards.add(this.holeCards.get(SECOND_HOLECARD));
        ArrayList<ArrayList<Card>> allHands = IdentifyCombo.getCombos(allCards, HANDSIZE);

        for (ArrayList<Card> hands : allHands) {
            PokerHand newHand = new PokerHand(new ArrayList<Card>());
            for (Card card : hands) {
                newHand.addCard(card);
            }
            returnHand.add(newHand);
        }
        return returnHand;

    }

    /**
     * Finds the best possible combination of five card hand with
     * the Stud Poker Hand and Community Cards.
     * @return the best five card hand
     */
    private PokerHand getBest5CardHand(){
        ArrayList<PokerHand>hands=this.getAll5CardHands();
        PokerHand bestSoFar= hands.get(0);
        for(int i=1; i<hands.size(); i++ ){
            if( hands.get(i).compareTo(bestSoFar)>0){
                bestSoFar= hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * Pretty prints the hole cards.
     * @return String of the cards.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        List<Card> stringHand = this.holeCards;
        for (Card convertString : stringHand){
            sb.append(" | ");
            sb.append(convertString);
            sb.append(" | ");
        }
        return sb.toString();
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison. *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth * MORE than other
     */
    public int compareTo(StudPokerHand other){
        return this.getBest5CardHand().compareTo(other.getBest5CardHand());
    }

}


