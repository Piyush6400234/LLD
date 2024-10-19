package Applications.TicTacToe.Model;
import java.util.*;
import Applications.TicTacToe.Pair;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(board[row][col] == null){
            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }
    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++){
                if(board[i][j] == null){
                    Pair<Integer, Integer> box  = new Pair<>(i, j);
                    freeCells.add(box);
                }
            }
        }
        return freeCells;
    }

    public void printBoard(){
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++){
                if(board[i][j] != null){
                    System.out.print(" "+board[i][j].getPieceType().name()+" ");
                }
                else{
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
    public int getSize(){
        return size;
    }
    public PlayingPiece[][] getBoard(){
        return board;
    }
}
