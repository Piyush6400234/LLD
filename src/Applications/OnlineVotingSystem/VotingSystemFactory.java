package Applications.OnlineVotingSystem;

// Concrete Factory for the Online Voting System
public class VotingSystemFactory implements VotingFactory{
    @Override
    public Voter createVoter(String name, String password) {
        return new Voter(name, password);
    }

    @Override
    public Candidate createCandidate(String name, String party) {
        return new Candidate(name, party);
    }
}
