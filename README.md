# Clue board game
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

---

## My Approach
## Alternative Outcome
