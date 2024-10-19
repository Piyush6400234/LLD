package Applications.cricbuzz.ScoreUpdater;

import Applications.cricbuzz.Innings.BallDetails;
import Applications.cricbuzz.Innings.BallType;
import Applications.cricbuzz.Innings.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver{

    @Override
    public void update(BallDetails details){
        if(details.ballNumber == 6 && details.ballType == BallType.NORMAL){
            details.bowledBy.bowlingScoreCard.totalOversCount+=1;
        }

        if(details.runType == RunType.ONE){
            details.bowledBy.bowlingScoreCard.runsGiven+=1;
        }
        else if(details.runType == RunType.TWO){
            details.bowledBy.bowlingScoreCard.runsGiven+=2;
        }
        else if(details.runType == RunType.THREE){
            details.bowledBy.bowlingScoreCard.runsGiven+=3;
        }
        else if(details.runType == RunType.FOUR){
            details.bowledBy.bowlingScoreCard.runsGiven+=4;
        }
        else if(details.runType == RunType.SIX){
            details.bowledBy.bowlingScoreCard.runsGiven+=6;
        }

        if(details.wicket != null){
            details.bowledBy.bowlingScoreCard.wicketsGiven+=1;
        }

        if(details.ballType == BallType.NOBALL){
            details.bowledBy.bowlingScoreCard.noBallsCount+=1;
        }
        else if(details.ballType == BallType.WIDEBALL){
            details.bowledBy.bowlingScoreCard.wideBallsCount+=1;
        }
    }
}