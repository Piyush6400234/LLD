package Applications.TicTacToe.Model;

public class Player {
    private String name;
    PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPlayingPiece(PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }
    public PlayingPiece getPlayingPiece(){
        return playingPiece;
    }
}