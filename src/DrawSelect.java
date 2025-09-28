import java.util.*;

public class DrawSelect extends Poker
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean satisfied = false;
        int handsCalculated = 0;
        Card[] finalHand = new Card[5];
        String neededHand = getDesiredHand(scan);

        while ( !satisfied )
        {
            List<Card> deck = createDeck(true);
            while (deck.size() >= 5 && !satisfied)
            {
                Card[] hand = createHand(deck);
                String handType = evaluateHand(hand);
                ++handsCalculated;

                if ( handType.equals(neededHand) )
                {
                    satisfied = true;
                    finalHand = hand;
                }
            }
        }

        printHand(finalHand);
        System.out.println("\nHands calculated -> " + handsCalculated);
    }

    public static String getDesiredHand(Scanner scan)
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(9, "Royal Flush");
        map.put(8, "Straight Flush");
        map.put(7, "Four of a Kind");
        map.put(6, "Full House");
        map.put(5, "Flush");
        map.put(4, "Straight");
        map.put(3, "Three of a Kind");
        map.put(2, "Two Pair");
        map.put(1, "Pair");
        map.put(0, "High Card");

        printDashedLine();
        for (int k : map.keySet())
            System.out.println(k + " -> " + map.get(k));

        System.out.println();

        int num;
        String input;
        do {
            System.out.print("Enter hand to calculate for: ");
            input = scan.next();

            try {
                num = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                num = -1;
            }

        } while ( num < 0 || num > 9 );

        return map.get( num );
    }
}