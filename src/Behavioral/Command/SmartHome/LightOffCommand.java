package Behavioral.Command.SmartHome;
// Concrete Command: Turn Light Off
public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){ // or we can directly pass the object here
        light.turnOff();
    }
}
