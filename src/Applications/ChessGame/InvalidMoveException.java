package Applications.ChessGame;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(final String message){
        super(message);
    }
}