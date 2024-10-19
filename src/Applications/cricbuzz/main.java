package Applications.cricbuzz;

import Applications.cricbuzz.Team.Player.PlayerDetails;
import Applications.cricbuzz.Team.Team;
import Applications.cricbuzz.Team.Player.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
cricbuzz: Multiple matches are going on at a time. After clicking on any match we will be able to see it's scorecard.
    The scorecard should be shown live, ball-by-ball

    Team A Innings                                              97-8 (20 overs)
        Batter                                                  R(runs)   B(total balls played)   4's(no of fours)   6's(no of sixes)   Strike/rate
        TA-p1           b. Tb-p7                                  50        60                      4                       3               2.5
        TA-p2           b. Tb-p6
        TA-p3           not out
        TA-p4           not out

       Bowlers                                          O   M   R   W   NB   WB   Eco
        TB-p7                                           5   1   25  2   0     1
        TB-p6
        TB-p4

    Team B Innings                                              105-4 (19.2 overs)
        Batter                                                  R(runs)   B(total balls played)   4's(no of fours)   6's(no of sixes)   Strike/rate
        TB-p7
------------------------------------------------------------------------------------------------------------------------
Flow::
                                                                 |Player score info bowl by bowl
                                                     Team A Bats--
                                           50 Overs--|
                                            |        Team B Bowls
                            |-> Inning 1-----
2 Teams --> Match played -->
                            |-> Inning 2----
                                            |        Team B Bats
                                           50 Overs--|
                                                     Team A Bowls

Objects:
    1). Match:
    2). Team:
    3). Players(inside team)
    4). Innings(inside match)
    5). Overs(inside innings)
    6). Bowls(inside overs)
    7). Scorecard
*/
public class main {
    public static void main(String[] args) {
    main ob = new main();
    Team team1 = ob.createTeam("INDIA");
    Team team2 = ob.createTeam("AUSTRALIA");
    Match match = new Match(team1, team2, new T20MatchType());
    match.startMatch();

    }

    private Team createTeam(String teamName){
        Queue<PlayerDetails> players = new LinkedList<>();
        PlayerDetails p1 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"1"));
        PlayerDetails p2 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"2"));
        PlayerDetails p3 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"3"));
        PlayerDetails p4 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"4"));
        PlayerDetails p5 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"5"));
        PlayerDetails p6 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"6"));
        PlayerDetails p7 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"7"));
        PlayerDetails p8 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"8"));
        PlayerDetails p9 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"9"));
        PlayerDetails p10 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"10"));
        PlayerDetails p11 = new PlayerDetails(PlayerType.ALLROUNDER, new Person(teamName+"11"));
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        players.add(p11);

        List<PlayerDetails> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(teamName, players, new ArrayList<>(), bowlers);
        return team;
    }
}
