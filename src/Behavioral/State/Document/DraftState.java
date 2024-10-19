package Behavioral.State.Document;
// Concrete States
public class DraftState implements State{
    @Override
    public void handleRequest(){
        System.out.println("Document is in Draft state. You can edit it.");
    }

    @Override
    public void cancelRequest(){
        System.out.println("Document draft state is canceled. you can't edit.");
    }
}
