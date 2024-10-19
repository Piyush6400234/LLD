package Applications.snakeAndLadder;

import java.util.*;


/*
-----------------------------------------REQUIREMENTS-------------------------------------------------------
1. Multiplayer Game
2. Customizable board in terms of snakes and ladder placement and board Size.
3. Customizable in terms of number of dice used
4. When the Game Board loads it should:
 -> Load the configured board size
 -> Load the configured snake and Ladder
 -> Load the configured number of Dice
 -> Load the number of players who will play the game and all the players should be at starting location

classes:
1. Player: stores PlayerName and playerId
2. Dice : stores info about number of dice configured and a rollDice method
3. Jumper: Can act as both snake and Ladder and stores startPoint and endPoint (we could also use separate snake class and Ladder Class)
4. GameBoard: stores Dice Object, Queue of Players, List of snakes and Ladders, and map of positions of each player and a method startGame
 -----------------------------------------------------------------------------------------------------------
*/
public class Main {
    public static void main(String[] args){
        Game snakeLadder = new Game();
        Player p = snakeLadder.startGame();
    }
}