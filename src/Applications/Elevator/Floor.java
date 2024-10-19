package Applications.Elevator;

public class Floor {
    private int floorId;
    private ExternalButton externalButton;

    public Floor(int floorId, ExternalButton externalButton){
        this.floorId = floorId;
        this.externalButton = externalButton;
    }
    public ExternalButton getButton(){
        return this.externalButton;
    }
    public void presButton(ElevatorDirection direction){ // If user comes on any floor he has to enter direction he wants to go towards.
        externalButton.pressButton(this.floorId, direction);
    }
}