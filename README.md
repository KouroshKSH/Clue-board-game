# Clue Board Game
Cluedo, known as Clue in North America, is a murder mystery game that was devised in 1943 by Anthony E. Pratt.

The object of the game is to determine who murdered the game's victim, where the crime took place, and which weapon was used. Each player assumes the role of one of the suspects and attempts to deduce the correct answer by strategically moving around a game board representing the rooms of a mansion and collecting clues about the circumstances of the murder from the other players. In this version of the game, Mr. Black has been murdered by one of the tools in the game in an unknown room.

In this version of the game, Mr. Black has been murdered by one of the tools in the game in an unknown room.

---

## Settings of the Game
The game can be consisted from 3 up to 6 players per match. There are also two dice and 21 cards. The characters are:
1. Dr. Orchid
2. Mr. Green
3. Col. Mustard
4. Ms. Peacock
5. Prof. Plum
6. Mr. Scarlet

The tools provided are:
1. Wrench
2. Rope 
3. Steel Bar 
4. Knife 
5. Shovel 
6. Razor

The rooms are located as shown in the image (not mine):

<p align="center">
  <img src="https://user-images.githubusercontent.com/65996638/230199906-ee0eb590-3a09-4a14-a89b-6ae5da4b10b8.png">
</p>

> [source](https://www.researchgate.net/figure/Diagram-of-the-Clue-game-board-these-three-cards-indicate-the-person-who-committed-the_fig5_225123158)

Or as a list:
1. Hall 
2. Piano room 
3. Greenhouse 
4. Study 
5. Billiard 
6. Bedroom
7. Dining 
8. Library 
9. Kitchen

---

## Gameplay
First, each three deck of cards should be shuffled and then a single card out of each deck will be put aside in a sealed envelope. Then the rest of the cards should be shuffled together and then dealt to the players. Due to the difference in the number of the players, based on this table, each player can receive varied different number of cards:

| Number of Players | Number of Cards |
| ----------------- | --------------- |
| 3                 | 6               |
| 4                 | 5               |
| 5                 | 4               |
| 6                 | 3               | 

The players will be placed randomly and the round starts from the first character. The first player tosses their dice and based on the sum of their numbers, can enter one of the other rooms. For the selection of the rooms, they must consider these:
1. If the sum is odd, the player can enter an odd number room and vise versa
2. Players must change their rooms and can not stay in one room
3. Players are not allowed to go to the neighbor rooms. For instance, if they are currently in room no.6, rooms 5 and 7 won’t be available. (Room no.1 is not considered a neighbor)

With the player’s entry in of the rooms, he/she must guess and choose a character and a tool from the range of the cards. The current player now can start asking from others whether his/her guess is valid or not. This process will be continued till someone confirms that they have one of the cards mentioned earlier. The rest of the players will not be informed about the identity of that card, but only notified about the availability of it.

If at the end of the round, our player concludes that a final answer can be announced, they can declare the murderer, the tool and the room they suspect, else they can pass on. If their answer is correct, they shall win the game, but if not, they will be removed from the game and can only answer the other’s questions.

> ### Note
> As soon as one of the accuser’s cards is told to be possessed, the asking procedure will be stopped and the game will move on to it’s next phase.

### Current Build
At this point, there isn’t a multi-player version of the game. No other human players will join and the user is only going to play against non-playable characters. As a matter of fact, the user is only allowed to win and not the computer. Yet, he/she can lose if they finalize their wrong accusation.

After writing the whole project, these are the end results regarding the structure of the program:
1. An estimated number of 5’300 lines of code 
2. There are 3 classes in total:
    - MainClass
    - Cards
    - DeckOfCardsTotal
3. About 20 note worthy functions
4. Imported 6 packages in total

The code is mainly consisted of the `MainClass` and the object aspect of the initial approach is fairly used in the first segment of the project. In the beginning, the `Cards` class is written to construct a simple structure of any given card.
```java
public class Cards
{
  private final String infoOnCard;
  public Cards(String infoOnCard)
  {
    this.infoOnCard = infoOncard;
  }
  
  @Override
  public String toString()
  {
    return infoOnCard
  }
}
```

After that, the `DeckOfCardsTotal` class is made upon the previous mentioned class. The entities in this class are based on the `Cards` class. A large amount of the identities are written here, as they shall be the reference point of the code.
```java
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
}
```

At first, we have a set of 21 cards which can be divided into 3 parts (characters, tools & rooms), and then the functions listed below randomly choose the murder’s settings:
1. `randSelectMurderer`
2. `randSelectMurderTool` 
3. `randSelectMurderRoom`

These functions store string based variables in their respected directories.
```java
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
```

After the selection of those 3 random cards for the murder, an `ArrayList` is made in order to store the remaining cards and later removing those 3 initial cards.
```java
ArrayList<String> DynamicCardsInfo = new ArrayList<String>(21);
for (int count = 0; count < 21; count++)
{
    DynamicCardsInfo.add(count, cardsInfoOrigin[count]);
}
//now we remove the murder elements from the array list
DynamicCardsInfo.remove(murdererChar);
DynamicCardsInfo.remove(murderTool);
DynamicCardsInfo.remove(murderRoom);
```

Now we store the elements of `DynamicCardsInfo` in a new 18 sized array.
```java
String[] cardsInfoNew = new String[18];
for (int count = 0; count < DynamicCardsInfo.size(); count++)
{
    cardsInfoNew[count] = DynamicCardsInfo.get(count);
}
```

Then, the `cardsInfoNew` array will be shuffled with [Fisher Yates's algorithm](https://bost.ocks.org/mike/shuffle/), which is an algorithm for randomly shuffling a finite sequence of elements. The algorithm works by iterating through the sequence from the end to the beginning, swapping each element with a randomly chosen element that comes before it in the sequence.
```java
for (int count = cardsInfoNew.length - 1; count > 0; count--)
{
    int var = random.nextInt(count + 1);
    String temp = cardsInfoNew[count];
    cardsInfoNew[count] = cardsInfoNew[var];
    cardsInfoNew[var] = temp;
}
```

> #### Fisher Yate's Algorithm
> The algorithm has two steps:
> 1. Starting from the last element of the sequence, swap it with a randomly chosen element from the sequence that comes before it (including itself).
> 2. Move to the next-to-last element of the sequence and repeat step 1, swapping the element with a randomly chosen element from the sequence that comes before it (including itself). Continue this process, moving backwards through the sequence until the first element is reached.

Later, the cards get stored in ‘stringBased18Cards’ string array to be dealt with.
```java
for (int counter = 0; counter < cardsInfoNew.length; counter++)
{
    allOfCardsList[counter] = new Cards(cardsInfoNew[counter%18]);
}

for (int count = 0; count < stringBased18Cards.length; count++)
{
    stringBased18Cards[count] = String.valueOf(allOfCardsList[count]);
}
```

After all of these, the rest of the program will take place in our main class and about 90% of the whole project will be resumed there.
```java
public class MainClass
{
    private static final int cardsTotalNum = 21;
    static final SecureRandom random = new SecureRandom();
    public static int dice1, dice2, resultOfDice;
    public static String[] charactersArrayOfNames = {"Dr.Orchid", "Mr.Green", "Col.Mustard",
            "Ms.Peacock", "Prof.Plum", "Mr.Scarlet"};
    public static String[] toolsArrayOfNames = {"wrench", "rope", "steel bar",
            "knife", "shovel", "razor"};
    public static String[] roomsArrayOfNames = {"piano room", "greenhouse", "billiard's room",
            "library", "study room", "hall",
            "bedroom", "dinning", "kitchen"};
    public static HashMap<Integer, String> roomsStringAndIntMap = new HashMap<Integer, String>(9);
}
```

Minus the main required variables, there is `roomsStringAndIntMap` HashMap that is responsible for the task of assigning integer values to string based names of the rooms, and ease the process of working with the names of those rooms later.
```java
roomsStringAndIntMap.put(1, "hall");
roomsStringAndIntMap.put(2, "pinanoroom");
roomsStringAndIntMap.put(3, "greenhouse");
roomsStringAndIntMap.put(4, "studyroom");
roomsStringAndIntMap.put(5, "billiard'sroom");
roomsStringAndIntMap.put(6, "bedroom");
roomsStringAndIntMap.put(7, "dinning");
roomsStringAndIntMap.put(8, "library");
roomsStringAndIntMap.put(9, "kitchen");
```

Now, the first stage of the game begins, which is entering the number of the participants and starting the game. Unfortunately, the game can recognize the user only as `player1` due to some issues that occurred later in the code, such as jumping over user’s turn or not verifying the user as a human being and letting he win the game and etc.

Then, a deck of cards will be made from `DeckOfCardsTotal` class and it is responsible for holding the answers to the game. The `myDeck` list will then be shuffled and randomized.
```java
//for the initial shuffling of the cards
myDeck.shuffleCharCards();
myDeck.shuffleToolCards();
myDeck.shuffleRoomCards();
```

From there, the settings of the murder will be stored in the first three indexes of the `correctAnswer` array.
```java
//created this String array for holding the case of murder
String[] correctAnswer = new String[3];
correctAnswer[0] = myDeck.getMurdererChar();
correctAnswer[1] = myDeck.getMurderTool();
correctAnswer[2] = myDeck.getMurderRoom();
```

The remaining cards will now be shuffled once more to continue with the 18 set of cards for the dealing part of the game.
```java
myDeck.shuffleArraySize18();
//this 18 sized String array will store the 18 cards and will be used later
String[] stringArrayOfCards = new String[18];
for (int i  = 0; i < stringArrayOfCards.length; i++)
{
    stringArrayOfCards[i] = myDeck.getStringBased18Cards();
}
```


---

## My Approach
## Alternative Outcome
