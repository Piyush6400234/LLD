package Behavioral.ChainOfResponsibility.ITSupportHandler;

public class HighLevelSupport extends SupportLevel{

    @Override
    public void handleRequest(String IssueType) {
        if(IssueType.equalsIgnoreCase("critical")){
            System.out.println("Critical requests are handled here!!!");
        }
        else {
            if(nextLevel !=null){
                nextLevel.handleRequest(IssueType);
            }
        }
    }
}
