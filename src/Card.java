public class Card
{
    String name;
    int rank, suit, id;

    public Card(int num)
    {
        rank = num % 13 + 1;
        suit = num / 13;
        id = num;

        name = getName();
    }


    private String getName()
    {
        String rankName = switch (rank)
        {
            case 1  -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> Integer.toString(rank);
        };

        String suitName = switch (suit)
        {
            case 0 ->   "Clubs";
            case 1 ->   "Diamonds";
            case 2 ->   "Hearts";
            case 3 ->   "Spades";
            default ->  "Error";
        };

        return rankName + " of " + suitName;

    }

}
