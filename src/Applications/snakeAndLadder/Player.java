package Applications.snakeAndLadder;

public class Player {
    private String playerName;
    private int id; // can be used later for analytics purposes to get insight about user Activity and Logins
    private int currentPosition;
    public Player(String name, int id, int pos){
        this.playerName = name;
        this.id = id;
        this.currentPosition = pos;
    }
    public String getPlayerName(){
        return this.playerName;
    }
    public void setCurrentPosition(int pos){
        this.currentPosition = pos;
    }
    public int getCurrentPosition(){
        return this.currentPosition;
    }
}