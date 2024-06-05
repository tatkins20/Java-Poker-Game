import java.util.ArrayList;
public class CommunityCardSet {
    private ArrayList <Card> CommunityCardSet;
    public static int FIRST_INDEX = 0;

    /**
     * Constructor for the Community Card Set
     */
    public CommunityCardSet(){
        this.CommunityCardSet = new ArrayList<Card>();
    }

    public CommunityCardSet(ArrayList<Card> cardList) {
        this.CommunityCardSet = cardList;
    }

    /**
     * Takes in a card and adds it to the Community Card Set
     * @param card takes in a card
     */
    public void addCard(Card card) {this.CommunityCardSet.add(card);}

    /**
     * Removes the first index or card of the Community Card Set
     */
    public void removeFirstCard() {this.CommunityCardSet.remove(FIRST_INDEX);}

    /**
     *Checks whether the Set is full
     * @return whether true if full, false if it is not.
     */
    public boolean isfull(){
        return this.CommunityCardSet.size()==5;
    }

    /**
     * Pretty prints the Card set as a string for readability.
     * @return the Set as a string.
     */
    public String toString() {return this.CommunityCardSet.toString(); }

    /**
     * Gets the Community Card Set in a list
     * @return the list of cards in the community set.
     */
    public ArrayList<Card> getCardSet(){
        CommunityCardSet commCopy = new CommunityCardSet();
        for(Card card: this.CommunityCardSet){
            commCopy.addCard(card);
        }
        return commCopy.CommunityCardSet;
    }
}
