package Applications.cricbuzz.Team.Player;
import Applications.cricbuzz.Team.Player.Score.*;
public class PlayerDetails {
    public Person person;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;
    public PlayerType playerType;

    public PlayerDetails(PlayerType type, Person person){
        this.person = person;
        this.playerType = type;
        battingScoreCard = new BattingScoreCard();
        bowlingScoreCard = new BowlingScoreCard();
    }
    public void printBattingScore(){
        System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingScoreCard.totalRuns
                + " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: " + battingScoreCard.totalFours
                + " -- 6s: " + battingScoreCard.totalSixes + " -- outby: " +   ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.takenBy.person.name : "notout"));
    }
    public void printBowlingScoreCard(){
        System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingScoreCard.totalOversCount
                + " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: " + bowlingScoreCard.wicketsGiven);
    }
}