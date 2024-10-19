package Behavioral.ChainOfResponsibility.ITSupportHandler;

public class MidLevelSupport extends SupportLevel{

    @Override
    public void handleRequest(String IssueType) {
        if(IssueType.equalsIgnoreCase("intermediate")){
            System.out.println("Intermediate level request is handled here!!!");
        }
        else{
            if(nextLevel!=null){
                nextLevel.handleRequest(IssueType);
            }
        }
    }
}
