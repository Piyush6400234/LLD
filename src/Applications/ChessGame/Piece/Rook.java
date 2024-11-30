package Applications.ChessGame.Piece;
import Applications.ChessGame.Board;
import Applications.ChessGame.Color;

public class Rook extends Piece{
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol){
        return (row == destRow || col == destCol);
    }
}
