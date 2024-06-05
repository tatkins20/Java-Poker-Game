import java.util.Scanner;
//I affirm that I have carried out the attached academic endeavors with full academic honesty, in
//accordance with the Union College Honor Code and the course syllabus.
// author: Trevor Atkins;

public class Client {
    static final int MIN_SCORE = 0;
    public static void main(String[] args) {
        Card someCard;
        someCard = new Card(11, "Hearts");
        System.out.println(someCard);
        Deck someDeck;
        someDeck = new Deck();
        System.out.println(someDeck);
        someDeck.shuffle();
        System.out.println(someDeck);
        Card card1 = someDeck.dealCard();
        System.out.println(card1);
        Card card2 = someDeck.dealCard();
        System.out.println(card2);
        someDeck.shuffle();
        System.out.println(someDeck);
            int score= MIN_SCORE;
            Deck deck= new Deck();
            deck.shuffle();
            CommunityCardSet communityCards= new CommunityCardSet();
            while (!communityCards.isfull()){
                communityCards.addCard(deck.dealCard());
            }
            while (!deck.isEmpty()){
                StudPokerHand hand1= new StudPokerHand(communityCards);
                StudPokerHand hand2= new StudPokerHand(communityCards);
                while(!hand1.full() && !hand2.full() ){
                    hand1.addCard(deck.dealCard());
                    hand2.addCard(deck.dealCard());
                }
                System.out.println("hand 1 is:"+hand1);
                System.out.println("hand 2 is:"+hand2);
                System.out.println("and the community cards are:"+ communityCards);
                System.out.println("Which is worth more? Or are the they same value? 1 if hand 1, -1 if hand 2, or 0 if tie!");
                Scanner scanner= new Scanner(System.in);
                int userinput = scanner.nextInt();
                if (userinput == hand1.compareTo(hand2)){
                    score++;
                    System.out.println("You're right, keep going!");
                }
                if (userinput!=hand1.compareTo(hand2)){
                    System.out.println("Better luck next time! your score is "+ score);
                    break;
                }
                if (deck.isEmpty()){
                    System.out.println("Congrats! You win! Score: "+ score);
                }
            }
        }


    }


