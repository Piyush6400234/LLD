package Behavioral.Command.AirConditionerWithUndo;

public class turnOffCommand implements Command{
    private AC ac;

    public turnOffCommand(AC ac){
        this.ac = ac;
    }

    @Override
    public void execute(){
        ac.turnOff();
        ac.setTemperature(0);
    }

    @Override
    public void undo(){
        ac.setTemperature(16);
    }
}
