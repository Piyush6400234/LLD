package structural.Facade.HomeTheater;

public class SoundSystem {
    public void turnOn(){
        System.out.println("Turning on Sound system");
    }
    public void turnOff(){
        System.out.println("Turning off Sound system");
    }
    public void setVolume(int vol){
        System.out.println("setting volume to " + Integer.toString(vol));
    }
}
