package Applications.Elevator;

public class Elevator {
    private int id;
    private Display display;
    private ElevatorDirection elevatorDirection;
    private ElevatorState elevatorState;
    private int currentFloor;
    private InternalButton internalButton;
    private ElevatorDoor door;

    public Elevator(int id, InternalButton button){
        this.internalButton = button;
        this.id = id;
    }
    public void showDisplay(){
        this.display.showDisplay();
    }
    public boolean move(ElevatorDirection direction, int destFloor){
        int startFloor = this.currentFloor;
        if(direction == ElevatorDirection.UP){
            for(int i = startFloor; i<=destFloor; i++){
                this.currentFloor = i;
                display.setCurrFloor(i);
                display.setElevatorDirection(ElevatorDirection.UP);
                display.setElevatorState(ElevatorState.MOVING);
                display.showDisplay();
                if(i == destFloor)return true;
            }
        }
        if(direction == ElevatorDirection.DOWN){
            for(int i = startFloor; i>=destFloor; i--){
                this.currentFloor = i;
                display.setElevatorDirection(ElevatorDirection.DOWN);
                display.setCurrFloor(i);
                display.setElevatorState(ElevatorState.MOVING);
                display.showDisplay();
                if(i == destFloor)return true;
            }
        }
        return false;
    }
    public int getElevatorID(){
        return this.id;
    }
    public InternalButton getInternalButton(){
        return this.internalButton;
    }
    public int getCurrentFloor(){
        return this.currentFloor;
    }
    public ElevatorState getCurrentState(){
        return this.elevatorState;
    }
    public ElevatorDirection getDirection(){
        return this.elevatorDirection;
    }
}