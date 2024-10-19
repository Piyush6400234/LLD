package Behavioral.State.Document;
//Concrete States
public class PublishedState implements State{

    @Override
    public void handleRequest(){
        System.out.println("Document is in publishing state. wait for its completion.");
    }
    @Override
    public void cancelRequest(){
        System.out.println("Document could not be published. ");
    }
}
