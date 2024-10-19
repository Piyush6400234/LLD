package Applications.cricbuzz.Team.Player;
import java.util.*;
public class PlayerBowllingController {
    Deque<PlayerDetails> bowlersList;
    Map<PlayerDetails, Integer> bowlerVsOverCount;
    PlayerDetails currentBowler;

    public PlayerBowllingController(List<PlayerDetails> players){
        setBowlers(players);
    }
    private void setBowlers(List<PlayerDetails> players){
        this.bowlersList = new LinkedList<>();
        bowlersList.addAll(players);
        this.bowlerVsOverCount = new HashMap<>();

        for(PlayerDetails player: players){
            bowlerVsOverCount.put(player, 0);
        }
    }
    public void getNextBowler(int maxOverCountPerBowler){
        PlayerDetails playerDetails = bowlersList.poll();

        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler){
            currentBowler = playerDetails;
        }
        else{
            currentBowler = playerDetails;
            bowlersList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }
    }

    public PlayerDetails getCurrentBowler(){
        return this.currentBowler;
    }


}
