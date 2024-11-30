package Applications.ChessGame.Piece;

import Applications.ChessGame.Board;
import Applications.ChessGame.Color;

public abstract class Piece {
    protected final Color color;
    protected int row;
    protected int col;

    public Piece(Color color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }
    // This method canMove will tell whether the piece can be moved from it's current position to destRow, destCol
    public abstract boolean canMove(Board board, int destRow, int destCol);

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
