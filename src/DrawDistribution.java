import java.util.*;

public class DrawDistribution extends Poker
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> fMap = new HashMap<>();

        int iterations = getIterations(scan);

        for ( int i = 0 ; i < iterations/10 ; ++i )
        {
            List<Card> deck = createDeck(true);

            while (deck.size() >= 5)
            {
                Card[] hand = createHand(deck);

                String handType = evaluateHand(hand);
                fMap.put( handType , fMap.getOrDefault( handType , 0 ) + 1 );
            }
        }

        printDashedLine();
        for ( String s : fMap.keySet() )
            System.out.println( s + " -> " + fMap.get(s) );
    }

    public static int getIterations(Scanner scan)
    {
        int iterations;
        String input;
        do {
            System.out.print("How many hands? [Multiple of 10]: ");
            input = scan.next();

            try {
                iterations = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                iterations = -1;
            }


        } while (iterations < 0 || iterations%10 != 0 );
        return iterations;
    }

}
