package structural.Facade.HomeTheater;

public class DVDPlayer {
    public void turnOn(){
        System.out.println("Turning on DVD player");
    }
    public void play(String movie){
        System.out.println("Playing Movie: " + movie);
    }
    public void stop(){
        System.out.println("Stopping DVD player");
    }
    public void turnOff(){
        System.out.println("Turning off DVD player");
    }
}
