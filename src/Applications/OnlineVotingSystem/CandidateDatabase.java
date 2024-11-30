package Applications.OnlineVotingSystem;
import java.util.*;
// CandidateController managing candidate records
public class CandidateDatabase {
    private List<Candidate> candidates;

    public CandidateDatabase() {
        this.candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

}
