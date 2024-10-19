package Applications.Elevator;
import java.util.*;

public class ElevatorController {
    private Elevator elevator;
    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;

    public ElevatorController(Elevator elevator){
        this.elevator = elevator;
        this.minPQ = new PriorityQueue<>();
        this.maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void submitExternalRequest(int dest, ElevatorDirection direction){
        if(direction == ElevatorDirection.UP){
            minPQ.add(dest);
        }
        else if(direction == ElevatorDirection.DOWN){
            maxPQ.add(dest);
        }

    }
    public void submitInternalRequest(int dest, ElevatorDirection direction){
        if(direction == ElevatorDirection.UP){
            minPQ.add(dest);
        }
        else if(direction == ElevatorDirection.DOWN){
            maxPQ.add(dest);
        }
    }
    public void controlElevator(ElevatorDirection direction, int destination){

    }

    public Elevator getElevator(){
        return this.elevator;
    }
}
