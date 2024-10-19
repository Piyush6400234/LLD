package Behavioral.Command.AirConditionerWithUndo;

public class AC {
    private String status;
    private int temperature;

    public void turnOn(){
        System.out.println("Turning on A.C");
        this.status = "on";
    }

    public void turnOff(){
        System.out.println("Turning off A.c");
        this.status = "off";
    }
    public void setTemperature(int temp){
        System.out.println("Setting temperatire to: "+temp);
        this.temperature = temp;
    }
}