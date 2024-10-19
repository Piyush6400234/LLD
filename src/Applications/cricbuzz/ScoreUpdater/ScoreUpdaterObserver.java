package Applications.cricbuzz.ScoreUpdater;

import Applications.cricbuzz.Innings.BallDetails;

public interface ScoreUpdaterObserver {
    void update(BallDetails details);
}
