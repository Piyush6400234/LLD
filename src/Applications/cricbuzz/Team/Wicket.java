package Applications.cricbuzz.Team;
import Applications.cricbuzz.Innings.BallDetails;
import Applications.cricbuzz.Innings.OverDetails;
import Applications.cricbuzz.Team.Player.*;
public class Wicket {
    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetails;
    public BallDetails ballDetails;

    public Wicket(WicketType type, PlayerDetails takenBy, OverDetails overDetails, BallDetails ballDetails){
        this.ballDetails = ballDetails;
        this.takenBy = takenBy;
        this.wicketType = type;
        this.overDetails = overDetails;
    }
}