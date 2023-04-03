import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

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

    public static void main(String[] args)
    {
        //assigning values to rooms with hashmap
        roomsStringAndIntMap.put(1, "hall");
        roomsStringAndIntMap.put(2, "pinanoroom");
        roomsStringAndIntMap.put(3, "greenhouse");
        roomsStringAndIntMap.put(4, "studyroom");
        roomsStringAndIntMap.put(5, "billiard'sroom");
        roomsStringAndIntMap.put(6, "bedroom");
        roomsStringAndIntMap.put(7, "dinning");
        roomsStringAndIntMap.put(8, "library");
        roomsStringAndIntMap.put(9, "kitchen");

        System.out.println("\n\t\t\tWelcome to the 'Clue' game\n first enter the number of the players :");
        Scanner scan = new Scanner(System.in);
        int participantsTotalNum = scan.nextInt();
        System.out.println("**Disclaimer : due to some issues, you will always play as player1.**");

        //the initiation of the cards being made
        DeckOfCardsTotal myDeck = new DeckOfCardsTotal();

        //for the initial shuffling of the cards
        myDeck.shuffleCharCards();
        myDeck.shuffleToolCards();
        myDeck.shuffleRoomCards();

        //created this String array for holding the case of murder
        String[] correctAnswer = new String[3];
        correctAnswer[0] = myDeck.getMurdererChar();
        correctAnswer[1] = myDeck.getMurderTool();
        correctAnswer[2] = myDeck.getMurderRoom();

        //for knowing the settigs of the actual murder (commented when the game runs fully)
        //System.out.println("The murder setting is : " + Arrays.toString(correctAnswer));

        myDeck.shuffleArraySize18();
        //this 18 sized String array will store the 18 cards and will be used later
        String[] stringArrayOfCards = new String[18];
        for (int i  = 0; i < stringArrayOfCards.length; i++)
        {
            stringArrayOfCards[i] = myDeck.getStringBased18Cards();
        }

        //based on the input of the players, the code will differ
        switch (participantsTotalNum)
        {
            case 3:
                String[] player1Cards3 = new String[6];
                String[] player2Cards3 = new String[6];
                String[] player3Cards3 = new String[6];
                for (int count = 0; count < 6; count++)
                {
                    player1Cards3[count] = stringArrayOfCards[count];
                }
                for (int count = 6; count < 12; count++)
                {
                    player2Cards3[count - 6] = stringArrayOfCards[count];
                }
                for (int count = 12; count < 18; count++)
                {
                    player3Cards3[count - 12] = stringArrayOfCards[count];
                }
                //randomly assigning players to the rooms
                int startingRoomPlayer1Game3 = random.nextInt(9) + 1;
                System.out.println("Player1's starting room is : " +
                        startingRoomPlayer1Game3);
                int startingRoomPlayer2Game3 = random.nextInt(9) + 1;
                System.out.println("Player2's starting room is : " +
                        startingRoomPlayer2Game3);
                int startingRoomPlayer3Game3 = random.nextInt(9) + 1;
                System.out.println("Player3's starting room is : " +
                        startingRoomPlayer3Game3);
                //this is used as a flag to determine whether the game should be finished or not
                boolean endOfGameCon3 = false;
                //game will be played until user wins
                while (!(endOfGameCon3))
                {
                    System.out.println("Player1's turn : rolling dice");
                    dice1 = random.nextInt(6);
                    dice2 = random.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    //available moves for player1
                    int newRoomPlayer1Game3 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer1Game3)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {3,5,7,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;    //to reset;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {1,5,7}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {1,5,7,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {1,7,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {1,3,7,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {1,3,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {1,3,5,9}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {1,3,5}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {1,3,5,7}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer1Game3)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {2,4,6,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {4,6,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {6,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {2,6,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {2,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {2,4,8}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {2,4}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {2,4,6}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {4,6}");
                                newRoomPlayer1Game3 = scan.nextInt();
                                startingRoomPlayer1Game3 = newRoomPlayer1Game3;
                                newRoomPlayer1Game3 = 0;
                                break;
                        }
                    }
                    System.out.println("These are player1's cards (yours) : " +
                            Arrays.toString(player1Cards3) +
                            "\n\t**you might want to write them down**");
                    //when player1 wants to guess someone as the murderer
                    String[] notPossibleGaussForPlayer1CharGame3 = new String[6];   //names which player1 can't gauss by nature
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards3.length; j++)
                        {
                            if (player1Cards3[j].contains(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1CharGame3[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    //these are no longer needed
//                    System.out.println("You can not pick a murderer from this selection : " +
//                            Arrays.toString(notPossibleGaussForPlayer1CharGame3));
//                    System.out.println("Now enter the name of the character you suspect (type carefully as shown below) :\n" +
//                            Arrays.toString(charactersArrayOfNames));
                    System.out.print("Your possible suspect's name ? ");
                    String gaussForPlayer1CharGame3 = scan.next();
                    System.out.println();
                    //when player1 wants to gauss the tool for murder
                    String[] notPossibleGaussForPlayer1ToolGame3 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards3.length; j++)
                        {
                            if (player1Cards3[j].contains(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1ToolGame3[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    //these are no longer needed
//                    System.out.println("You can not pick a murder tool from this selection : " +
//                            Arrays.toString(notPossibleGaussForPlayer1ToolGame3));
//                    System.out.println("Now enter the name of the took you suspect (type carefully as shown below) :\n" +
//                            Arrays.toString(toolsArrayOfNames));
                    System.out.print("Your possible tool of murder ? ");
                    String gaussForPlayer1ToolGame3 = scan.next();
                    System.out.println();
                    System.out.println("\tasking now begins...");
                    boolean askingConGame3 = true;
                    while (askingConGame3)
                    {
                        for (int i = 0; i < player2Cards3.length; i++)
                        {
                            if (player2Cards3[i].contains(gaussForPlayer1CharGame3))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1CharGame3 + "'s card.");
                                askingConGame3 = false;
                                break;
                            }
                            if (player2Cards3[i].contains(gaussForPlayer1ToolGame3))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1ToolGame3 + "'s card.");
                                askingConGame3 = false;
                                break;
                            }
                        }
                        if (askingConGame3 == false) { break; }
                        for (int i = 0; i < player3Cards3.length; i++)
                        {
                            if (player3Cards3[i].contains(gaussForPlayer1CharGame3))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1CharGame3 + "'s card.");
                                askingConGame3 = false;
                                break;
                            }
                            if (player3Cards3[i].contains(gaussForPlayer1ToolGame3))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1ToolGame3 + "'s card.");
                                askingConGame3 = false;
                                break;
                            }
                        }
                        askingConGame3 = false;
                        break;
                    }

                    System.out.println("Would you like to pass(1) or make a final accusation(2) ? (enter one of these numbers)");
                    int player1Decesion = scan.nextInt();
                    if (player1Decesion == 2)
                    {
                        String gaussForPlayer1RoomGame3 = roomsStringAndIntMap.get(startingRoomPlayer1Game3);
                        String[] accusationForPlayer1Game3 = {gaussForPlayer1CharGame3, gaussForPlayer1ToolGame3, gaussForPlayer1RoomGame3};
                        if (correctAnswer[0].contains(accusationForPlayer1Game3[0]) &&
                            correctAnswer[1].contains(accusationForPlayer1Game3[1]) &&
                            correctAnswer[2].contains(accusationForPlayer1Game3[2]))
                        {
                            System.out.println("Player1 (you) has guessed right and won! ");
                            endOfGameCon3 = true;
                            break;
                        }else{
                            System.out.println("Player1 (you) has guessed wrong and lost...GAME OVER!");
                            endOfGameCon3 = true;
                            break;
                        }
                    }

                    //now onto player2's turn
                    SecureRandom random2 = new SecureRandom();
                    System.out.println("Player2's turn : rolling dice");
                    dice1 = random2.nextInt(6);
                    dice2 = random2.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    //player2 will be placed randomly
                    int newRoomPlayer2Game3 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer2Game3)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer2Game3)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;    //to reset;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game3 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game3 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game3 = newRoomPlayer2Game3;
                                newRoomPlayer2Game3 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer2CharGame3 = new String[6];   //names which player2 can't gauss by nature
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards3.length; j++)
                        {
                            if (player2Cards3[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2CharGame3[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Char = charactersArrayOfNames;   //first we make it full, then use it later
                    String[] possibleGaussesForPlayer2CharGame3 = new String[6];
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2CharGame3.length; j++)
                        {
                            if (tempForPlayer2Char[i].equals(notPossibleGaussForPlayer2CharGame3[j]))
                            {
                                tempForPlayer2Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        if (!(tempForPlayer2Char[i].equals("")))
                        {
                            possibleGaussesForPlayer2CharGame3[i] = tempForPlayer2Char[i];
                        }
                    }
                    String gaussForPlayer2CharGame3 = "";
                    int finalGaussPlayer2CharGame3 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2CharGame3[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2CharGame3 = random2.nextInt();
                    }
                    gaussForPlayer2CharGame3 = possibleGaussesForPlayer2CharGame3[finalGaussPlayer2CharGame3];
                    //when player2 wants to gauss the tool for murder
                    String[] notPossibleGaussForPlayer2ToolGame3 = new String[6];   //names which player2 can't gauss by nature
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards3.length; j++)
                        {
                            if (player2Cards3[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2ToolGame3[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Tool = toolsArrayOfNames;   //first we make it full, then use it later
                    String[] possibleGaussesForPlayer2ToolGame3 = new String[6];
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2ToolGame3.length; j++)
                        {
                            if (tempForPlayer2Tool[i].equals(notPossibleGaussForPlayer2ToolGame3[j]))
                            {
                                tempForPlayer2Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        if (!(tempForPlayer2Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer2ToolGame3[i] = tempForPlayer2Tool[i];
                        }
                    }
                    String gaussForPlayer2ToolGame3 = "";
                    int finalGaussPlayer2ToolGame3 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2ToolGame3[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2ToolGame3 = random2.nextInt(6);
                    }
                    gaussForPlayer2ToolGame3 = possibleGaussesForPlayer2ToolGame3[finalGaussPlayer2ToolGame3];
                    String gaussForPlayer2RoomGame3 = roomsStringAndIntMap.get(startingRoomPlayer2Game3);
                    String[] accusationForPlayer2Game3 = {gaussForPlayer2CharGame3, gaussForPlayer2ToolGame3, gaussForPlayer2RoomGame3};
                    System.out.println("Player2 declares : " +
                            accusationForPlayer2Game3[0] + " " +
                            accusationForPlayer2Game3[1] + " " +
                            accusationForPlayer2Game3[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame3 = true;
                    while (askingConGame3)
                    {
                        for (int i = 0; i < player3Cards3.length; i++)
                        {
                            if ((player3Cards3[i].equals(gaussForPlayer2CharGame3)) ||
                                    (player3Cards3[i].equals(gaussForPlayer2ToolGame3)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame3 = false;
                                break;
                            }
                            if (askingConGame3 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards3.length; i++)
                        {
                            if ((player1Cards3[i].equals(gaussForPlayer2CharGame3)) ||
                                    (player1Cards3[i].equals(gaussForPlayer2ToolGame3)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame3 = false;
                                break;
                            }
                            if (askingConGame3 == false) { break; }
                        }
                        askingConGame3 = false;
                        break;
                    }

                    //now onto player3's turn
                    SecureRandom random3 = new SecureRandom();
                    System.out.println("Player3's turn : rolling dice");
                    //to reset the dices
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random3.nextInt(6) + 1;
                    dice2 = random3.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    //player3 will be placed random3ly
                    int newRoomPlayer3Game3 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer3Game3)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer3Game3)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;    //to reset;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game3 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game3 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game3 = newRoomPlayer3Game3;
                                newRoomPlayer3Game3 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer3CharGame3 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards3.length; j++)
                        {
                            if (player3Cards3[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3CharGame3[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer3CharGame3 = new String[6];
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3CharGame3.length; j++)
                        {
                            if (tempForPlayer3Char[i].equals(notPossibleGaussForPlayer3CharGame3[j]))
                            {
                                tempForPlayer3Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        if (!(tempForPlayer3Char[i].equals("")))
                        {
                            possibleGaussesForPlayer3CharGame3[i] = tempForPlayer3Char[i];
                        }
                    }
                    String gaussForPlayer3CharGame3 = "";
                    int finalGaussPlayer3CharGame3 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3CharGame3[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3CharGame3 = random3.nextInt();
                    }
                    gaussForPlayer3CharGame3 = possibleGaussesForPlayer3CharGame3[finalGaussPlayer3CharGame3];
                    //when player3 wants to gauss the tool for murder
                    String[] notPossibleGaussForPlayer3ToolGame3 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards3.length; j++)
                        {
                            if (player3Cards3[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3ToolGame3[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer3ToolGame3 = new String[6];
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3ToolGame3.length; j++)
                        {
                            if (tempForPlayer3Tool[i].equals(notPossibleGaussForPlayer3ToolGame3[j]))
                            {
                                tempForPlayer3Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        if (!(tempForPlayer3Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer3ToolGame3[i] = tempForPlayer3Tool[i];
                        }
                    }
                    String gaussForPlayer3ToolGame3 = "";
                    int finalGaussPlayer3ToolGame3 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3ToolGame3[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3ToolGame3 = random3.nextInt(6);
                    }
                    gaussForPlayer3ToolGame3 = possibleGaussesForPlayer3ToolGame3[finalGaussPlayer3ToolGame3];
                    String gaussForPlayer3RoomGame3 = roomsStringAndIntMap.get(startingRoomPlayer3Game3);
                    String[] accusationForPlayer3Game3 = {gaussForPlayer3CharGame3, gaussForPlayer3ToolGame3, gaussForPlayer3RoomGame3};
                    System.out.println("Player3 declares : " +
                            accusationForPlayer3Game3[0] + " " +
                            accusationForPlayer3Game3[1] + " " +
                            accusationForPlayer3Game3[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame3 = true;
                    while (askingConGame3)
                    {
                        for (int i = 0; i < player1Cards3.length; i++)
                        {
                            if ((player1Cards3[i].equals(gaussForPlayer3CharGame3)) ||
                                    (player1Cards3[i].equals(gaussForPlayer3ToolGame3)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame3 = false;
                                break;
                            }
                            if (askingConGame3 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards3.length; i++)
                        {
                            if ((player2Cards3[i].equals(gaussForPlayer3CharGame3)) ||
                                    (player2Cards3[i].equals(gaussForPlayer3ToolGame3)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame3 = false;
                                break;
                            }
                            if (askingConGame3 == false) { break; }
                        }
                        askingConGame3 = false;
                        break;
                    }

                    //reseting some of the stuff
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    accusationForPlayer2Game3 = new String[]{"", "", ""};
                    accusationForPlayer3Game3 = new String[]{"", "", ""};
                    finalGaussPlayer2CharGame3 = 7;
                    finalGaussPlayer2ToolGame3 = 7;
                    finalGaussPlayer3CharGame3 = 7;
                    finalGaussPlayer3ToolGame3 = 7;
                }
                break;  //final break for 3 player based game





            case 4:
                String[] player1Cards4 = new String[5];
                String[] player2Cards4 = new String[5];
                String[] player3Cards4 = new String[4];
                String[] player4Cards4 = new String[4];
                for (int count = 0; count < 5; count++)
                {
                    player1Cards4[count] = stringArrayOfCards[count];
                }
                for (int count = 5; count < 10; count++)
                {
                    player2Cards4[count - 5] = stringArrayOfCards[count];
                }
                for (int count = 10; count < 14; count++)
                {
                    player3Cards4[count - 10] = stringArrayOfCards[count];
                }
                for (int count = 14; count < 18; count++)
                {
                    player4Cards4[count - 14] = stringArrayOfCards[count];
                }

                int startingRoomPlayer1Game4 = random.nextInt(9) + 1;
                System.out.println("Player1's starting room is : " +
                        startingRoomPlayer1Game4);
                int startingRoomPlayer2Game4 = random.nextInt(9) + 1;
                System.out.println("Player2's starting room is : " +
                        startingRoomPlayer2Game4);
                int startingRoomPlayer3Game4 = random.nextInt(9) + 1;
                System.out.println("Player3's starting room is : " +
                        startingRoomPlayer3Game4);
                int startingRoomPlayer4Game4 = random.nextInt(9) + 1;
                System.out.println("Player4's starting room is : " +
                        startingRoomPlayer4Game4);

                boolean endOfGameCon4 = false;
                while (!(endOfGameCon4))
                {
                    System.out.println("Player1's turn : rolling dice");
                    dice1 = random.nextInt(6);
                    dice2 = random.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer1Game4 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer1Game4)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {3,5,7,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {1,5,7}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {1,5,7,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {1,7,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {1,3,7,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {1,3,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {1,3,5,9}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {1,3,5}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {1,3,5,7}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer1Game4)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {2,4,6,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {4,6,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {6,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {2,6,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {2,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {2,4,8}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {2,4}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {2,4,6}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {4,6}");
                                newRoomPlayer1Game4 = scan.nextInt();
                                startingRoomPlayer1Game4 = newRoomPlayer1Game4;
                                newRoomPlayer1Game4 = 0;
                                break;
                        }
                    }
                    System.out.println("These are player1's cards (yours) : " +
                            Arrays.toString(player1Cards4) +
                            "\n\t**you might want to write them down**");
                    String[] notPossibleGaussForPlayer1CharGame4 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards4.length; j++)
                        {
                            if (player1Cards4[j].contains(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1CharGame4[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible suspect's name ? ");
                    String gaussForPlayer1CharGame4 = scan.next();
                    System.out.println();
                    String[] notPossibleGaussForPlayer1ToolGame4 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards4.length; j++)
                        {
                            if (player1Cards4[j].contains(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1ToolGame4[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible tool of murder ? ");
                    String gaussForPlayer1ToolGame4 = scan.next();
                    System.out.println();
                    System.out.println("\tasking now begins...");
                    boolean askingConGame4 = true;
                    while (askingConGame4)
                    {
                        for (int i = 0; i < player2Cards4.length; i++)
                        {
                            if (player2Cards4[i].contains(gaussForPlayer1CharGame4))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1CharGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                            if (player2Cards4[i].contains(gaussForPlayer1ToolGame4))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1ToolGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                        }
                        if (askingConGame4 == false) { break; }
                        for (int i = 0; i < player3Cards4.length; i++)
                        {
                            if (player3Cards4[i].contains(gaussForPlayer1CharGame4))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1CharGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                            if (player3Cards4[i].contains(gaussForPlayer1ToolGame4))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1ToolGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                        }
                        if (askingConGame4 == false) { break; }
                        for (int i = 0; i < player4Cards4.length; i++)
                        {
                            if (player4Cards4[i].contains(gaussForPlayer1CharGame4))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                            if (player4Cards4[i].contains(gaussForPlayer1CharGame4))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame4 + "'s card.");
                                askingConGame4 = false;
                                break;
                            }
                        }
                        askingConGame4 = false;
                        break;
                    }
                    System.out.println("Would you like to pass(1) or make a final accusation(2) ? (enter one of these numbers)");
                    int player1Decesion = scan.nextInt();
                    if (player1Decesion == 2)
                    {
                        String gaussForPlayer1RoomGame4 = roomsStringAndIntMap.get(startingRoomPlayer1Game4);
                        String[] accusationForPlayer1Game4 = {gaussForPlayer1CharGame4, gaussForPlayer1ToolGame4, gaussForPlayer1RoomGame4};
                        if (correctAnswer[0].contains(accusationForPlayer1Game4[0]) &&
                                correctAnswer[1].contains(accusationForPlayer1Game4[1]) &&
                                correctAnswer[2].contains(accusationForPlayer1Game4[2]))
                        {
                            System.out.println("Player1 (you) has guessed right and won! ");
                            endOfGameCon3 = true;
                            break;
                        }else{
                            System.out.println("Player1 (you) has guessed wrong and lost...GAME OVER!");
                            endOfGameCon3 = true;
                            break;
                        }
                    }

                    //now onto player2's turn
                    SecureRandom random2 = new SecureRandom();
                    System.out.println("Player2's turn : rolling dice");
                    dice1 = random2.nextInt(6);
                    dice2 = random2.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer2Game4 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer2Game4)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer2Game4)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game4 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game4 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game4 = newRoomPlayer2Game4;
                                newRoomPlayer2Game4 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer2CharGame4 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards4.length; j++)
                        {
                            if (player2Cards4[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2CharGame4[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer2CharGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2CharGame4.length; j++)
                        {
                            if (tempForPlayer2Char[i].equals(notPossibleGaussForPlayer2CharGame4[j]))
                            {
                                tempForPlayer2Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        if (!(tempForPlayer2Char[i].equals("")))
                        {
                            possibleGaussesForPlayer2CharGame4[i] = tempForPlayer2Char[i];
                        }
                    }
                    String gaussForPlayer2CharGame4 = "";
                    int finalGaussPlayer2CharGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2CharGame4[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2CharGame4 = random2.nextInt();
                    }
                    gaussForPlayer2CharGame4 = possibleGaussesForPlayer2CharGame4[finalGaussPlayer2CharGame4];
                    String[] notPossibleGaussForPlayer2ToolGame4 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards4.length; j++)
                        {
                            if (player2Cards4[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2ToolGame4[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer2ToolGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2ToolGame4.length; j++)
                        {
                            if (tempForPlayer2Tool[i].equals(notPossibleGaussForPlayer2ToolGame4[j]))
                            {
                                tempForPlayer2Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        if (!(tempForPlayer2Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer2ToolGame4[i] = tempForPlayer2Tool[i];
                        }
                    }
                    String gaussForPlayer2ToolGame4 = "";
                    int finalGaussPlayer2ToolGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2ToolGame4[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2ToolGame4 = random2.nextInt(6);
                    }
                    gaussForPlayer2ToolGame4 = possibleGaussesForPlayer2ToolGame4[finalGaussPlayer2ToolGame4];
                    String gaussForPlayer2RoomGame4 = roomsStringAndIntMap.get(startingRoomPlayer2Game4);
                    String[] accusationForPlayer2Game4 = {gaussForPlayer2CharGame4, gaussForPlayer2ToolGame4, gaussForPlayer2RoomGame4};
                    System.out.println("Player2 declares : " +
                            accusationForPlayer2Game4[0] + " " +
                            accusationForPlayer2Game4[1] + " " +
                            accusationForPlayer2Game4[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame4 = true;
                    while (askingConGame4)
                    {
                        for (int i = 0; i < player3Cards4.length; i++)
                        {
                            if ((player3Cards4[i].equals(gaussForPlayer2CharGame4)) ||
                                    (player3Cards4[i].equals(gaussForPlayer2ToolGame4)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards4.length; i++)
                        {
                            if ((player4Cards4[i].equals(gaussForPlayer2CharGame4)) ||
                                    (player4Cards4[i].equals(gaussForPlayer2ToolGame4)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards4.length; i++)
                        {
                            if ((player1Cards4[i].equals(gaussForPlayer2CharGame4)) ||
                                    (player1Cards4[i].equals(gaussForPlayer2ToolGame4)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        askingConGame4 = false;
                        break;
                    }

                    //now onto player3's turn
                    SecureRandom random3 = new SecureRandom();
                    System.out.println("Player3's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    dice1 = random3.nextInt(6) + 1;
                    dice2 = random3.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer3Game4 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer3Game4)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer3Game4)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game4 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game4 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game4 = newRoomPlayer3Game4;
                                newRoomPlayer3Game4 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer3CharGame4 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards4.length; j++)
                        {
                            if (player3Cards4[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3CharGame4[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer3CharGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3CharGame4.length; j++)
                        {
                            if (tempForPlayer3Char[i].equals(notPossibleGaussForPlayer3CharGame4[j]))
                            {
                                tempForPlayer3Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        if (!(tempForPlayer3Char[i].equals("")))
                        {
                            possibleGaussesForPlayer3CharGame4[i] = tempForPlayer3Char[i];
                        }
                    }
                    String gaussForPlayer3CharGame4 = "";
                    int finalGaussPlayer3CharGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3CharGame4[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3CharGame4 = random3.nextInt();
                    }
                    gaussForPlayer3CharGame4 = possibleGaussesForPlayer3CharGame4[finalGaussPlayer3CharGame4];
                    String[] notPossibleGaussForPlayer3ToolGame4 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards4.length; j++)
                        {
                            if (player3Cards4[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3ToolGame4[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer3ToolGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3ToolGame4.length; j++)
                        {
                            if (tempForPlayer3Tool[i].equals(notPossibleGaussForPlayer3ToolGame4[j]))
                            {
                                tempForPlayer3Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        if (!(tempForPlayer3Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer3ToolGame4[i] = tempForPlayer3Tool[i];
                        }
                    }
                    String gaussForPlayer3ToolGame4 = "";
                    int finalGaussPlayer3ToolGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3ToolGame4[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3ToolGame4 = random3.nextInt(6);
                    }
                    gaussForPlayer3ToolGame4 = possibleGaussesForPlayer3ToolGame4[finalGaussPlayer3ToolGame4];
                    String gaussForPlayer3RoomGame4 = roomsStringAndIntMap.get(startingRoomPlayer3Game4);
                    String[] accusationForPlayer3Game4 = {gaussForPlayer3CharGame4, gaussForPlayer3ToolGame4, gaussForPlayer3RoomGame4};
                    System.out.println("Player3 declares : " +
                            accusationForPlayer3Game4[0] + " " +
                            accusationForPlayer3Game4[1] + " " +
                            accusationForPlayer3Game4[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame4 = true;
                    while (askingConGame4)
                    {
                        for (int i = 0; i < player4Cards4.length; i++)
                        {
                            if ((player4Cards4[i].equals(gaussForPlayer3CharGame4)) ||
                                    (player4Cards4[i].equals(gaussForPlayer3ToolGame4)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards4.length; i++)
                        {
                            if ((player1Cards4[i].equals(gaussForPlayer3CharGame4)) ||
                                    (player1Cards4[i].equals(gaussForPlayer3ToolGame4)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards4.length; i++)
                        {
                            if ((player2Cards4[i].equals(gaussForPlayer3CharGame4)) ||
                                    (player2Cards4[i].equals(gaussForPlayer3ToolGame4)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        askingConGame4 = false;
                        break;
                    }

                    //now onto player4's turn
                    SecureRandom random4 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random4.nextInt(6) + 1;
                    dice2 = random4.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer4Game4 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer4Game4)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer4Game4)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game4 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game4 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game4 = newRoomPlayer4Game4;
                                newRoomPlayer4Game4 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer4CharGame4 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards4.length; j++)
                        {
                            if (player4Cards4[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4CharGame4[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer4CharGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4CharGame4.length; j++)
                        {
                            if (tempForPlayer4Char[i].equals(notPossibleGaussForPlayer4CharGame4[j]))
                            {
                                tempForPlayer4Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        if (!(tempForPlayer4Char[i].equals("")))
                        {
                            possibleGaussesForPlayer4CharGame4[i] = tempForPlayer4Char[i];
                        }
                    }
                    String gaussForPlayer4CharGame4 = "";
                    int finalGaussPlayer4CharGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4CharGame4[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4CharGame4 = random4.nextInt();
                    }
                    gaussForPlayer4CharGame4 = possibleGaussesForPlayer4CharGame4[finalGaussPlayer4CharGame4];
                    String[] notPossibleGaussForPlayer4ToolGame4 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards4.length; j++)
                        {
                            if (player4Cards4[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4ToolGame4[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer4ToolGame4 = new String[6];
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4ToolGame4.length; j++)
                        {
                            if (tempForPlayer4Tool[i].equals(notPossibleGaussForPlayer4ToolGame4[j]))
                            {
                                tempForPlayer4Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        if (!(tempForPlayer4Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer4ToolGame4[i] = tempForPlayer4Tool[i];
                        }
                    }
                    String gaussForPlayer4ToolGame4 = "";
                    int finalGaussPlayer4ToolGame4 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4ToolGame4[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4ToolGame4 = random4.nextInt(6);
                    }
                    gaussForPlayer4ToolGame4 = possibleGaussesForPlayer4ToolGame4[finalGaussPlayer4ToolGame4];
                    String gaussForPlayer4RoomGame4 = roomsStringAndIntMap.get(startingRoomPlayer4Game4);
                    String[] accusationForPlayer4Game4 = {gaussForPlayer4CharGame4, gaussForPlayer4ToolGame4, gaussForPlayer4RoomGame4};
                    System.out.println("Player4 declares : " +
                            accusationForPlayer4Game4[0] + " " +
                            accusationForPlayer4Game4[1] + " " +
                            accusationForPlayer4Game4[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame4 = true;
                    while (askingConGame4)
                    {
                        for (int i = 0; i < player1Cards4.length; i++)
                        {
                            if ((player1Cards4[i].equals(gaussForPlayer4CharGame4)) ||
                                    (player1Cards4[i].equals(gaussForPlayer4ToolGame4)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards4.length; i++)
                        {
                            if ((player2Cards4[i].equals(gaussForPlayer4CharGame4)) ||
                                    (player2Cards4[i].equals(gaussForPlayer4ToolGame4)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards4.length; i++)
                        {
                            if ((player3Cards4[i].equals(gaussForPlayer4CharGame4)) ||
                                    (player3Cards4[i].equals(gaussForPlayer4ToolGame4)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame4 = false;
                                break;
                            }
                            if (askingConGame4 == false) { break; }
                        }
                        askingConGame4 = false;
                        break;
                    }
                    //resets
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    accusationForPlayer2Game4 = new String[]{"", "", ""};
                    accusationForPlayer3Game4 = new String[]{"", "", ""};
                    finalGaussPlayer2CharGame4 = 7;
                    finalGaussPlayer2ToolGame4 = 7;
                    finalGaussPlayer3CharGame4 = 7;
                    finalGaussPlayer3ToolGame4 = 7;
                    finalGaussPlayer4CharGame4 = 7;
                    finalGaussPlayer4ToolGame4 = 7;
                }
                break;  //final break for 4 player based game



            case 5:
                String[] player1Cards5 = new String[4];
                String[] player2Cards5 = new String[4];
                String[] player3Cards5 = new String[4];
                String[] player4Cards5 = new String[3];
                String[] player5Cards5 = new String[3];
                for (int count = 0; count < 4; count++)
                {
                    player1Cards5[count] = stringArrayOfCards[count];
                }
                for (int count = 4; count < 8; count++)
                {
                    player2Cards5[count - 4] = stringArrayOfCards[count];
                }
                for (int count = 8; count < 12; count++)
                {
                    player3Cards5[count - 8] = stringArrayOfCards[count];
                }
                for (int count = 12; count < 15; count++)
                {
                    player4Cards5[count - 12] = stringArrayOfCards[count];
                }
                for (int count = 15; count < 18; count++)
                {
                    player5Cards5[count - 15] = stringArrayOfCards[count];
                }

                int startingRoomPlayer1Game5 = random.nextInt(9) + 1;
                System.out.println("Player1's starting room is : " +
                        startingRoomPlayer1Game5);
                int startingRoomPlayer2Game5 = random.nextInt(9) + 1;
                System.out.println("Player2's starting room is : " +
                        startingRoomPlayer2Game5);
                int startingRoomPlayer3Game5 = random.nextInt(9) + 1;
                System.out.println("Player3's starting room is : " +
                        startingRoomPlayer3Game5);
                int startingRoomPlayer4Game5 = random.nextInt(9) + 1;
                System.out.println("Player4's starting room is : " +
                        startingRoomPlayer4Game5);
                int startingRoomPlayer5Game5 = random.nextInt(9) + 1;
                System.out.println("Player5's starting room is : " +
                        startingRoomPlayer5Game5);
                boolean endOfGameCon5 = false;
                while (!(endOfGameCon5))
                {
                    System.out.println("Player1's turn : rolling dice");
                    dice1 = random.nextInt(6);
                    dice2 = random.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer1Game5 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer1Game5)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {3,5,7,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {1,5,7}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {1,5,7,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {1,7,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {1,3,7,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {1,3,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {1,3,5,9}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {1,3,5}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {1,3,5,7}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer1Game5)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {2,4,6,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {4,6,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {6,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {2,6,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {2,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {2,4,8}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {2,4}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {2,4,6}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {4,6}");
                                newRoomPlayer1Game5 = scan.nextInt();
                                startingRoomPlayer1Game5 = newRoomPlayer1Game5;
                                newRoomPlayer1Game5 = 0;
                                break;
                        }
                    }
                    System.out.println("These are player1's cards (yours) : " +
                            Arrays.toString(player1Cards5) +
                            "\n\t**you might want to write them down**");
                    String[] notPossibleGaussForPlayer1CharGame5 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards5.length; j++)
                        {
                            if (player1Cards5[j].contains(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1CharGame5[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible suspect's name ? ");
                    String gaussForPlayer1CharGame5 = scan.next();
                    System.out.println();
                    String[] notPossibleGaussForPlayer1ToolGame5 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards5.length; j++)
                        {
                            if (player1Cards5[j].contains(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1ToolGame5[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible tool of murder ? ");
                    String gaussForPlayer1ToolGame5 = scan.next();
                    System.out.println();
                    System.out.println("\tasking now begins...");
                    boolean askingConGame5 = true;
                    while (askingConGame5)
                    {
                        for (int i = 0; i < player2Cards5.length; i++)
                        {
                            if (player2Cards5[i].contains(gaussForPlayer1CharGame5))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1CharGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                            if (player2Cards5[i].contains(gaussForPlayer1ToolGame5))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1ToolGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                        }
                        if (askingConGame5 == false) { break; }
                        for (int i = 0; i < player3Cards5.length; i++)
                        {
                            if (player3Cards5[i].contains(gaussForPlayer1CharGame5))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1CharGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                            if (player3Cards5[i].contains(gaussForPlayer1ToolGame5))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1ToolGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                        }
                        if (askingConGame5 == false) { break; }
                        for (int i = 0; i < player4Cards5.length; i++)
                        {
                            if (player4Cards5[i].contains(gaussForPlayer1CharGame5))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                            if (player4Cards5[i].contains(gaussForPlayer1CharGame5))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                        }
                        if (askingConGame5 == false) { break; }
                        for (int i = 0; i < player5Cards5.length; i++)
                        {
                            if (player5Cards5[i].contains(gaussForPlayer1CharGame5))
                            {
                                System.out.println("player5 has the " + gaussForPlayer1CharGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                            if (player5Cards5[i].contains(gaussForPlayer1ToolGame5))
                            {
                                System.out.println("player5 has the " + gaussForPlayer1ToolGame5 + "'s card.");
                                askingConGame5 = false;
                                break;
                            }
                        }
                        askingConGame5 = false;
                        break;
                    }
                    System.out.println("Would you like to pass(1) or make a final accusation(2) ? (enter one of these numbers)");
                    int player1Decesion = scan.nextInt();
                    if (player1Decesion == 2)
                    {
                        String gaussForPlayer1RoomGame5 = roomsStringAndIntMap.get(startingRoomPlayer1Game5);
                        String[] accusationForPlayer1Game5 = {gaussForPlayer1CharGame5, gaussForPlayer1ToolGame5, gaussForPlayer1RoomGame5};
                        if (correctAnswer[0].contains(accusationForPlayer1Game5[0]) &&
                                correctAnswer[1].contains(accusationForPlayer1Game5[1]) &&
                                correctAnswer[2].contains(accusationForPlayer1Game5[2]))
                        {
                            System.out.println("Player1 (you) has guessed right and won! ");
                            endOfGameCon3 = true;
                            break;
                        }else{
                            System.out.println("Player1 (you) has guessed wrong and lost...GAME OVER!");
                            endOfGameCon3 = true;
                            break;
                        }
                    }

                    //now onto player2's turn
                    SecureRandom random2 = new SecureRandom();
                    System.out.println("Player2's turn : rolling dice");
                    dice1 = random2.nextInt(6);
                    dice2 = random2.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer2Game5 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer2Game5)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer2Game5)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game5 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game5 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game5 = newRoomPlayer2Game5;
                                newRoomPlayer2Game5 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer2CharGame5 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards5.length; j++)
                        {
                            if (player2Cards5[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2CharGame5[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer2CharGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2CharGame5.length; j++)
                        {
                            if (tempForPlayer2Char[i].equals(notPossibleGaussForPlayer2CharGame5[j]))
                            {
                                tempForPlayer2Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        if (!(tempForPlayer2Char[i].equals("")))
                        {
                            possibleGaussesForPlayer2CharGame5[i] = tempForPlayer2Char[i];
                        }
                    }
                    String gaussForPlayer2CharGame5 = "";
                    int finalGaussPlayer2CharGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2CharGame5[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2CharGame5 = random2.nextInt();
                    }
                    gaussForPlayer2CharGame5 = possibleGaussesForPlayer2CharGame5[finalGaussPlayer2CharGame5];
                    String[] notPossibleGaussForPlayer2ToolGame5 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards5.length; j++)
                        {
                            if (player2Cards5[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2ToolGame5[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer2ToolGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2ToolGame5.length; j++)
                        {
                            if (tempForPlayer2Tool[i].equals(notPossibleGaussForPlayer2ToolGame5[j]))
                            {
                                tempForPlayer2Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        if (!(tempForPlayer2Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer2ToolGame5[i] = tempForPlayer2Tool[i];
                        }
                    }
                    String gaussForPlayer2ToolGame5 = "";
                    int finalGaussPlayer2ToolGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2ToolGame5[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2ToolGame5 = random2.nextInt(6);
                    }
                    gaussForPlayer2ToolGame5 = possibleGaussesForPlayer2ToolGame5[finalGaussPlayer2ToolGame5];
                    String gaussForPlayer2RoomGame5 = roomsStringAndIntMap.get(startingRoomPlayer2Game5);
                    String[] accusationForPlayer2Game5 = {gaussForPlayer2CharGame5, gaussForPlayer2ToolGame5, gaussForPlayer2RoomGame5};
                    System.out.println("Player2 declares : " +
                            accusationForPlayer2Game5[0] + " " +
                            accusationForPlayer2Game5[1] + " " +
                            accusationForPlayer2Game5[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame5 = true;
                    while (askingConGame5)
                    {
                        for (int i = 0; i < player3Cards5.length; i++)
                        {
                            if ((player3Cards5[i].equals(gaussForPlayer2CharGame5)) ||
                                    (player3Cards5[i].equals(gaussForPlayer2ToolGame5)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards5.length; i++)
                        {
                            if ((player4Cards5[i].equals(gaussForPlayer2CharGame5)) ||
                                    (player4Cards5[i].equals(gaussForPlayer2ToolGame5)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player5Cards5.length; i++)
                        {
                            if ((player5Cards5[i].equals(gaussForPlayer2CharGame5)) ||
                                    (player5Cards5[i].equals(gaussForPlayer2ToolGame5)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                        }
                        for (int i = 0; i < player1Cards5.length; i++)
                        {
                            if ((player1Cards5[i].equals(gaussForPlayer2CharGame5)) ||
                                    (player1Cards5[i].equals(gaussForPlayer2ToolGame5)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        askingConGame5 = false;
                        break;
                    }

                    //now onto player3's turn
                    SecureRandom random3 = new SecureRandom();
                    System.out.println("Player3's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    dice1 = random3.nextInt(6) + 1;
                    dice2 = random3.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer3Game5 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer3Game5)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer3Game5)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game5 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game5 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game5 = newRoomPlayer3Game5;
                                newRoomPlayer3Game5 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer3CharGame5 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards5.length; j++)
                        {
                            if (player3Cards5[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3CharGame5[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer3CharGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3CharGame5.length; j++)
                        {
                            if (tempForPlayer3Char[i].equals(notPossibleGaussForPlayer3CharGame5[j]))
                            {
                                tempForPlayer3Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        if (!(tempForPlayer3Char[i].equals("")))
                        {
                            possibleGaussesForPlayer3CharGame5[i] = tempForPlayer3Char[i];
                        }
                    }
                    String gaussForPlayer3CharGame5 = "";
                    int finalGaussPlayer3CharGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3CharGame5[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3CharGame5 = random3.nextInt();
                    }
                    gaussForPlayer3CharGame5 = possibleGaussesForPlayer3CharGame5[finalGaussPlayer3CharGame5];
                    String[] notPossibleGaussForPlayer3ToolGame5 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards5.length; j++)
                        {
                            if (player3Cards5[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3ToolGame5[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer3ToolGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3ToolGame5.length; j++)
                        {
                            if (tempForPlayer3Tool[i].equals(notPossibleGaussForPlayer3ToolGame5[j]))
                            {
                                tempForPlayer3Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        if (!(tempForPlayer3Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer3ToolGame5[i] = tempForPlayer3Tool[i];
                        }
                    }
                    String gaussForPlayer3ToolGame5 = "";
                    int finalGaussPlayer3ToolGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3ToolGame5[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3ToolGame5 = random3.nextInt(6);
                    }
                    gaussForPlayer3ToolGame5 = possibleGaussesForPlayer3ToolGame5[finalGaussPlayer3ToolGame5];
                    String gaussForPlayer3RoomGame5 = roomsStringAndIntMap.get(startingRoomPlayer3Game5);
                    String[] accusationForPlayer3Game5 = {gaussForPlayer3CharGame5, gaussForPlayer3ToolGame5, gaussForPlayer3RoomGame5};
                    System.out.println("Player3 declares : " +
                            accusationForPlayer3Game5[0] + " " +
                            accusationForPlayer3Game5[1] + " " +
                            accusationForPlayer3Game5[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame5 = true;
                    while (askingConGame5)
                    {
                        for (int i = 0; i < player4Cards5.length; i++)
                        {
                            if ((player4Cards5[i].equals(gaussForPlayer3CharGame5)) ||
                                    (player4Cards5[i].equals(gaussForPlayer3ToolGame5)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player5Cards5.length; i++)
                        {
                            if ((player5Cards5[i].equals(gaussForPlayer3CharGame5)) ||
                                    (player5Cards5[i].equals(gaussForPlayer3ToolGame5)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards5.length; i++)
                        {
                            if ((player1Cards5[i].equals(gaussForPlayer3CharGame5)) ||
                                    (player1Cards5[i].equals(gaussForPlayer3ToolGame5)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards5.length; i++)
                        {
                            if ((player2Cards5[i].equals(gaussForPlayer3CharGame5)) ||
                                    (player2Cards5[i].equals(gaussForPlayer3ToolGame5)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        askingConGame5 = false;
                        break;
                    }

                    //now onto player4's turn
                    SecureRandom random4 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random4.nextInt(6) + 1;
                    dice2 = random4.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer4Game5 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer4Game5)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer4Game5)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game5 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game5 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game5 = newRoomPlayer4Game5;
                                newRoomPlayer4Game5 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer4CharGame5 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards5.length; j++)
                        {
                            if (player4Cards5[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4CharGame5[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer4CharGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4CharGame5.length; j++)
                        {
                            if (tempForPlayer4Char[i].equals(notPossibleGaussForPlayer4CharGame5[j]))
                            {
                                tempForPlayer4Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        if (!(tempForPlayer4Char[i].equals("")))
                        {
                            possibleGaussesForPlayer4CharGame5[i] = tempForPlayer4Char[i];
                        }
                    }
                    String gaussForPlayer4CharGame5 = "";
                    int finalGaussPlayer4CharGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4CharGame5[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4CharGame5 = random4.nextInt();
                    }
                    gaussForPlayer4CharGame5 = possibleGaussesForPlayer4CharGame5[finalGaussPlayer4CharGame5];
                    String[] notPossibleGaussForPlayer4ToolGame5 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards5.length; j++)
                        {
                            if (player4Cards5[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4ToolGame5[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer4ToolGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4ToolGame5.length; j++)
                        {
                            if (tempForPlayer4Tool[i].equals(notPossibleGaussForPlayer4ToolGame5[j]))
                            {
                                tempForPlayer4Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        if (!(tempForPlayer4Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer4ToolGame5[i] = tempForPlayer4Tool[i];
                        }
                    }
                    String gaussForPlayer4ToolGame5 = "";
                    int finalGaussPlayer4ToolGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4ToolGame5[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4ToolGame5 = random4.nextInt(6);
                    }
                    gaussForPlayer4ToolGame5 = possibleGaussesForPlayer4ToolGame5[finalGaussPlayer4ToolGame5];
                    String gaussForPlayer4RoomGame5 = roomsStringAndIntMap.get(startingRoomPlayer4Game5);
                    String[] accusationForPlayer4Game5 = {gaussForPlayer4CharGame5, gaussForPlayer4ToolGame5, gaussForPlayer4RoomGame5};
                    System.out.println("Player4 declares : " +
                            accusationForPlayer4Game5[0] + " " +
                            accusationForPlayer4Game5[1] + " " +
                            accusationForPlayer4Game5[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame5 = true;
                    while (askingConGame5)
                    {
                        for (int i = 0; i < player5Cards5.length; i++)
                        {
                            if ((player5Cards5[i].equals(gaussForPlayer4CharGame5)) ||
                                    (player5Cards5[i].equals(gaussForPlayer4ToolGame5)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards5.length; i++)
                        {
                            if ((player1Cards5[i].equals(gaussForPlayer4CharGame5)) ||
                                    (player1Cards5[i].equals(gaussForPlayer4ToolGame5)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards5.length; i++)
                        {
                            if ((player2Cards5[i].equals(gaussForPlayer4CharGame5)) ||
                                    (player2Cards5[i].equals(gaussForPlayer4ToolGame5)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards5.length; i++)
                        {
                            if ((player3Cards5[i].equals(gaussForPlayer4CharGame5)) ||
                                    (player3Cards5[i].equals(gaussForPlayer4ToolGame5)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        askingConGame5 = false;
                        break;
                    }

                    //now onto player5's turn
                    SecureRandom random5 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random5.nextInt(6) + 1;
                    dice2 = random5.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer5Game5 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer5Game5)
                        {
                            case 1:
                                int[] Player5PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer5In1 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms1[randRoomSelectPlayer5In1];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 2:
                                int[] Player5PossibleRooms2 = {1,5,7};
                                int random5RoomSelectPlayer5In2 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms2[random5RoomSelectPlayer5In2];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 3:
                                int[] Player5PossibleRooms3 = {1,5,7,9};
                                int random5RoomSelectPlayer5In3 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms3[random5RoomSelectPlayer5In3];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 4:
                                int[] Player5PossibleRooms4 = {1,7,9};
                                int random5RoomSelectPlayer5In4 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms4[random5RoomSelectPlayer5In4];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 5:
                                int[] Player5PossibleRooms5 = {1,3,7,9};
                                int random5RoomSelectPlayer5In5 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms5[random5RoomSelectPlayer5In5];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 6:
                                int[] Player5PossibleRooms6 = {1,3,9};
                                int random5RoomSelectPlayer5In6 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms6[random5RoomSelectPlayer5In6];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 7:
                                int[] Player5PossibleRooms7 = {1,3,5,9};
                                int random5RoomSelectPlayer5In7 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms7[random5RoomSelectPlayer5In7];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 8:
                                int[] Player5PossibleRooms8 = {1,3,5};
                                int random5RoomSelectPlayer5In8 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms8[random5RoomSelectPlayer5In8];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 9:
                                int[] Player5PossibleRooms9 = {1,3,5,7};
                                int random5RoomSelectPlayer5In9 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms9[random5RoomSelectPlayer5In9];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer5Game5)
                        {
                            case 1:
                                int[] Player5PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer5In1 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms1[randRoomSelectPlayer5In1];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 2:
                                int[] Player5PossibleRooms2 = {1,5,7};
                                int random5RoomSelectPlayer5In2 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms2[random5RoomSelectPlayer5In2];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 3:
                                int[] Player5PossibleRooms3 = {1,5,7,9};
                                int random5RoomSelectPlayer5In3 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms3[random5RoomSelectPlayer5In3];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 4:
                                int[] Player5PossibleRooms4 = {1,7,9};
                                int random5RoomSelectPlayer5In4 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms4[random5RoomSelectPlayer5In4];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 5:
                                int[] Player5PossibleRooms5 = {1,3,7,9};
                                int random5RoomSelectPlayer5In5 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms5[random5RoomSelectPlayer5In5];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 6:
                                int[] Player5PossibleRooms6 = {1,3,9};
                                int random5RoomSelectPlayer5In6 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms6[random5RoomSelectPlayer5In6];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 7:
                                int[] Player5PossibleRooms7 = {1,3,5,9};
                                int random5RoomSelectPlayer5In7 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms7[random5RoomSelectPlayer5In7];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 8:
                                int[] Player5PossibleRooms8 = {1,3,5};
                                int random5RoomSelectPlayer5In8 = random5.nextInt(3);
                                newRoomPlayer5Game5 = Player5PossibleRooms8[random5RoomSelectPlayer5In8];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                            case 9:
                                int[] Player5PossibleRooms9 = {1,3,5,7};
                                int random5RoomSelectPlayer5In9 = random5.nextInt(4);
                                newRoomPlayer5Game5 = Player5PossibleRooms9[random5RoomSelectPlayer5In9];
                                startingRoomPlayer5Game5 = newRoomPlayer5Game5;
                                newRoomPlayer5Game5 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer5CharGame5 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player5Cards5.length; j++)
                        {
                            if (player5Cards5[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer5CharGame5[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer5Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer5CharGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer5Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer5CharGame5.length; j++)
                        {
                            if (tempForPlayer5Char[i].equals(notPossibleGaussForPlayer5CharGame5[j]))
                            {
                                tempForPlayer5Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer5Char.length; i++)
                    {
                        if (!(tempForPlayer5Char[i].equals("")))
                        {
                            possibleGaussesForPlayer5CharGame5[i] = tempForPlayer5Char[i];
                        }
                    }
                    String gaussForPlayer5CharGame5 = "";
                    int finalGaussPlayer5CharGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer5CharGame5[random5.nextInt(6)], ""))
                    {
                        finalGaussPlayer5CharGame5 = random5.nextInt();
                    }
                    gaussForPlayer5CharGame5 = possibleGaussesForPlayer5CharGame5[finalGaussPlayer5CharGame5];
                    String[] notPossibleGaussForPlayer5ToolGame5 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player5Cards5.length; j++)
                        {
                            if (player5Cards5[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer5ToolGame5[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer5Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer5ToolGame5 = new String[6];
                    for (int i = 0; i < tempForPlayer5Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer5ToolGame5.length; j++)
                        {
                            if (tempForPlayer5Tool[i].equals(notPossibleGaussForPlayer5ToolGame5[j]))
                            {
                                tempForPlayer5Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer5Tool.length; i++)
                    {
                        if (!(tempForPlayer5Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer5ToolGame5[i] = tempForPlayer5Tool[i];
                        }
                    }
                    String gaussForPlayer5ToolGame5 = "";
                    int finalGaussPlayer5ToolGame5 = 0;
                    while (Objects.equals(possibleGaussesForPlayer5ToolGame5[random5.nextInt(6)], ""))
                    {
                        finalGaussPlayer5ToolGame5 = random5.nextInt(6);
                    }
                    gaussForPlayer5ToolGame5 = possibleGaussesForPlayer5ToolGame5[finalGaussPlayer5ToolGame5];
                    String gaussForPlayer5RoomGame5 = roomsStringAndIntMap.get(startingRoomPlayer5Game5);
                    String[] accusationForPlayer5Game5 = {gaussForPlayer5CharGame5, gaussForPlayer5ToolGame5, gaussForPlayer5RoomGame5};
                    System.out.println("Player5 declares : " +
                            accusationForPlayer5Game5[0] + " " +
                            accusationForPlayer5Game5[1] + " " +
                            accusationForPlayer5Game5[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame5 = true;
                    while (askingConGame5)
                    {
                        for (int i = 0; i < player1Cards5.length; i++)
                        {
                            if ((player1Cards5[i].equals(gaussForPlayer5CharGame5)) ||
                                    (player1Cards5[i].equals(gaussForPlayer5ToolGame5)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards5.length; i++)
                        {
                            if ((player2Cards5[i].equals(gaussForPlayer5CharGame5)) ||
                                    (player2Cards5[i].equals(gaussForPlayer5ToolGame5)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards5.length; i++)
                        {
                            if ((player3Cards5[i].equals(gaussForPlayer5CharGame5)) ||
                                    (player3Cards5[i].equals(gaussForPlayer5ToolGame5)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards5.length; i++)
                        {
                            if ((player4Cards5[i].equals(gaussForPlayer5CharGame5)) ||
                                    (player4Cards5[i].equals(gaussForPlayer5ToolGame5)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame5 = false;
                                break;
                            }
                            if (askingConGame5 == false) { break; }
                        }
                        askingConGame5 = false;
                        break;
                    }
                    //resets
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    accusationForPlayer2Game5 = new String[]{"", "", ""};
                    accusationForPlayer3Game5 = new String[]{"", "", ""};
                    finalGaussPlayer2CharGame5 = 7;
                    finalGaussPlayer2ToolGame5 = 7;
                    finalGaussPlayer3CharGame5 = 7;
                    finalGaussPlayer3ToolGame5 = 7;
                    finalGaussPlayer4CharGame5 = 7;
                    finalGaussPlayer4ToolGame5 = 7;
                    finalGaussPlayer5CharGame5 = 7;
                    finalGaussPlayer5ToolGame5 = 7;
                }
                break;  //last break for 5 player basd game






            case 6:
                String[] player1Cards6 = new String[3];
                String[] player2Cards6 = new String[3];
                String[] player3Cards6 = new String[3];
                String[] player4Cards6 = new String[3];
                String[] player5Cards6 = new String[3];
                String[] player6Cards6 = new String[3];
                for (int count = 0; count < 3; count++)
                {
                    player1Cards6[count] = stringArrayOfCards[count];
                }
                for (int count = 3; count < 6; count++)
                {
                    player2Cards6[count - 3] = stringArrayOfCards[count];
                }
                for (int count = 6; count < 9; count++)
                {
                    player3Cards6[count - 6] = stringArrayOfCards[count];
                }
                for (int count = 9; count < 12; count++)
                {
                    player4Cards6[count - 9] = stringArrayOfCards[count];
                }
                for (int count = 12; count < 15; count++)
                {
                    player5Cards6[count - 12] = stringArrayOfCards[count];
                }
                for (int count = 15; count < 18; count++)
                {
                    player6Cards6[count - 15] = stringArrayOfCards[count];
                }

                int startingRoomPlayer1Game6 = random.nextInt(9) + 1;
                System.out.println("Player1's starting room is : " +
                        startingRoomPlayer1Game6);
                int startingRoomPlayer2Game6 = random.nextInt(9) + 1;
                System.out.println("Player2's starting room is : " +
                        startingRoomPlayer2Game6);
                int startingRoomPlayer3Game6 = random.nextInt(9) + 1;
                System.out.println("Player3's starting room is : " +
                        startingRoomPlayer3Game6);
                int startingRoomPlayer4Game6 = random.nextInt(9) + 1;
                System.out.println("Player4's starting room is : " +
                        startingRoomPlayer4Game6);
                int startingRoomPlayer5Game6 = random.nextInt(9) + 1;
                System.out.println("Player5's starting room is : " +
                        startingRoomPlayer5Game6);
                int startingRoomPlayer6Game6 = random.nextInt(9) + 1;
                System.out.println("Player6's starting room is : " +
                        startingRoomPlayer6Game6);
                boolean endOfGameCon6 = false;
                while (!(endOfGameCon6))
                {
                    System.out.println("Player1's turn : rolling dice");
                    dice1 = random.nextInt(6);
                    dice2 = random.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer1Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer1Game6)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {3,5,7,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {1,5,7}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {1,5,7,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {1,7,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {1,3,7,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {1,3,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {1,3,5,9}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {1,3,5}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {1,3,5,7}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer1Game6)
                        {
                            case 1:
                                System.out.println("select from these options as rooms -> {2,4,6,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 2:
                                System.out.println("select from these options as rooms -> {4,6,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 3:
                                System.out.println("select from these options as rooms -> {6,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 4:
                                System.out.println("select from these options as rooms -> {2,6,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 5:
                                System.out.println("select from these options as rooms -> {2,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 6:
                                System.out.println("select from these options as rooms -> {2,4,8}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 7:
                                System.out.println("select from these options as rooms -> {2,4}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 8:
                                System.out.println("select from these options as rooms -> {2,4,6}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                            case 9:
                                System.out.println("select from these options as rooms -> {4,6}");
                                newRoomPlayer1Game6 = scan.nextInt();
                                startingRoomPlayer1Game6 = newRoomPlayer1Game6;
                                newRoomPlayer1Game6 = 0;
                                break;
                        }
                    }
                    System.out.println("These are player1's cards (yours) : " +
                            Arrays.toString(player1Cards6) +
                            "\n\t**you might want to write them down**");
                    String[] notPossibleGaussForPlayer1CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards6.length; j++)
                        {
                            if (player1Cards6[j].contains(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible suspect's name ? ");
                    String gaussForPlayer1CharGame6 = scan.next();
                    System.out.println();
                    String[] notPossibleGaussForPlayer1ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player1Cards6.length; j++)
                        {
                            if (player1Cards6[j].contains(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer1ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    System.out.print("Your possible tool of murder ? ");
                    String gaussForPlayer1ToolGame6 = scan.next();
                    System.out.println();
                    System.out.println("\tasking now begins...");
                    boolean askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player2Cards6.length; i++)
                        {
                            if (player2Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                            if (player2Cards6[i].contains(gaussForPlayer1ToolGame6))
                            {
                                System.out.println("player2 has the " + gaussForPlayer1ToolGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        if (askingConGame6 == false) { break; }
                        for (int i = 0; i < player3Cards6.length; i++)
                        {
                            if (player3Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                            if (player3Cards6[i].contains(gaussForPlayer1ToolGame6))
                            {
                                System.out.println("player3 has the " + gaussForPlayer1ToolGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        if (askingConGame6 == false) { break; }
                        for (int i = 0; i < player4Cards6.length; i++)
                        {
                            if (player4Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                            if (player4Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player4 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        if (askingConGame6 == false) { break; }
                        for (int i = 0; i < player5Cards6.length; i++)
                        {
                            if (player5Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player5 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                            if (player5Cards6[i].contains(gaussForPlayer1ToolGame6))
                            {
                                System.out.println("player5 has the " + gaussForPlayer1ToolGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        if (askingConGame6 == false) { break; }
                        for (int i = 0; i < player6Cards6.length; i++)
                        {
                            if (player6Cards6[i].contains(gaussForPlayer1CharGame6))
                            {
                                System.out.println("player6 has the " + gaussForPlayer1CharGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                            if (player6Cards6[i].contains(gaussForPlayer1ToolGame6))
                            {
                                System.out.println("player6 has the " + gaussForPlayer1ToolGame6 + "'s card.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        askingConGame6 = false;
                        break;
                    }
                    System.out.println("Would you like to pass(1) or make a final accusation(2) ? (enter one of these numbers)");
                    int player1Decesion = scan.nextInt();
                    if (player1Decesion == 2)
                    {
                        String gaussForPlayer1RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer1Game6);
                        String[] accusationForPlayer1Game6 = {gaussForPlayer1CharGame6, gaussForPlayer1ToolGame6, gaussForPlayer1RoomGame6};
                        if (correctAnswer[0].contains(accusationForPlayer1Game6[0]) &&
                                correctAnswer[1].contains(accusationForPlayer1Game6[1]) &&
                                correctAnswer[2].contains(accusationForPlayer1Game6[2]))
                        {
                            System.out.println("Player1 (you) has guessed right and won! ");
                            endOfGameCon3 = true;
                            break;
                        }else{
                            System.out.println("Player1 (you) has guessed wrong and lost...GAME OVER!");
                            endOfGameCon3 = true;
                            break;
                        }
                    }

                    //now onto player2's turn
                    SecureRandom random2 = new SecureRandom();
                    System.out.println("Player2's turn : rolling dice");
                    dice1 = random2.nextInt(6);
                    dice2 = random2.nextInt(6);
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer2Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer2Game6)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer2Game6)
                        {
                            case 1:
                                int[] player2PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer2In1 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms1[randRoomSelectPlayer2In1];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 2:
                                int[] player2PossibleRooms2 = {1,5,7};
                                int random2RoomSelectPlayer2In2 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms2[random2RoomSelectPlayer2In2];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 3:
                                int[] player2PossibleRooms3 = {1,5,7,9};
                                int random2RoomSelectPlayer2In3 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms3[random2RoomSelectPlayer2In3];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 4:
                                int[] player2PossibleRooms4 = {1,7,9};
                                int random2RoomSelectPlayer2In4 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms4[random2RoomSelectPlayer2In4];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 5:
                                int[] player2PossibleRooms5 = {1,3,7,9};
                                int random2RoomSelectPlayer2In5 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms5[random2RoomSelectPlayer2In5];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 6:
                                int[] player2PossibleRooms6 = {1,3,9};
                                int random2RoomSelectPlayer2In6 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms6[random2RoomSelectPlayer2In6];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 7:
                                int[] player2PossibleRooms7 = {1,3,5,9};
                                int random2RoomSelectPlayer2In7 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms7[random2RoomSelectPlayer2In7];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 8:
                                int[] player2PossibleRooms8 = {1,3,5};
                                int random2RoomSelectPlayer2In8 = random2.nextInt(3);
                                newRoomPlayer2Game6 = player2PossibleRooms8[random2RoomSelectPlayer2In8];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                            case 9:
                                int[] player2PossibleRooms9 = {1,3,5,7};
                                int random2RoomSelectPlayer2In9 = random2.nextInt(4);
                                newRoomPlayer2Game6 = player2PossibleRooms9[random2RoomSelectPlayer2In9];
                                startingRoomPlayer2Game6 = newRoomPlayer2Game6;
                                newRoomPlayer2Game6 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer2CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards6.length; j++)
                        {
                            if (player2Cards6[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer2CharGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2CharGame6.length; j++)
                        {
                            if (tempForPlayer2Char[i].equals(notPossibleGaussForPlayer2CharGame6[j]))
                            {
                                tempForPlayer2Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Char.length; i++)
                    {
                        if (!(tempForPlayer2Char[i].equals("")))
                        {
                            possibleGaussesForPlayer2CharGame6[i] = tempForPlayer2Char[i];
                        }
                    }
                    String gaussForPlayer2CharGame6 = "";
                    int finalGaussPlayer2CharGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2CharGame6[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2CharGame6 = random2.nextInt();
                    }
                    gaussForPlayer2CharGame6 = possibleGaussesForPlayer2CharGame6[finalGaussPlayer2CharGame6];
                    String[] notPossibleGaussForPlayer2ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player2Cards6.length; j++)
                        {
                            if (player2Cards6[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer2ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer2Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer2ToolGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer2ToolGame6.length; j++)
                        {
                            if (tempForPlayer2Tool[i].equals(notPossibleGaussForPlayer2ToolGame6[j]))
                            {
                                tempForPlayer2Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer2Tool.length; i++)
                    {
                        if (!(tempForPlayer2Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer2ToolGame6[i] = tempForPlayer2Tool[i];
                        }
                    }
                    String gaussForPlayer2ToolGame6 = "";
                    int finalGaussPlayer2ToolGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer2ToolGame6[random2.nextInt(6)], ""))
                    {
                        finalGaussPlayer2ToolGame6 = random2.nextInt(6);
                    }
                    gaussForPlayer2ToolGame6 = possibleGaussesForPlayer2ToolGame6[finalGaussPlayer2ToolGame6];
                    String gaussForPlayer2RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer2Game6);
                    String[] accusationForPlayer2Game6 = {gaussForPlayer2CharGame6, gaussForPlayer2ToolGame6, gaussForPlayer2RoomGame6};
                    System.out.println("Player2 declares : " +
                            accusationForPlayer2Game6[0] + " " +
                            accusationForPlayer2Game6[1] + " " +
                            accusationForPlayer2Game6[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player3Cards6.length; i++)
                        {
                            if ((player3Cards6[i].equals(gaussForPlayer2CharGame6)) ||
                                    (player3Cards6[i].equals(gaussForPlayer2ToolGame6)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards6.length; i++)
                        {
                            if ((player4Cards6[i].equals(gaussForPlayer2CharGame6)) ||
                                    (player4Cards6[i].equals(gaussForPlayer2ToolGame6)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player5Cards6.length; i++)
                        {
                            if ((player5Cards6[i].equals(gaussForPlayer2CharGame6)) ||
                                    (player5Cards6[i].equals(gaussForPlayer2ToolGame6)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        for (int i = 0; i < player6Cards6.length; i++)
                        {
                            if ((player6Cards6[i].equals(gaussForPlayer2CharGame6)) ||
                                    (player6Cards6.equals(gaussForPlayer2ToolGame6)))
                            {
                                System.out.println("Player6 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                        }
                        for (int i = 0; i < player1Cards6.length; i++)
                        {
                            if ((player1Cards6[i].equals(gaussForPlayer2CharGame6)) ||
                                    (player1Cards6[i].equals(gaussForPlayer2ToolGame6)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        askingConGame6 = false;
                        break;
                    }

                    //now onto player3's turn
                    SecureRandom random3 = new SecureRandom();
                    System.out.println("Player3's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    dice1 = random3.nextInt(6) + 1;
                    dice2 = random3.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer3Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer3Game6)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer3Game6)
                        {
                            case 1:
                                int[] player3PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer3In1 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms1[randRoomSelectPlayer3In1];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 2:
                                int[] player3PossibleRooms2 = {1,5,7};
                                int random3RoomSelectPlayer3In2 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms2[random3RoomSelectPlayer3In2];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 3:
                                int[] player3PossibleRooms3 = {1,5,7,9};
                                int random3RoomSelectPlayer3In3 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms3[random3RoomSelectPlayer3In3];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 4:
                                int[] player3PossibleRooms4 = {1,7,9};
                                int random3RoomSelectPlayer3In4 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms4[random3RoomSelectPlayer3In4];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 5:
                                int[] player3PossibleRooms5 = {1,3,7,9};
                                int random3RoomSelectPlayer3In5 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms5[random3RoomSelectPlayer3In5];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 6:
                                int[] player3PossibleRooms6 = {1,3,9};
                                int random3RoomSelectPlayer3In6 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms6[random3RoomSelectPlayer3In6];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 7:
                                int[] player3PossibleRooms7 = {1,3,5,9};
                                int random3RoomSelectPlayer3In7 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms7[random3RoomSelectPlayer3In7];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 8:
                                int[] player3PossibleRooms8 = {1,3,5};
                                int random3RoomSelectPlayer3In8 = random3.nextInt(3);
                                newRoomPlayer3Game6 = player3PossibleRooms8[random3RoomSelectPlayer3In8];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                            case 9:
                                int[] player3PossibleRooms9 = {1,3,5,7};
                                int random3RoomSelectPlayer3In9 = random3.nextInt(4);
                                newRoomPlayer3Game6 = player3PossibleRooms9[random3RoomSelectPlayer3In9];
                                startingRoomPlayer3Game6 = newRoomPlayer3Game6;
                                newRoomPlayer3Game6 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer3CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards6.length; j++)
                        {
                            if (player3Cards6[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer3CharGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3CharGame6.length; j++)
                        {
                            if (tempForPlayer3Char[i].equals(notPossibleGaussForPlayer3CharGame6[j]))
                            {
                                tempForPlayer3Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Char.length; i++)
                    {
                        if (!(tempForPlayer3Char[i].equals("")))
                        {
                            possibleGaussesForPlayer3CharGame6[i] = tempForPlayer3Char[i];
                        }
                    }
                    String gaussForPlayer3CharGame6 = "";
                    int finalGaussPlayer3CharGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3CharGame6[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3CharGame6 = random3.nextInt();
                    }
                    gaussForPlayer3CharGame6 = possibleGaussesForPlayer3CharGame6[finalGaussPlayer3CharGame6];
                    String[] notPossibleGaussForPlayer3ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player3Cards6.length; j++)
                        {
                            if (player3Cards6[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer3ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer3Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer3ToolGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer3ToolGame6.length; j++)
                        {
                            if (tempForPlayer3Tool[i].equals(notPossibleGaussForPlayer3ToolGame6[j]))
                            {
                                tempForPlayer3Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer3Tool.length; i++)
                    {
                        if (!(tempForPlayer3Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer3ToolGame6[i] = tempForPlayer3Tool[i];
                        }
                    }
                    String gaussForPlayer3ToolGame6 = "";
                    int finalGaussPlayer3ToolGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer3ToolGame6[random3.nextInt(6)], ""))
                    {
                        finalGaussPlayer3ToolGame6 = random3.nextInt(6);
                    }
                    gaussForPlayer3ToolGame6 = possibleGaussesForPlayer3ToolGame6[finalGaussPlayer3ToolGame6];
                    String gaussForPlayer3RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer3Game6);
                    String[] accusationForPlayer3Game6 = {gaussForPlayer3CharGame6, gaussForPlayer3ToolGame6, gaussForPlayer3RoomGame6};
                    System.out.println("Player3 declares : " +
                            accusationForPlayer3Game6[0] + " " +
                            accusationForPlayer3Game6[1] + " " +
                            accusationForPlayer3Game6[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player4Cards6.length; i++)
                        {
                            if ((player4Cards6[i].equals(gaussForPlayer3CharGame6)) ||
                                    (player4Cards6[i].equals(gaussForPlayer3ToolGame6)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player5Cards6.length; i++)
                        {
                            if ((player5Cards6[i].equals(gaussForPlayer3CharGame6)) ||
                                    (player5Cards6[i].equals(gaussForPlayer3ToolGame6)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player6Cards6.length; i++)
                        {
                            if ((player6Cards6[i].equals(gaussForPlayer3CharGame6)) ||
                                    (player6Cards6[i].equals(gaussForPlayer3ToolGame6)))
                            {
                                System.out.println("Player6 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards6.length; i++)
                        {
                            if ((player1Cards6[i].equals(gaussForPlayer3CharGame6)) ||
                                    (player1Cards6[i].equals(gaussForPlayer3ToolGame6)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards6.length; i++)
                        {
                            if ((player2Cards6[i].equals(gaussForPlayer3CharGame6)) ||
                                    (player2Cards6[i].equals(gaussForPlayer3ToolGame6)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        askingConGame6 = false;
                        break;
                    }

                    //now onto player4's turn
                    SecureRandom random4 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random4.nextInt(6) + 1;
                    dice2 = random4.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer4Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer4Game6)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer4Game6)
                        {
                            case 1:
                                int[] Player4PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer4In1 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms1[randRoomSelectPlayer4In1];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 2:
                                int[] Player4PossibleRooms2 = {1,5,7};
                                int random4RoomSelectPlayer4In2 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms2[random4RoomSelectPlayer4In2];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 3:
                                int[] Player4PossibleRooms3 = {1,5,7,9};
                                int random4RoomSelectPlayer4In3 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms3[random4RoomSelectPlayer4In3];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 4:
                                int[] Player4PossibleRooms4 = {1,7,9};
                                int random4RoomSelectPlayer4In4 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms4[random4RoomSelectPlayer4In4];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 5:
                                int[] Player4PossibleRooms5 = {1,3,7,9};
                                int random4RoomSelectPlayer4In5 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms5[random4RoomSelectPlayer4In5];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 6:
                                int[] Player4PossibleRooms6 = {1,3,9};
                                int random4RoomSelectPlayer4In6 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms6[random4RoomSelectPlayer4In6];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 7:
                                int[] Player4PossibleRooms7 = {1,3,5,9};
                                int random4RoomSelectPlayer4In7 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms7[random4RoomSelectPlayer4In7];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 8:
                                int[] Player4PossibleRooms8 = {1,3,5};
                                int random4RoomSelectPlayer4In8 = random4.nextInt(3);
                                newRoomPlayer4Game6 = Player4PossibleRooms8[random4RoomSelectPlayer4In8];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                            case 9:
                                int[] Player4PossibleRooms9 = {1,3,5,7};
                                int random4RoomSelectPlayer4In9 = random4.nextInt(4);
                                newRoomPlayer4Game6 = Player4PossibleRooms9[random4RoomSelectPlayer4In9];
                                startingRoomPlayer4Game6 = newRoomPlayer4Game6;
                                newRoomPlayer4Game6 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer4CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards6.length; j++)
                        {
                            if (player4Cards6[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer4CharGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4CharGame6.length; j++)
                        {
                            if (tempForPlayer4Char[i].equals(notPossibleGaussForPlayer4CharGame6[j]))
                            {
                                tempForPlayer4Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Char.length; i++)
                    {
                        if (!(tempForPlayer4Char[i].equals("")))
                        {
                            possibleGaussesForPlayer4CharGame6[i] = tempForPlayer4Char[i];
                        }
                    }
                    String gaussForPlayer4CharGame6 = "";
                    int finalGaussPlayer4CharGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4CharGame6[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4CharGame6 = random4.nextInt();
                    }
                    gaussForPlayer4CharGame6 = possibleGaussesForPlayer4CharGame6[finalGaussPlayer4CharGame6];
                    String[] notPossibleGaussForPlayer4ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player4Cards6.length; j++)
                        {
                            if (player4Cards6[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer4ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer4Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer4ToolGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer4ToolGame6.length; j++)
                        {
                            if (tempForPlayer4Tool[i].equals(notPossibleGaussForPlayer4ToolGame6[j]))
                            {
                                tempForPlayer4Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer4Tool.length; i++)
                    {
                        if (!(tempForPlayer4Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer4ToolGame6[i] = tempForPlayer4Tool[i];
                        }
                    }
                    String gaussForPlayer4ToolGame6 = "";
                    int finalGaussPlayer4ToolGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer4ToolGame6[random4.nextInt(6)], ""))
                    {
                        finalGaussPlayer4ToolGame6 = random4.nextInt(6);
                    }
                    gaussForPlayer4ToolGame6 = possibleGaussesForPlayer4ToolGame6[finalGaussPlayer4ToolGame6];
                    String gaussForPlayer4RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer4Game6);
                    String[] accusationForPlayer4Game6 = {gaussForPlayer4CharGame6, gaussForPlayer4ToolGame6, gaussForPlayer4RoomGame6};
                    System.out.println("Player4 declares : " +
                            accusationForPlayer4Game6[0] + " " +
                            accusationForPlayer4Game6[1] + " " +
                            accusationForPlayer4Game6[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player5Cards6.length; i++)
                        {
                            if ((player5Cards6[i].equals(gaussForPlayer4CharGame6)) ||
                                    (player5Cards6[i].equals(gaussForPlayer4ToolGame6)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player6Cards6.length; i++)
                        {
                            if ((player6Cards6[i].equals(gaussForPlayer4CharGame6)) ||
                                    (player6Cards6[i].equals(gaussForPlayer4ToolGame6)))
                            {
                                System.out.println("Player6 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards6.length; i++)
                        {
                            if ((player1Cards6[i].equals(gaussForPlayer4CharGame6)) ||
                                    (player1Cards6[i].equals(gaussForPlayer4ToolGame6)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards6.length; i++)
                        {
                            if ((player2Cards6[i].equals(gaussForPlayer4CharGame6)) ||
                                    (player2Cards6[i].equals(gaussForPlayer4ToolGame6)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards6.length; i++)
                        {
                            if ((player3Cards6[i].equals(gaussForPlayer4CharGame6)) ||
                                    (player3Cards6[i].equals(gaussForPlayer4ToolGame6)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        askingConGame6 = false;
                        break;
                    }

                    //now onto player5's turn
                    SecureRandom random5 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random5.nextInt(6) + 1;
                    dice2 = random5.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer5Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer5Game6)
                        {
                            case 1:
                                int[] Player5PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer5In1 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms1[randRoomSelectPlayer5In1];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 2:
                                int[] Player5PossibleRooms2 = {1,5,7};
                                int random5RoomSelectPlayer5In2 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms2[random5RoomSelectPlayer5In2];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 3:
                                int[] Player5PossibleRooms3 = {1,5,7,9};
                                int random5RoomSelectPlayer5In3 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms3[random5RoomSelectPlayer5In3];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 4:
                                int[] Player5PossibleRooms4 = {1,7,9};
                                int random5RoomSelectPlayer5In4 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms4[random5RoomSelectPlayer5In4];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 5:
                                int[] Player5PossibleRooms5 = {1,3,7,9};
                                int random5RoomSelectPlayer5In5 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms5[random5RoomSelectPlayer5In5];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 6:
                                int[] Player5PossibleRooms6 = {1,3,9};
                                int random5RoomSelectPlayer5In6 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms6[random5RoomSelectPlayer5In6];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 7:
                                int[] Player5PossibleRooms7 = {1,3,5,9};
                                int random5RoomSelectPlayer5In7 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms7[random5RoomSelectPlayer5In7];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 8:
                                int[] Player5PossibleRooms8 = {1,3,5};
                                int random5RoomSelectPlayer5In8 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms8[random5RoomSelectPlayer5In8];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 9:
                                int[] Player5PossibleRooms9 = {1,3,5,7};
                                int random5RoomSelectPlayer5In9 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms9[random5RoomSelectPlayer5In9];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer5Game6)
                        {
                            case 1:
                                int[] Player5PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer5In1 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms1[randRoomSelectPlayer5In1];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 2:
                                int[] Player5PossibleRooms2 = {1,5,7};
                                int random5RoomSelectPlayer5In2 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms2[random5RoomSelectPlayer5In2];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 3:
                                int[] Player5PossibleRooms3 = {1,5,7,9};
                                int random5RoomSelectPlayer5In3 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms3[random5RoomSelectPlayer5In3];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 4:
                                int[] Player5PossibleRooms4 = {1,7,9};
                                int random5RoomSelectPlayer5In4 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms4[random5RoomSelectPlayer5In4];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 5:
                                int[] Player5PossibleRooms5 = {1,3,7,9};
                                int random5RoomSelectPlayer5In5 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms5[random5RoomSelectPlayer5In5];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 6:
                                int[] Player5PossibleRooms6 = {1,3,9};
                                int random5RoomSelectPlayer5In6 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms6[random5RoomSelectPlayer5In6];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 7:
                                int[] Player5PossibleRooms7 = {1,3,5,9};
                                int random5RoomSelectPlayer5In7 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms7[random5RoomSelectPlayer5In7];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 8:
                                int[] Player5PossibleRooms8 = {1,3,5};
                                int random5RoomSelectPlayer5In8 = random5.nextInt(3);
                                newRoomPlayer5Game6 = Player5PossibleRooms8[random5RoomSelectPlayer5In8];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                            case 9:
                                int[] Player5PossibleRooms9 = {1,3,5,7};
                                int random5RoomSelectPlayer5In9 = random5.nextInt(4);
                                newRoomPlayer5Game6 = Player5PossibleRooms9[random5RoomSelectPlayer5In9];
                                startingRoomPlayer5Game6 = newRoomPlayer5Game6;
                                newRoomPlayer5Game6 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer5CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player5Cards6.length; j++)
                        {
                            if (player5Cards6[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer5CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer5Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer5CharGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer5Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer5CharGame6.length; j++)
                        {
                            if (tempForPlayer5Char[i].equals(notPossibleGaussForPlayer5CharGame6[j]))
                            {
                                tempForPlayer5Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer5Char.length; i++)
                    {
                        if (!(tempForPlayer5Char[i].equals("")))
                        {
                            possibleGaussesForPlayer5CharGame6[i] = tempForPlayer5Char[i];
                        }
                    }
                    String gaussForPlayer5CharGame6 = "";
                    int finalGaussPlayer5CharGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer5CharGame6[random5.nextInt(6)], ""))
                    {
                        finalGaussPlayer5CharGame6 = random5.nextInt();
                    }
                    gaussForPlayer5CharGame6 = possibleGaussesForPlayer5CharGame6[finalGaussPlayer5CharGame6];
                    String[] notPossibleGaussForPlayer5ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player5Cards6.length; j++)
                        {
                            if (player5Cards6[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer5ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer5Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer5ToolGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer5Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer5ToolGame6.length; j++)
                        {
                            if (tempForPlayer5Tool[i].equals(notPossibleGaussForPlayer5ToolGame6[j]))
                            {
                                tempForPlayer5Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer5Tool.length; i++)
                    {
                        if (!(tempForPlayer5Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer5ToolGame6[i] = tempForPlayer5Tool[i];
                        }
                    }
                    String gaussForPlayer5ToolGame6 = "";
                    int finalGaussPlayer5ToolGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer5ToolGame6[random5.nextInt(6)], ""))
                    {
                        finalGaussPlayer5ToolGame6 = random5.nextInt(6);
                    }
                    gaussForPlayer5ToolGame6 = possibleGaussesForPlayer5ToolGame6[finalGaussPlayer5ToolGame6];
                    String gaussForPlayer5RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer5Game6);
                    String[] accusationForPlayer5Game6 = {gaussForPlayer5CharGame6, gaussForPlayer5ToolGame6, gaussForPlayer5RoomGame6};
                    System.out.println("Player5 declares : " +
                            accusationForPlayer5Game6[0] + " " +
                            accusationForPlayer5Game6[1] + " " +
                            accusationForPlayer5Game6[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player6Cards6.length; i++)
                        {
                            if ((player6Cards6[i].equals(gaussForPlayer5CharGame6)) ||
                                    (player6Cards6[i].equals(gaussForPlayer5ToolGame6)))
                            {
                                System.out.println("Player6 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player1Cards6.length; i++)
                        {
                            if ((player1Cards6[i].equals(gaussForPlayer5CharGame6)) ||
                                    (player1Cards6[i].equals(gaussForPlayer5ToolGame6)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards6.length; i++)
                        {
                            if ((player2Cards6[i].equals(gaussForPlayer5CharGame6)) ||
                                    (player2Cards6[i].equals(gaussForPlayer5ToolGame6)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards6.length; i++)
                        {
                            if ((player3Cards6[i].equals(gaussForPlayer5CharGame6)) ||
                                    (player3Cards6[i].equals(gaussForPlayer5ToolGame6)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards6.length; i++)
                        {
                            if ((player4Cards6[i].equals(gaussForPlayer5CharGame6)) ||
                                    (player4Cards6[i].equals(gaussForPlayer5ToolGame6)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        askingConGame6 = false;
                        break;
                    }

                    //now onto player6's turn
                    SecureRandom random6 = new SecureRandom();
                    System.out.println("Player4's turn : rolling dice");
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    dice1 = random6.nextInt(6) + 1;
                    dice2 = random6.nextInt(6) + 1;
                    resultOfDice = (dice1 + dice2)%2;
                    if (resultOfDice == 1)
                    {
                        System.out.println("odd number");
                    }else{
                        System.out.println("even number");
                    }
                    int newRoomPlayer6Game6 = 0;
                    if (resultOfDice == 1)
                    {
                        switch (startingRoomPlayer6Game6)
                        {
                            case 1:
                                int[] Player6PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer6In1 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms1[randRoomSelectPlayer6In1];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 2:
                                int[] Player6PossibleRooms2 = {1,5,7};
                                int random6RoomSelectPlayer6In2 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms2[random6RoomSelectPlayer6In2];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 3:
                                int[] Player6PossibleRooms3 = {1,5,7,9};
                                int random6RoomSelectPlayer6In3 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms3[random6RoomSelectPlayer6In3];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 4:
                                int[] Player6PossibleRooms4 = {1,7,9};
                                int random6RoomSelectPlayer6In4 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms4[random6RoomSelectPlayer6In4];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 5:
                                int[] Player6PossibleRooms5 = {1,3,7,9};
                                int random6RoomSelectPlayer6In5 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms5[random6RoomSelectPlayer6In5];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 6:
                                int[] Player6PossibleRooms6 = {1,3,9};
                                int random6RoomSelectPlayer6In6 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms6[random6RoomSelectPlayer6In6];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 7:
                                int[] Player6PossibleRooms7 = {1,3,5,9};
                                int random6RoomSelectPlayer6In7 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms7[random6RoomSelectPlayer6In7];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 8:
                                int[] Player6PossibleRooms8 = {1,3,5};
                                int random6RoomSelectPlayer6In8 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms8[random6RoomSelectPlayer6In8];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 9:
                                int[] Player6PossibleRooms9 = {1,3,5,7};
                                int random6RoomSelectPlayer6In9 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms9[random6RoomSelectPlayer6In9];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                        }
                    }else if (resultOfDice == 0)
                    {
                        switch (startingRoomPlayer6Game6)
                        {
                            case 1:
                                int[] Player6PossibleRooms1 = {3,5,7,9};
                                int randRoomSelectPlayer6In1 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms1[randRoomSelectPlayer6In1];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 2:
                                int[] Player6PossibleRooms2 = {1,5,7};
                                int random6RoomSelectPlayer6In2 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms2[random6RoomSelectPlayer6In2];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 3:
                                int[] Player6PossibleRooms3 = {1,5,7,9};
                                int random6RoomSelectPlayer6In3 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms3[random6RoomSelectPlayer6In3];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 4:
                                int[] Player6PossibleRooms4 = {1,7,9};
                                int random6RoomSelectPlayer6In4 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms4[random6RoomSelectPlayer6In4];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 5:
                                int[] Player6PossibleRooms5 = {1,3,7,9};
                                int random6RoomSelectPlayer6In5 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms5[random6RoomSelectPlayer6In5];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 6:
                                int[] Player6PossibleRooms6 = {1,3,9};
                                int random6RoomSelectPlayer6In6 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms6[random6RoomSelectPlayer6In6];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 7:
                                int[] Player6PossibleRooms7 = {1,3,5,9};
                                int random6RoomSelectPlayer6In7 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms7[random6RoomSelectPlayer6In7];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 8:
                                int[] Player6PossibleRooms8 = {1,3,5};
                                int random6RoomSelectPlayer6In8 = random6.nextInt(3);
                                newRoomPlayer6Game6 = Player6PossibleRooms8[random6RoomSelectPlayer6In8];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                            case 9:
                                int[] Player6PossibleRooms9 = {1,3,5,7};
                                int random6RoomSelectPlayer6In9 = random6.nextInt(4);
                                newRoomPlayer6Game6 = Player6PossibleRooms9[random6RoomSelectPlayer6In9];
                                startingRoomPlayer6Game6 = newRoomPlayer6Game6;
                                newRoomPlayer6Game6 = 0;
                                break;
                        }
                    }
                    String[] notPossibleGaussForPlayer6CharGame6 = new String[6];
                    for (int i = 0; i < charactersArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player6Cards6.length; j++)
                        {
                            if (player6Cards6[j].equals(charactersArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer6CharGame6[j] = charactersArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer6Char = charactersArrayOfNames;
                    String[] possibleGaussesForPlayer6CharGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer6Char.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer6CharGame6.length; j++)
                        {
                            if (tempForPlayer6Char[i].equals(notPossibleGaussForPlayer6CharGame6[j]))
                            {
                                tempForPlayer6Char[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer6Char.length; i++)
                    {
                        if (!(tempForPlayer6Char[i].equals("")))
                        {
                            possibleGaussesForPlayer6CharGame6[i] = tempForPlayer6Char[i];
                        }
                    }
                    String gaussForPlayer6CharGame6 = "";
                    int finalGaussPlayer6CharGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer6CharGame6[random6.nextInt(6)], ""))
                    {
                        finalGaussPlayer6CharGame6 = random6.nextInt();
                    }
                    gaussForPlayer6CharGame6 = possibleGaussesForPlayer6CharGame6[finalGaussPlayer6CharGame6];
                    String[] notPossibleGaussForPlayer6ToolGame6 = new String[6];
                    for (int i = 0; i < toolsArrayOfNames.length; i++)
                    {
                        for (int j = 0; j < player6Cards6.length; j++)
                        {
                            if (player6Cards6[j].equals(toolsArrayOfNames[i]))
                            {
                                notPossibleGaussForPlayer6ToolGame6[j] = toolsArrayOfNames[i];
                            }
                        }
                    }
                    String[] tempForPlayer6Tool = toolsArrayOfNames;
                    String[] possibleGaussesForPlayer6ToolGame6 = new String[6];
                    for (int i = 0; i < tempForPlayer6Tool.length; i++)
                    {
                        for (int j = 0; j < notPossibleGaussForPlayer6ToolGame6.length; j++)
                        {
                            if (tempForPlayer6Tool[i].equals(notPossibleGaussForPlayer6ToolGame6[j]))
                            {
                                tempForPlayer6Tool[i] = "";
                            }
                        }
                    }
                    for (int i = 0; i < tempForPlayer6Tool.length; i++)
                    {
                        if (!(tempForPlayer6Tool[i].equals("")))
                        {
                            possibleGaussesForPlayer6ToolGame6[i] = tempForPlayer6Tool[i];
                        }
                    }
                    String gaussForPlayer6ToolGame6 = "";
                    int finalGaussPlayer6ToolGame6 = 0;
                    while (Objects.equals(possibleGaussesForPlayer6ToolGame6[random6.nextInt(6)], ""))
                    {
                        finalGaussPlayer6ToolGame6 = random6.nextInt(6);
                    }
                    gaussForPlayer6ToolGame6 = possibleGaussesForPlayer6ToolGame6[finalGaussPlayer6ToolGame6];
                    String gaussForPlayer6RoomGame6 = roomsStringAndIntMap.get(startingRoomPlayer6Game6);
                    String[] accusationForPlayer6Game6 = {gaussForPlayer6CharGame6, gaussForPlayer6ToolGame6, gaussForPlayer6RoomGame6};
                    System.out.println("Player6 declares : " +
                            accusationForPlayer6Game6[0] + " " +
                            accusationForPlayer6Game6[1] + " " +
                            accusationForPlayer6Game6[2]);
                    System.out.println("\tasking now begins...");
                    askingConGame6 = true;
                    while (askingConGame6)
                    {
                        for (int i = 0; i < player1Cards6.length; i++)
                        {
                            if ((player1Cards6[i].equals(gaussForPlayer6CharGame6)) ||
                                    (player1Cards6[i].equals(gaussForPlayer6ToolGame6)))
                            {
                                System.out.println("Player1 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player2Cards6.length; i++)
                        {
                            if ((player2Cards6[i].equals(gaussForPlayer6CharGame6)) ||
                                    (player2Cards6[i].equals(gaussForPlayer6ToolGame6)))
                            {
                                System.out.println("Player2 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player3Cards6.length; i++)
                        {
                            if ((player3Cards6[i].equals(gaussForPlayer6CharGame6)) ||
                                    (player3Cards6[i].equals(gaussForPlayer6ToolGame6)))
                            {
                                System.out.println("Player3 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player4Cards6.length; i++)
                        {
                            if ((player4Cards6[i].equals(gaussForPlayer6CharGame6)) ||
                                    (player4Cards6[i].equals(gaussForPlayer6ToolGame6)))
                            {
                                System.out.println("Player4 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        for (int i = 0; i < player5Cards6.length; i++)
                        {
                            if ((player5Cards6[i].equals(gaussForPlayer6CharGame6)) ||
                                    (player5Cards6[i].equals(gaussForPlayer6ToolGame6)))
                            {
                                System.out.println("Player5 has one of the cards.");
                                askingConGame6 = false;
                                break;
                            }
                            if (askingConGame6 == false) { break; }
                        }
                        askingConGame6 = false;
                        break;
                    }
                    //resets
                    dice1 = 0;
                    dice2 = 0;
                    resultOfDice = 0;
                    accusationForPlayer2Game6 = new String[]{"", "", ""};
                    accusationForPlayer3Game6 = new String[]{"", "", ""};
                    finalGaussPlayer2CharGame6 = 7;
                    finalGaussPlayer2ToolGame6 = 7;
                    finalGaussPlayer3CharGame6 = 7;
                    finalGaussPlayer3ToolGame6 = 7;
                    finalGaussPlayer4CharGame6 = 7;
                    finalGaussPlayer4ToolGame6 = 7;
                    finalGaussPlayer5CharGame6 = 7;
                    finalGaussPlayer5ToolGame6 = 7;
                    finalGaussPlayer6CharGame6 = 7;
                    finalGaussPlayer6ToolGame6 = 7;
                }
                break;  //last break for 6 player based game
        }
    }
}