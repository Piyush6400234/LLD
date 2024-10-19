package Behavioral.State.Document;
// Context class
public class DocumentContext {
    private State currState;
    // Initial state is Draft
    public DocumentContext(){
        this.currState = new DraftState();
    }

    public void setCurrState(State state){
        this.currState = state;
    }

    public void applyState(){
        currState.handleRequest();
    }

    public void cancelState(){
        currState.cancelRequest();
    }
}
