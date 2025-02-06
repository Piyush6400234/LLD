package Applications.OnlineVotingSystem;
// Factory for creating core entities (Voter, Candidate)
public interface VotingFactory {
    Voter createVoter(String name, String password);
    Candidate createCandidate(String name, String party);
}
