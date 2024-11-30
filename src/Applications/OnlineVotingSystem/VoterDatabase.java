package Applications.OnlineVotingSystem;
import java.util.*;
// VoterController managing voter records
public class VoterDatabase {
    private List<Voter> voters;

    public VoterDatabase() {
        this.voters = new ArrayList<>();
    }

    public void addVoter(Voter voter) {
        voters.add(voter);
    }

    public Voter getVoter(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                return voter;
            }
        }
        return null;
    }

}
