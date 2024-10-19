package structural.adapter.music;
// Define the Target Interface (MediaPlayer)
// The interface the client expects, which can only play MP3.
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
