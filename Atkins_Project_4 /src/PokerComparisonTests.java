import java.util.ArrayList;

public class PokerComparisonTests {
    public static void main(String[] args) {

        final int MIN_SCORE = 0;
//            Testing.startTests();
//            Testing.setVerbose(true);
//            CommunityCardSet communityCards = new CommunityCardSet();
//            Card card1 = new Card(2, "Diamonds");
//            Card card2 = new Card(3, "Diamonds");
//            Card card3 = new Card(4,"Diamonds");
//            Card card4 = new Card(5, "Diamonds");
//            Card card5 = new Card(6, "Diamonds");
//            communityCards.addCard(card1);
//            communityCards.addCard(card2);
//            communityCards.addCard(card3);
//            communityCards.addCard(card4);
//            communityCards.addCard(card5);
//            StudPokerHand hand1 = new StudPokerHand(communityCards);
//            StudPokerHand hand2 = new StudPokerHand(communityCards);
//            Card h1card1 = new Card(8, "Spades");
//            Card h1card2 = new Card(7, "Hearts");
//            Card h2card1 = new Card(9, "Hearts");
//            Card h2card2 = new Card(9, "Clubs");
//            hand1.addCard(h1card1);
//            hand1.addCard(h1card2);
//            hand2.addCard(h2card1);
//            hand2.addCard(h2card2);
//            System.out.printf("\n" + "%d" + "\n" , hand1.compareTo(hand2));
//            Testing.assertEquals("Testing compare to with consecutive ranks and " +
//            "identical suits.", -1, hand1.compareTo(hand2));
//            Testing.finishTests();
        Testing.startTests();
        Testing.setVerbose(true);
        Card card1 = new Card(2, "Diamonds");
        Card card2 = new Card(3, "Diamonds");
        Card card3 = new Card(4,"Diamonds");
        Card card4 = new Card(6, "Diamonds");
        Card card5 = new Card(6, "Hearts");
        Card card6 = new Card(5, "Hearts");
        Card card7 = new Card(5, "Diamonds");
        Card card8 = new Card(8,"Hearts");
        Card card9 = new Card(9, "Hearts");
        Card card10 = new Card(10, "Hearts");
        PokerHand PokerHand1 = new PokerHand(new ArrayList<Card>());
        PokerHand PokerHand2 = new PokerHand(new ArrayList<Card>());
        PokerHand1.addCard(card1);
        PokerHand1.addCard(card2);
        PokerHand1.addCard(card3);
        PokerHand1.addCard(card4);
        PokerHand1.addCard(card5);
        PokerHand2.addCard(card6);
        PokerHand2.addCard(card7);
        PokerHand2.addCard(card8);
        PokerHand2.addCard(card9);
        PokerHand2.addCard(card10);
        Testing.assertEquals("Testing compare to with hand 1 having a higher rank pair and " +
                "identical suits.", 1, PokerHand1.compareTo(PokerHand2));
        Testing.finishTests();

        Testing.startTests();
        Testing.setVerbose(true);
        Card card_1 = new Card(3, "Diamonds");
        Card card_2 = new Card(4, "Diamonds");
        Card card_3 = new Card(6,"Diamonds");
        Card card_4 = new Card(7, "Diamonds");
        Card card_5 = new Card(8, "Diamonds");
        Card card_6 = new Card(3, "Hearts");
        Card card_7 = new Card(4, "Hearts");
        Card card_8 = new Card(5,"Hearts");
        Card card_9 = new Card(7, "Hearts");
        Card card_10 = new Card(8, "Hearts");
        PokerHand PokerHand01 = new PokerHand(new ArrayList<Card>());
        PokerHand PokerHand02 = new PokerHand(new ArrayList<Card>());
        PokerHand1.addCard(card_1);
        PokerHand1.addCard(card_2);
        PokerHand1.addCard(card_3);
        PokerHand1.addCard(card_4);
        PokerHand1.addCard(card_5);
        PokerHand2.addCard(card_6);
        PokerHand2.addCard(card_7);
        PokerHand2.addCard(card_8);
        PokerHand2.addCard(card_9);
        PokerHand2.addCard(card_10);
        Testing.assertEquals("Testing compare to with flush " +
                "and a different rank for the third highest card.", 1, PokerHand1.compareTo(PokerHand2));
        Testing.finishTests();

        Testing.startTests();
        Testing.setVerbose(true);
        Card card_01 = new Card(3, "Spades");
        Card card_02 = new Card(3, "Clubs");
        Card card_03 = new Card(6,"Diamonds");
        Card card_04 = new Card(7, "Diamonds");
        Card card_05 = new Card(8, "Diamonds");
        Card card_06 = new Card(3, "Hearts");
        Card card_07 = new Card(13, "Diamonds");
        Card card_08 = new Card(13,"Hearts");
        Card card_09 = new Card(14, "Clubs");
        Card card_010 = new Card(14, "Hearts");
        PokerHand PokerHand001 = new PokerHand(new ArrayList<Card>());
        PokerHand PokerHand002 = new PokerHand(new ArrayList<Card>());
        PokerHand1.addCard(card_01);
        PokerHand1.addCard(card_02);
        PokerHand1.addCard(card_03);
        PokerHand1.addCard(card_04);
        PokerHand1.addCard(card_05);
        PokerHand2.addCard(card_06);
        PokerHand2.addCard(card_07);
        PokerHand2.addCard(card_08);
        PokerHand2.addCard(card_09);
        PokerHand2.addCard(card_010);
        Testing.assertEquals("Testing compare to with two pair " +
                "and a pair for the third highest card.", -1, PokerHand1.compareTo(PokerHand2));
        Testing.finishTests();

            }
        }


