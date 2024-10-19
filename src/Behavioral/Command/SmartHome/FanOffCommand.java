package Behavioral.Command.SmartHome;
// Concrete Command: Stop Fan
public class FanOffCommand implements Command{
    private Fan fan;
    public FanOffCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute(){ // or we can directly pass the object here
        fan.turnOff();
    }
}
