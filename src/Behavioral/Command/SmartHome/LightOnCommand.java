package Behavioral.Command.SmartHome;
// Concrete Command: Turn Light On
public class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){ // or we can directly pass the object here
        light.turnOn();
    }
}
