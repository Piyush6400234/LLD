package Applications.Elevator;
import java.util.*;
public class InternalButtonDispatcher {
    private List<ElevatorController> controllers;
    public InternalButtonDispatcher(List<ElevatorController> controllers){
        controllers = new ArrayList<>();
        this.controllers = controllers;
    }
    public void submitInternalRequest(int dest, Elevator elevator){ // Here we can have different strategies to submit req.
        for(ElevatorController controller: controllers){
            if(controller.getElevator() == elevator){
                if(elevator.getCurrentFloor()>dest){
                    controller.submitInternalRequest(dest, ElevatorDirection.DOWN);
                }
                else if(elevator.getCurrentFloor()<dest){
                    controller.submitInternalRequest(dest, ElevatorDirection.UP);
                }
            }
        }
    }
}