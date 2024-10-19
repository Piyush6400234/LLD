package Applications.cricbuzz.Innings;

import Applications.cricbuzz.Team.Player.PlayerDetails;
import Applications.cricbuzz.Team.Team;
import Applications.cricbuzz.Team.Wicket;
import Applications.cricbuzz.Team.WicketType;
import Applications.cricbuzz.ScoreUpdater.*;
import java.util.*;

public class BallDetails {
    public int ballNumber;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public BallType ballType;
    public RunType runType;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber){
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails overDetails){
        playedBy = battingTeam.getStriker();
        this.bowledBy = overDetails.bowledBy;
        // we will get this by user
        ballType = BallType.NORMAL;

        if(isWicketTaken()){
            runType = RunType.ZERO;
            wicket = new Wicket(WicketType.BOLD, this.bowledBy, overDetails, this);
            battingTeam.setStriker(null);
        }
        else{
            runType = getRunType();
            if(runType == RunType.ONE || runType == RunType.THREE){
                PlayerDetails striker = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(striker);
            }
        }
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails){

        for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballDetails);
        }
    }

    private RunType getRunType(){
        double val = Math.random();
        if(val<=0.2){
            return RunType.ONE;
        }
        else if(val>0.2 && val<=0.5){
            return RunType.TWO;
        }
        else if(val>0.5 && val<=0.8){
            return RunType.FOUR;
        }
        else{
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken(){
        if(Math.random() < 0.2){
            return true;
        }
        else{
            return false;
        }
    }
}
