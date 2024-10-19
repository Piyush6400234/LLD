package Behavioral.Command.AirConditionerWithUndo;

public class turnOnCommand implements Command{
    private AC ac;

    public turnOnCommand(AC ac){
        this.ac = ac;
    }
    @Override
    public void execute(){
        // A series of other method calls on A.C
        ac.turnOn();
        ac.setTemperature(16);
    }

    @Override
    public void undo(){
        // Undo those series of method calls on A.C that were done in execute command
        ac.turnOff();
        ac.setTemperature(0);
    }

}
