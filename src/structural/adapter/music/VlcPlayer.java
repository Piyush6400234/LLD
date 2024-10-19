package structural.adapter.music;
// Create the Adaptee Implementations
public class VlcPlayer implements AdvancedMediaPlayer{

    public void playMp4(String fileName){}

    public void playVlc(String fileName){
        System.out.println("Playing vlc file: "+ fileName);
    }
}
