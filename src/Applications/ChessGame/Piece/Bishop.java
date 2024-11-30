package Applications.ChessGame.Piece;
import Applications.ChessGame.Board;
import Applications.ChessGame.Color;

public class Bishop extends Piece {
    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }
    @Override
    public boolean canMove(Board board, int destRow, int destCol){
        int deltaRow = Math.abs(destRow - this.row);
        int deltaCol = Math.abs(destCol - this.col);
        return (deltaRow == deltaCol);

    }
}
