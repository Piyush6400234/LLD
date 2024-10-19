package Behavioral.ChainOfResponsibility.ITSupportHandler;

public class LowLevelSupport extends SupportLevel{

    @Override
    public void handleRequest(String IssueType) {
        if(IssueType.equalsIgnoreCase("basic")){
            System.out.println("Basic low level request is handled!!");
        }
        else{
            if(nextLevel != null) {
                nextLevel.handleRequest(IssueType);
            }
        }
    }
}
