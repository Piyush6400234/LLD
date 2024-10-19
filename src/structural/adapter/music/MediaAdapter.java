package structural.adapter.music;

// Create the Adapter (MediaAdapter)
public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advacedMediaPlayer; // an instance of adaptee class
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advacedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advacedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audiotype, String fileName){
        if(audiotype.equalsIgnoreCase("vlc")){
            advacedMediaPlayer.playVlc(fileName);
        } else if (audiotype.equalsIgnoreCase("mp4")) {
            advacedMediaPlayer.playMp4(fileName);
        }
    }
}
