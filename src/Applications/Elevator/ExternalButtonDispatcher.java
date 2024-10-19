package Applications.Elevator;

import java.util.*;

public class ExternalButtonDispatcher {
    private List<ElevatorController> controllers;
    public ExternalButtonDispatcher(List<ElevatorController> lis){
        this.controllers = new ArrayList<>();
        this.controllers = lis;
    }
    public void submitExternalRequest(int destFloor, ElevatorDirection direction){
        for(ElevatorController controller: controllers){
            int elevatorID = controller.getElevator().getElevatorID();
            if(elevatorID%2 == 1 && destFloor%2 == 1){
                controller.submitExternalRequest(destFloor, direction);
            }
            else if(elevatorID%2 == 0 && destFloor%2 == 0){
                controller.submitExternalRequest(destFloor, direction);
            }
        }

    }
}