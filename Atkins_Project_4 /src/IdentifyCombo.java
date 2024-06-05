import java.util.ArrayList;
// Had help from a friend for the logic of identifying the combinations
// creates all the combinations of cards given 5 card Poker Hands
public class IdentifyCombo {
    private static final int FIRST_INDEX = 0;
    /**
     *
     * @param inputlist a list of cards
     * @return that list of cards within a list
     */
    public static ArrayList<ArrayList<Card>> listWithListInside (ArrayList<Card> inputlist){
        ArrayList<ArrayList<Card>>returnlist= new ArrayList<ArrayList<Card>>();
        returnlist.add(inputlist);
        return returnlist;

    }
    /**
     * Creates and returns a new list of lists, where each new list is a list
     for the given list with a given prefix added.
     * @param prefix: A single element to prepend onto each list.
     * @param listOfListsToPrepend: The list of the lists to prepend.
     * @return: A list of new lists, containing the contents of each of the
    lists from list_of_lists_to_prepend with the prefix prepended.
     */
    private static ArrayList<ArrayList<Card>> prependToAllLists(Card prefix, ArrayList<ArrayList<Card>> listOfListsToPrepend){
        for (ArrayList<Card> hand: listOfListsToPrepend){
            hand.add(FIRST_INDEX,prefix);
        }
        return listOfListsToPrepend;

    }
    /**
     * Gets all combinations of a given length chosen from a given list, returns a list of those combinations.
     * @param chooseFrom: A list of cards to choose from
     * @param targetLength: The target length of the combinations to find
     * @return: A list of lists, where each list is a combination of Card object from choose_from of length target_len.
    Returns the empty list if choose_from is empty.
     */
    public static ArrayList<ArrayList<Card>> getCombos(ArrayList<Card> chooseFrom, int targetLength){
        if (chooseFrom.size()== targetLength){
            return listWithListInside(chooseFrom);
        }
        else if(chooseFrom.size()==0){
            return new ArrayList<ArrayList<Card>>();
        }
        Card prefix= chooseFrom.get(0);
        ArrayList<Card> rest= new ArrayList<Card>();
        for (Card card: chooseFrom.subList(1,chooseFrom.size()-1)){
            rest.add(card);
        }
        ArrayList<ArrayList<Card>>returnlist= new ArrayList<ArrayList<Card>>(prependToAllLists(prefix, getCombos(rest,targetLength-1)));
        returnlist.addAll(getCombos(rest,targetLength));
        return returnlist;


    }
}
