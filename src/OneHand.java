import java.util.*;

public class OneHand extends Poker
{
    public static void main(String[] args)
    {
        List<Card> defDeck = createDeck(false);
        Scanner scn = new Scanner(System.in);

        for (Card c : defDeck)
            System.out.println(c.name + " -> " + c.id);

        Card[] hand = new Card[5];
        printDashedLine();

        for (int i = 0; i < 5; ++i)
            hand[i] = new Card( getID(scn, (i+1)) );

        System.out.println("\n" + evaluateHand(hand));



    }


    public static int getID(Scanner scn, int count)
    {
        String input;
        int output;

        do {
            System.out.print("Enter card ID "+count+": ");
            input = scn.next();

            try {
                output =Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                output = -1;
            }
        } while (output < 0 || output > 51);

        return output;
    }
}
