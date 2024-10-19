package Applications.cricbuzz;

public class T20MatchType implements MatchType{

    @Override
    public int noOfOvers(){
        return 20;
    }

    @Override
    public int maxOverCountPerBowlers(){
        return 3;
    }
}