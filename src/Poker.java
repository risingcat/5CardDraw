import java.util.*;

public class Poker
{

    public static String evaluateHand(Card[] originalHand)
    {
        Card[] hand = originalHand.clone();

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (Card c : hand)
            map.put( c.rank, map.getOrDefault( c.rank, 0 ) +1 );

        bubbleSort(hand);

        if ( isBroadway(hand) && isFlush(hand) )
        {
            return "Royal Flush";
        }
        else if ( isStraight(hand) && isFlush(hand) )
        {
            return "Straight Flush";
        }
        else if ( map.containsValue(4) )
        {
            return "Four of a Kind";
        }
        else if ( map.containsValue(3) && map.containsValue(2) )
        {
            return "Full House";
        }
        else if ( isFlush(hand) )
        {
            return "Flush";
        }
        else if ( isStraight(hand) || isBroadway(hand) )
        {
            return "Straight";
        }
        else if ( map.containsValue(3) )
        {
            return "Three of a Kind";
        }
        else if ( map.containsValue(2) && map.size() == 3 )
        {
            return "Two Pair";
        }
        else if ( map.containsValue(2) && map.size() == 4 )
        {
            return "Pair";
        }
        else if ( map.containsValue(1) && map.size() == 5 )
        {
            return "High Card";
        }
        else
            return "ERROR";
    }

    public static boolean isBroadway(Card[] hand)
    {
        return  hand[0].rank == 1    &&
                hand[1].rank == 10   &&
                hand[2].rank == 11   &&
                hand[3].rank == 12   &&
                hand[4].rank == 13   ;
    }

    public static boolean isFlush(Card[] hand)
    {
        for ( int i = 0 ; i < hand.length-1 ; ++i )
        {
            if ( hand[i].suit != hand[i+1].suit)
                return false;
        }
        return true;
    }

    public static boolean isStraight(Card[] hand)
    {
        for ( int i = 0 ; i < hand.length-1 ; ++i )
        {
            if ( hand[i].rank + 1 != hand[i+1].rank)
                return false;
        }
        return true;
    }

    public static void bubbleSort(Card[] hand)
    {
        for ( int i = 0 ; i < hand.length-1 ; ++i )
        {
            for ( int n = 0 ; n < hand.length-1-i ; ++n )
            {
                if ( hand[n].rank > hand[n+1].rank)
                {
                    Card temp = hand[n];
                    hand[n] = hand[n+1];
                    hand[n+1] = temp;
                }
            }
        }
    }

    public static void printHand(Card[] hand)
    {
        printDashedLine();
        for (Card c : hand)
            System.out.println(c.name);
    }

    public static Card[] createHand(List<Card> deck)
    {
        Card[] hand = new Card[5];

        for ( int i = 0 ; i < 5 ; ++i )
        {
            hand[i] = deck.getFirst();
            deck.removeFirst();
        }

        return hand;
    }

    public static List<Card> createDeck(boolean isShuffled)
    {
        List<Card> deck = new ArrayList<>();

        for ( int i = 0 ; i < 52 ; ++i )
            deck.add( new Card(i) );

        if (isShuffled)
            Collections.shuffle(deck);

        return deck;
    }

    public static void printDashedLine()
    {
        final int size = 40;

        for ( int i = 0 ; i < size ; ++i )
        {
            System.out.print("-");
        }
        System.out.println();
    }









}
