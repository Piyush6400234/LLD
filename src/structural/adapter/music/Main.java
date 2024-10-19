package structural.adapter.music;

// Use Case:
// Imagine you're developing a media player that can play MP3 files. You already have a MediaPlayer interface with an
// implementation that plays MP3 files. However, you want to extend the functionality of your media player to support
// other formats, such as MP4 and VLC, without modifying the existing code.

//The Adaptee Interface (AdvancedMediaPlayer) allows us to define a common contract for different media
// players (Mp4Player, VlcPlayer, etc.) that have varying behaviors but serve a similar purpose (playing media).
// This abstraction decouples the client (in this case, the AudioPlayer using the MediaAdapter) from knowing the details
// of these individual implementations. e.g Mp4Player knows how to play MP4 files but does nothing for VLC files.(SRP)

// If there was no any additional format that needed to be adopted then there is no need of target or adaptee interface.






public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("AOV", "summertime sadness");
    }
}


// Follow - up questions:
// Why did we create the Target Interface (MediaPlayer)?
// The Target Interface (MediaPlayer) is created to define the common interface that the Client (e.g., AudioPlayer) expects.
// It provides a standardized way to interact with the media players without caring about the specific format being played.
// Here's why it's important:
// Abstraction: The MediaPlayer interface abstracts the details of how media is played. The client (AudioPlayer) only
// interacts with this interface, which makes it easier to change or extend the functionality later without modifying the client.
// Adaptation: The MediaAdapter implements this interface, adapting incompatible formats (like MP4 and VLC) to the client. This allows the client to interact with different media formats using the same MediaPlayer interface, without needing to understand the details of each format.