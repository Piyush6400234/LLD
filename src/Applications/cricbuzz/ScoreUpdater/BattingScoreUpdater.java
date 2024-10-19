package Applications.cricbuzz.ScoreUpdater;

import Applications.cricbuzz.Innings.BallDetails;
import Applications.cricbuzz.Innings.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(BallDetails details){
        int run = 0;
        if(details.runType == RunType.ONE){
            run = 1;
        }
        else if(details.runType == RunType.TWO){
            run = 2;
        }
        else if(details.runType == RunType.THREE){
            run = 3;
        }
        else if(details.runType == RunType.FOUR){
            run = 4;
            details.playedBy.battingScoreCard.totalSixes+=1;
        }
        else if(details.runType == RunType.SIX){
            run = 6;
            details.playedBy.battingScoreCard.totalSixes+=1;
        }
        details.playedBy.battingScoreCard.totalRuns+=run;
        details.playedBy.battingScoreCard.totalBallsPlayed+=1;

        if(details.wicket!=null){
            details.playedBy.battingScoreCard.wicketDetails = details.wicket;

        }

    }
}
