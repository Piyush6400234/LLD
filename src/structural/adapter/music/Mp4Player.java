package structural.adapter.music;

public class Mp4Player implements AdvancedMediaPlayer {

    public void playMp4(String fileName){
        System.out.println("playing Mp4 file: "+ fileName);
    }
    public void playVlc(String fileName){}
}
