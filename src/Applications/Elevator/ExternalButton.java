package Applications.Elevator;

public class ExternalButton {
    private ExternalButtonDispatcher dispatcher;
    public ExternalButton(ExternalButtonDispatcher dispatcher){// each external Button has a dispatcher and there is only one external dispatcher.
        this.dispatcher = dispatcher;
    }
    public void pressButton(int currFloor, ElevatorDirection direction){
        dispatcher.submitExternalRequest(currFloor, direction);
    }
}