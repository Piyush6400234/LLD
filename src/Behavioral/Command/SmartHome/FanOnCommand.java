package Behavioral.Command.SmartHome;
// Concrete Command: Start Fan
public class FanOnCommand implements Command{
    private Fan fan;

    public FanOnCommand(Fan fan){
        this.fan = fan;
    }
    @Override
    public void execute(){ // or we can directly pass the object here
        fan.turnOn();
    }
}
