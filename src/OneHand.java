import java.util.*;

public class OneHand extends Poker
{
    public static void main(String[] args)
    {
        List<Card> defDeck = createDeck(false);
        Scanner scn = new Scanner(System.in);

        for (Card c : defDeck)
            System.out.println(c.name + " -> " + c.id);

        printDashedLine();

        // create a new hand with desired values
        Card[] hand = createExactHand(scn);

        if (hand != null)
        {
            printHand(hand);
            System.out.println("\n" + evaluateHand(hand));
        }
        else
            System.out.println("\nERROR");

    }

    public static Card[] createExactHand(Scanner scn)
    {
        Card[] output = new Card[5];
        int current = 0;

        System.out.print("Enter input: (00_00_00_00_00_): ");
        String input = scn.next();

        for (int i = 0 ; i < input.length(); ++i)
        {
            if (input.charAt(i) == '_')
            {
                String numStr = input.charAt(i-2) + "" + input.charAt(i-1);
                int num;

                try {
                    num = Integer.parseInt(numStr);
                }
                catch (NumberFormatException e) {
                    return null;
                }

                if (num < 0 || num > 52)
                    return null;

                output[current] = new Card(num);
                ++current;
            }
        }

        if (current == 5)
            return output;
        else
            return null;
    }

}
