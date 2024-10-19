package Applications.cricbuzz.Innings;
import Applications.cricbuzz.Team.*;
import Applications.cricbuzz.MatchType;
import Applications.cricbuzz.Team.Player.PlayerDetails;

import java.util.*;

public class InningDetails {
    Team battingTeam;
    Team bowllingTeam;
    List<OverDetails> overs;
    MatchType type;

    public InningDetails(Team battingTeam, Team bowllingTeam, MatchType type){
        this.battingTeam = battingTeam;
        this.bowllingTeam = bowllingTeam;
        this.type = type;
        overs = new ArrayList<>();
    }
    public void start(int runsToWin){
        try{
            battingTeam.chooseNextBatsMan();
        }catch(Exception e){
            System.out.println("Something went wrong");
        }

        int noOfOvers = type.noOfOvers();
        for(int i = 1; i<=noOfOvers; i++){

            bowllingTeam.chooseNextBowler(type.maxOverCountPerBowlers());
            OverDetails over = new OverDetails(i, bowllingTeam.getCurrentBowler());
            overs.add(over);

            try{
                boolean won = over.startOver(battingTeam, bowllingTeam, runsToWin);
                if(won == true){
                    break;
                }
            }
            catch(Exception e){
                break;
            }
            PlayerDetails striker = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(striker);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }
}