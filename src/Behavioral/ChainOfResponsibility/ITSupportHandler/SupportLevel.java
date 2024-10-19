package Behavioral.ChainOfResponsibility.ITSupportHandler;

// Handler interface

public abstract class SupportLevel {
    protected SupportLevel nextLevel;

    public void setNexSupportLevel(SupportLevel nextLevel){
        this.nextLevel = nextLevel;
    }

    public abstract void handleRequest(String IssueType);
}