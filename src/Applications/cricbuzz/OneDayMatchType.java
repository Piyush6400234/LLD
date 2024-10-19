package Applications.cricbuzz;

public class OneDayMatchType implements MatchType{
    @Override
    public int noOfOvers(){
        return 50;
    }

    @Override
    public int maxOverCountPerBowlers(){
        return 5;
    }
}
