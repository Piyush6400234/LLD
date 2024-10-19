package Applications.cricbuzz;
import Applications.cricbuzz.Innings.InningDetails;
import Applications.cricbuzz.Team.*;
public class Match {
    public MatchType type;
    public Team teamA;
    public Team teamB;
    InningDetails[] innings;
//    String venue;
//    Date MatchDate;
//    Team tossWinner;

    public Match(Team teamA, Team teamB, MatchType type){
        this.innings = new InningDetails[2];
        this.teamA = teamA;
        this.teamB = teamB;
        this.type = type;
    }
    public void startMatch(){
        Team tossWinner = tossWinner(teamA, teamB);

        for(int inning = 1; inning<=2; inning++){
            Team battingTeam = null;
            Team bowllingTeam = null;
            InningDetails inningDetails = null;

            if(inning == 1){
//        Assuming that toss winner is batting Team
                battingTeam = tossWinner;
                bowllingTeam = tossWinner == teamA ? teamB: teamA;
                inningDetails = new InningDetails(battingTeam, bowllingTeam, this.type);
                inningDetails.start(-1);
            }
            else if(inning == 2){

                battingTeam = tossWinner == teamA?teamB:teamA;
                bowllingTeam = tossWinner;
                inningDetails = new InningDetails(battingTeam, bowllingTeam, this.type);
                inningDetails.start(innings[0].getTotalRuns());
                if(innings[0].getTotalRuns() < bowllingTeam.getTotalRuns()){
                    bowllingTeam.isWinner = true;
                }
            }
            innings[inning-1] = inningDetails;
            //print inning details
            System.out.println();
            System.out.println("Inning: "+inning+" --total runs: "+battingTeam.getTotalRuns());
            System.out.println("---Batting team scorecard: "+battingTeam.getTeamName());
            battingTeam.printBattingScoreCard();
            System.out.println();
            System.out.println("Inning: "+inning+" --total runs: "+bowllingTeam.getTotalRuns());
            System.out.println("Bowling team scorecard: "+bowllingTeam.getTeamName());
            bowllingTeam.printBowlingScoreCard();
        }
        System.out.println();
        System.out.println("Winner is");
        if(teamA.isWinner){
            System.out.println(teamA.getTeamName());
        }
        else{
            System.out.println(teamB.getTeamName());
        }


    }
    private Team tossWinner(Team team_A, Team team_B){
        double rand = Math.random();
        if(rand < 0.5){
            return team_A;
        }
        else{
            return team_B;
        }
//        return null;
    }
}
