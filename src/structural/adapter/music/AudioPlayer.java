package structural.adapter.music;
// Create the Concrete Implementation of the Target Interface (AudioPlayer)
// This class can be skipped but in Main we will have to make one object for MediaAdapter and an object of
//concrete class playing MP3 implemented on MediaPlayer class
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("playing mp3 file: " + fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else {
            System.out.println("Invalid file type: " + audioType);
        }
    }
}