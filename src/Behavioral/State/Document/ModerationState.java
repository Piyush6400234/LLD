package Behavioral.State.Document;
// Concrete States
public class ModerationState implements State{
    @Override
    public void handleRequest(){
        System.out.println("Document is in Moderation state. Waiting for approval.");
    }

    @Override
    public void cancelRequest(){
        System.out.println("Document moderation is canceled. request canceled");

    }
}
