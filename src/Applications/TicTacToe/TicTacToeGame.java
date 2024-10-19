package Applications.TicTacToe;
import Applications.TicTacToe.Model.*;

import java.util.*;

public class TicTacToeGame {
    private Board gameBoard;
    Deque<Player> players;

    public void initializeGame(){
        PlayingPieceX pieceX = new PlayingPieceX();
        PlayingPieceO pieceO = new PlayingPieceO();

        Player player1 = new Player("piyush", pieceX);
        Player player2 = new Player("ritu", pieceO);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame(){

        boolean noWinner = true;
        while(noWinner){
            Player currPlayer = players.removeFirst();

            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }
            System.out.println("Player: "+ currPlayer.getName()+"'s turn.");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean placePiece = gameBoard.addPiece(inputRow, inputCol, currPlayer.getPlayingPiece());

            if(!placePiece){
                System.out.println("Can't place it there!!");
                players.addFirst(currPlayer);
                continue;
            }
            players.addLast(currPlayer);
            boolean winner = isWinner(inputRow, inputCol, currPlayer.getPlayingPiece().getPieceType());
            if(winner){
                gameBoard.printBoard();
                return currPlayer.getName();
            }
        }
        return "tie";
    }

    private boolean isWinner(int row, int col, PieceType pieceType){
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagMatch = true;
        boolean revDiagMatch = true;
        PlayingPiece[][] board = gameBoard.getBoard();
        // col match
        for(int i = 0; i<gameBoard.getSize(); i++) // considering gameBoard is sqyaredShaped
        {

            if(board[i][col] == null || board[i][col].getPieceType() != pieceType){
                colMatch =  false;
            }
        }

        // row match
        for(int j = 0; j< gameBoard.getSize(); j++){
            if(board[row][j] == null || board[row][j].getPieceType() != pieceType)
            {
                rowMatch = false;
            }
        }

        // diag match
        for(int i = 0, j =0; i< gameBoard.getSize() && j< gameBoard.getSize(); i++, j++){
            if(board[i][j] == null || board[i][j].getPieceType() != pieceType){
                diagMatch = false;
            }
        }

        // rev diag Match
        for(int j = 0, i = gameBoard.getSize()-1; i>=0 && j< gameBoard.getSize(); i--, j++ ){
            if(board[i][j] == null || board[i][j].getPieceType() != pieceType){
                revDiagMatch = false;
            }
        }
        return rowMatch || colMatch ||diagMatch || revDiagMatch;
    }
}
