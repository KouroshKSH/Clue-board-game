public class Cards
{
    //since all the cards have only one attribute, then there'll only be one string
    private final String infoOnCard;

    public Cards(String infoOnCard)
    {
        this.infoOnCard = infoOnCard;
    }

    @Override
    public String toString()
    {
        return infoOnCard;
    }
}











