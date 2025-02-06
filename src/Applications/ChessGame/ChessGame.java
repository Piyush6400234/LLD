package Applications.ChessGame;

import Applications.ChessGame.Piece.Piece;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Player[] players;
    private int currPlayer;

    public ChessGame(){
        board = new Board();
        players = new Player[]{new Player(Color.WHITE), new Player(Color.BLACK)};
        currPlayer = 0;
    }

    public void start(){

        while(!isGameOver()){
            Player player = players[currPlayer];
            System.out.println(player.getColor()+ "'s turn");

            Move move = getPlayerMove(player);

            try{
                player.makeMove(board, move);
            }
            catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                System.out.println("Try Again");
                continue;
            }
            //switch to the next player
            currPlayer = (currPlayer+1)%2;
        }
        displayResult();
    }

    private boolean isGameOver(){
        return board.isCheckmate(players[0].getColor()) || board.isCheckmate(players[0].getColor()) || board.isStalemate(players[1].getColor()) || board.isStalemate(players[1].getColor());
    }

    private Move getPlayerMove(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();
        Piece piece = board.getPiece(sourceRow, sourceCol);

        if(piece == null || (piece.getColor() != player.getColor())){
            throw new IllegalArgumentException("Invalid piece selection!!");
        }
        return new Move(piece, destRow, destCol);
    }

    private void displayResult(){
        if(board.isCheckmate(Color.WHITE)){
            System.out.println("Black wins in checkmate!");
        } else if (board.isCheckmate(Color.BLACK)) {
            System.out.println("White wins in checkmate!");
        } else if (board.isStalemate(Color.BLACK) || (board.isStalemate(Color.WHITE))) {
            System.out.println("Game ends in stalemate");
            
        }
    }

}
