package structural.Facade.HomeTheater;

public class HomeTheaterFacade {
    public DVDPlayer dvdplayer;
    public Lights lights;
    public Projector projector;
    public SoundSystem soundsystem;

    public HomeTheaterFacade(DVDPlayer dvdplayer, Lights lights, Projector projector, SoundSystem soundsystem){
        this.dvdplayer = dvdplayer;
        this.lights = lights;
        this.projector = projector;
        this.soundsystem = soundsystem;
    }
    public void watchMovie(String movie){
        System.out.println("starting your movie");
        lights.dim();
        projector.turnOn();
        soundsystem.turnOn();
        soundsystem.setVolume(9);
        dvdplayer.turnOn();
        dvdplayer.play(movie);
    }
    public void endMovie(){
        System.out.println("shutting Down the movie theater");
        dvdplayer.stop();
        dvdplayer.turnOff();
        soundsystem.setVolume(0);
        soundsystem.turnOff();
        projector.turnOff();
        lights.brighten();
    }
}
