package Applications.cricbuzz.Team;

import Applications.cricbuzz.Team.Player.*;

import java.util.*;

public class Team {
    public String teamName;
    Queue<PlayerDetails> players;
    public PlayerBattingController battingController;
    public PlayerBowllingController bowllingController;
    public boolean isWinner;

    public Team(String teamName, Queue<PlayerDetails> players, List<PlayerDetails> bench, List<PlayerDetails> bowlers){
        this.teamName = teamName;
        this.battingController = new PlayerBattingController(players);
        this.bowllingController = new PlayerBowllingController(bowlers);
        this.players = players;
    }
    public String getTeamName(){
        return this.teamName;
    }
    public void chooseNextBatsMan() throws Exception{
        this.battingController.getNextPlayer();
    }
    public void chooseNextBowler(int maxOverCountPerBowler){
        this.bowllingController.getNextBowler(maxOverCountPerBowler);
    }
    public void setStriker(PlayerDetails player){
        this.battingController.setStriker(player);
    }
    public void setNonStriker(PlayerDetails player){
        this.battingController.setNonStriker(player);
    }

    public PlayerDetails getStriker(){
        return this.battingController.getStriker();
    }
    public PlayerDetails getNonStriker(){
        return this.battingController.getNonStriker();
    }

    public PlayerDetails getCurrentBowler(){
        return this.bowllingController.getCurrentBowler();
    }
    public void printBattingScoreCard(){
        for(PlayerDetails player: players){
            player.printBattingScore();
        }
    }

    public void printBowlingScoreCard(){
        for(PlayerDetails player: players){
            if(player.bowlingScoreCard.totalOversCount>0){
                player.printBowlingScoreCard();
            }
        }
    }
    public int getTotalRuns(){
        int total = 0;
        for(PlayerDetails player: players){
            total+= player.battingScoreCard.totalRuns;
        }
        return total;
    }
}
