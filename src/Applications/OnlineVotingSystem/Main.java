package Applications.OnlineVotingSystem;
import java.util.*;


/*
Functional-requirements

Database design: We will need to store information about voters, candidates, and the votes themselves. This will likely
include tables for voters, candidates, and votes, with foreign keys to link them together. We will also need to consider
security and privacy concerns, such as ensuring that votes are anonymous and cannot be traced back to individual voters.

User authentication and authorization: Voters will need to be able to log in to the system in order to cast their votes.
We will need to implement measures to ensure the security of voter accounts, such as password hashing and potentially
two-factor authentication. We will also need to ensure that only eligible voters are able to log in and cast their votes.

Ballot design: The online voting system will need to allow voters to select their preferred candidates or options.
This will likely involve creating forms for voters to select their choices, with fields for the candidates or options.
We will need to consider usability and accessibility concerns when designing the ballot.

Vote tracking: The system will need to keep track of the votes as they are cast and provide a way for administrators
to view the results. This will involve implementing logic to store and count the votes, as well as creating views for
the administrators to view the results.

User interface: Finally, we will need to design the user interface for the voting system, including the layout,
navigation, and any necessary graphics or styling. This will involve creating wireframes and mockups, as well as
implementing the front-end code to bring the design to life
 */
public class Main {
    public static void main(String[] args) {
        VotingFactory factory = new VotingSystemFactory();
        OnlineVotingSystem votingSystem = new OnlineVotingSystem(factory);

        // Register voters
        votingSystem.registerVoter("Alice", "password1");
        votingSystem.registerVoter("Bob", "password2");

        // Add candidates
        votingSystem.addCandidate("John Doe", "Party A");
        votingSystem.addCandidate("Jane Smith", "Party B");

        // Create Voter and Candidate instances
        Voter alice = new Voter("Alice", "password1");
        Candidate johnDoe = new Candidate("John Doe", "Party A");


        Voter piyush = new Voter("Bob", "password2");
        // Cast vote using the Command Pattern
        votingSystem.castVote(alice, johnDoe);
        votingSystem.castVote(piyush, johnDoe);

        // Get and display election results
        List<Candidate> results = votingSystem.getResults();
        for (Candidate candidate : results) {
            System.out.println("Candidate: " + candidate.getName() + ", Encrypted Votes: " + candidate.getEncryptedVotes());
        }

    }
}
