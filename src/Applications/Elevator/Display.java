package Applications.Elevator;

public class Display {
    ElevatorState elevatorState;
    ElevatorDirection elevatorDirection;
    int currFloor;
    int elevatorID;

    public void showDisplay(){
        System.out.println("Elevator : "+elevatorID+ " is in "+ elevatorState.name() +" state ");
        if(elevatorDirection != null){
            System.out.println("Moving in direction: "+elevatorDirection.name());
        }
    }
    public void setCurrFloor(int currFloor) {
        this.currFloor = currFloor;
    }
    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }
    public void setElevatorID(int elevatorID) {
        this.elevatorID = elevatorID;
    }
    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }
}