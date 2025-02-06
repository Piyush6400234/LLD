package Applications.OnlineVotingSystem;
// Authentication Strategy interface and concrete implementation
public interface AuthenticationStrategy {
    boolean authenticate(Voter voter, VoterDatabase voterDatabase);

}
