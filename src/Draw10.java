import java.util.*;

public class Draw10 extends Poker
{
    public static void main(String[] args)
    {
        List<Card> deck = createDeck(true);

        while ( deck.size() >= 5 )
        {
            Card[] hand = createHand(deck);
            printHand(hand);

            System.out.println("\n-> " + evaluateHand(hand) );
        }
        printDashedLine();
    }
}
