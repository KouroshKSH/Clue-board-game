import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class DeckOfCardsTotal
{
    SecureRandom random = new SecureRandom();

    private final int cardsTotalNum = 21;
    private final int charactersTotalNum = 6;
    private final int toolsTotalNum = 6;
    private final int roomsTotalNum = 9;

    public String[] cardsInfoOrigin = {"Dr.Orchid", "Mr.Green", "Col.Mustard", "Ms.Peacock", "Prof.Plum", "Mr.Scarlet",
            "wrench", "rope", "steel bar", "knife", "shovel", "razor",
            "piano room", "greenhouse", "billiard's room", "library", "study room", "hall", "bedroom", "dinning", "kitchen"};

    public String[] charactersArrayOfNames = {"Dr.Orchid", "Mr.Green", "Col.Mustard",
            "Ms.Peacock", "Prof.Plum", "Mr.Scarlet"};

    public String[] toolsArrayOfNames = {"wrench", "rope", "steel bar",
            "knife", "shovel", "razor"};

    public String[] roomsArrayOfNames = {"piano room", "greenhouse", "billiard's room",
            "library", "study room", "hall",
            "bedroom", "dinning", "kitchen"};

    private Cards[] allOfCardsList = new Cards[cardsTotalNum - 3];
    private Cards[] charactersNameList = new Cards[charactersTotalNum];
    private Cards[] toolsNameList = new Cards[toolsTotalNum];
    private Cards[] roomsNameList = new Cards[roomsTotalNum];

    private int currentCard = 0;

    private String murdererChar = randSelectMurderer();
    private String murderTool = randSelectMurderTool();
    private String murderRoom = randSelectMurderRoom();

    public String[] stringBased18Cards = new String[18];

    public void shuffleArraySize18()
    {
        //using array list to benefit from the dynamic size of it and later removing some items
        ArrayList<String> DynamicCardsInfo = new ArrayList<String>(21);
        for (int count = 0; count < 21; count++)
        {
            DynamicCardsInfo.add(count, cardsInfoOrigin[count]);
        }
        //now we remove the murder elements from the array list
        DynamicCardsInfo.remove(murdererChar);
        DynamicCardsInfo.remove(murderTool);
        DynamicCardsInfo.remove(murderRoom);
        //now that the murder settings are removed, we store the elements in a new array with the lesser size
        String[] cardsInfoNew = new String[18];
        for (int count = 0; count < DynamicCardsInfo.size(); count++)
        {
            cardsInfoNew[count] = DynamicCardsInfo.get(count);
        }
        //now the 'cardsInfoNew is our 18 sized array to work with

        //after creating the new array, we should shuffle it
        for (int count = cardsInfoNew.length - 1; count > 0; count--)
        {
            int var = random.nextInt(count + 1);
            String temp = cardsInfoNew[count];
            cardsInfoNew[count] = cardsInfoNew[var];
            cardsInfoNew[var] = temp;
        }

        for (int counter = 0; counter < cardsInfoNew.length; counter++)
        {
            allOfCardsList[counter] = new Cards(cardsInfoNew[counter%18]);
        }

        for (int count = 0; count < stringBased18Cards.length; count++)
        {
            stringBased18Cards[count] = String.valueOf(allOfCardsList[count]);
        }
    }

    public void setMurdererChar(String murdererChar)
    {
        this.murdererChar = randSelectMurderer();
    }

    public void setMurderTool(String murderTool)
    {
        this.murderTool = randSelectMurderTool();
    }

    public void setMurderRoom(String murderRoom)
    {
        this.murderRoom = randSelectMurderRoom();
    }

    public String getMurdererChar()
    {
        return murdererChar;
    }

    public String getMurderTool()
    {
        return murderTool;
    }

    public String getMurderRoom()
    {
        return murderRoom;
    }

    public String getStringBased18Cards()
    {
        String empty = " ";
        if (currentCard < stringBased18Cards.length)
        {
            return stringBased18Cards[currentCard++];
        }else{
            return empty;
        }
    }

    public void shuffleCharCards()
    {
        String[] charactersArrayOfNames = {"Dr.Orchid", "Mr.Green", "Col.Mustard",
                "Ms.Peacock", "Prof.Plum", "Mr.Scarlet"};

        for (int count = charactersArrayOfNames.length - 1; count > 0; count--)
        {
            int var = random.nextInt(count + 1);
            String temp = charactersArrayOfNames[count];
            charactersArrayOfNames[count] = charactersArrayOfNames[var];
            charactersArrayOfNames[var] = temp;
        }
    }

    public void shuffleToolCards()
    {
        String[] toolsArrayOfNames = {"wrench", "rope", "steel bar",
                "knife", "shovel", "razor"};

        for (int count = toolsArrayOfNames.length - 1; count > 0; count--)
        {
            int var = random.nextInt(count + 1);
            String temp = toolsArrayOfNames[count];
            toolsArrayOfNames[count] = toolsArrayOfNames[var];
            toolsArrayOfNames[var] = temp;
        }
    }

    public void shuffleRoomCards()
    {
        String[] roomsArrayOfNames = {"piano room", "greenhouse", "billiard's room",
                "library", "study room", "hall",
                "bedroom", "dinning", "kitchen"};

        for (int count = roomsArrayOfNames.length - 1; count > 0; count--)
        {
            int var = random.nextInt(count + 1);
            String temp = roomsArrayOfNames[count];
            roomsArrayOfNames[count] = roomsArrayOfNames[var];
            roomsArrayOfNames[var] = temp;
        }
    }

    //function for randomly selecting the murderer
    public String randSelectMurderer()
    {
        String[] charactersArrayOfNames = {"Dr.Orchid", "Mr.Green", "Col.Mustard",
                "Ms.Peacock", "Prof.Plum", "Mr.Scarlet"};
        int randNum = random.nextInt(charactersArrayOfNames.length);
        return charactersArrayOfNames[randNum];
    }

    public String randSelectMurderTool()
    {
        String[] toolsArrayOfNames = {"wrench", "rope", "steel bar",
                "knife", "shovel", "razor"};
        int randNum = random.nextInt(toolsArrayOfNames.length);
        return toolsArrayOfNames[randNum];
    }

    public String randSelectMurderRoom()
    {
        String[] roomsArrayOfNames = {"piano room", "greenhouse", "billiard's room",
                "library", "study room", "hall",
                "bedroom", "dinning", "kitchen"};
        int randNum = random.nextInt(roomsArrayOfNames.length);
        return roomsArrayOfNames[randNum];
    }

    //randomizing the elements of each part of the murder
    public String randomMurderSettingSelect(String[] givenDeckOfCards)
    {
        int randomNum = random.nextInt(givenDeckOfCards.length);
        return givenDeckOfCards[randomNum];
    }

    public Cards dealingCards()
    {
        Cards empty = new Cards(" ");

        if (currentCard < allOfCardsList.length)
        {
            return allOfCardsList[currentCard++];
        }else{
            return empty;
        }
    }
}
