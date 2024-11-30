package Applications.ChessGame.Piece;
import Applications.ChessGame.Board;
import Applications.ChessGame.Color;

public class Pawn extends Piece{
    public Pawn(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol){
        int rowDiff = destRow - this.row;
        int colDiff = Math.abs(destCol - this.col);
        if(color == Color.WHITE){
            return ((rowDiff == 1 && colDiff == 0) || (this.row == 1 && rowDiff == 2 && colDiff == 0) || (rowDiff == 1 && colDiff == 1 && board.getPiece(destRow, destCol) != null));
        }
        else{
            return ((rowDiff == -1 && colDiff == 0) || (this.row == 6 && rowDiff == -2 && colDiff == 0) || (colDiff == 1 && rowDiff == -1 && board.getPiece(destRow, destCol) != null));
        }
    }
}
