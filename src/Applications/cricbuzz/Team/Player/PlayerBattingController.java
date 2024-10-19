package Applications.cricbuzz.Team.Player;
import java.util.*;

public class PlayerBattingController {
    Queue<PlayerDetails> yetToPlay;
    PlayerDetails striker;
    PlayerDetails nonStriker;

    public PlayerBattingController(Queue<PlayerDetails> players){
        this.yetToPlay = new LinkedList<>();
        this.yetToPlay.addAll(players);
    }

    public void getNextPlayer() throws Exception {
        if(yetToPlay.isEmpty()){
            throw new Exception();
        }
        if(striker == null){
            this.striker = yetToPlay.poll();
        }
        if(nonStriker == null){
            this.nonStriker = yetToPlay.poll();
        }
    }
    public PlayerDetails getStriker() {
        return striker;
    }

    public PlayerDetails getNonStriker() {
        return nonStriker;
    }

    public void setStriker(PlayerDetails playerDetails) {
        striker = playerDetails;
    }

    public void setNonStriker(PlayerDetails playerDetails) {
        nonStriker = playerDetails;
    }

}