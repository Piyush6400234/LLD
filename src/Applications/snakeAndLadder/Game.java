package Applications.snakeAndLadder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Game {
    GameBoard board;
    Deque<Player> players;
    Dice dice;
    Player winner;

    Game(){
        initializeGame();
    }
    private void initializeGame(){
        board = new GameBoard(10, 5, 4);
        dice = new Dice(1);
        addPlayers();

    }
    private void addPlayers(){
        Player player1 = new Player("piyush", 876, 0);
        Player player2 = new Player("Ritu", 678, 0);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        winner = null;
    }

    public Player startGame(){
        while(winner == null){
            Player currPlayer = players.removeFirst();
            System.out.println("current turn is of: "+currPlayer.getPlayerName()+" Present at "+currPlayer.getCurrentPosition());

            int dicesum = dice.rollDice();
            System.out.println("Dice: "+dicesum);
            int nextPos = dicesum+ currPlayer.getCurrentPosition();
            if(nextPos>board.getSize()){
                System.out.println("didn't work, make another move");
                players.addLast(currPlayer);
                continue;
            }
            if(nextPos == board.getSize()){
                winner = currPlayer;
                continue;
            }
            nextPos = playerNewPosition(nextPos);
            currPlayer.setCurrentPosition(nextPos);
            players.addLast(currPlayer);
            if(nextPos == board.getSize()){
                System.out.println("Player "+currPlayer.getPlayerName()+" Won the game!!");
                winner = currPlayer;
            }
        }
        System.out.println("Winner is "+winner.getPlayerName());
        return winner;
    }

    private int playerNewPosition(int pos){
        if(pos > board.getSize()){
            return pos;
        }
        Cell currCell = board.getCellAtStart(pos);

        if(currCell.getJumper() != null && currCell.getJumper().getStartPoint() == pos){
            String jumper = currCell.getJumper().getStartPoint()>currCell.getJumper().getEndPoint()?"snake":"ladder";
            System.out.println("Jump made by "+jumper);
            return currCell.getJumper().getEndPoint();
        }
        return pos;
    }
}
