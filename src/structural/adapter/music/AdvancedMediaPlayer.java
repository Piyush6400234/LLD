package structural.adapter.music;
// This is a new library that needs to be supported in our code
// Define the Adaptee Interface (AdvancedMediaPlayer)
// A library or code that plays MP4 and VLC formats, but with a different interface
public interface AdvancedMediaPlayer {
    void playMp4(String fileName);
    void playVlc(String fileName);
}
