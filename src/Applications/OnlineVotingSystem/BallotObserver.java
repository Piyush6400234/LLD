package Applications.OnlineVotingSystem;
// Ballot observer to notify when a vote is cast
public class BallotObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Ballot Update: " + message);
    }
}
