package structural.Proxy.LazyInitialization;
// RealSubject: This class represents the actual object to be used
public class ReaImage implements Image{
    String filename;

    public ReaImage(String filename){
        this.filename = filename;
        loadFromDisk(); // Simulate time-consuming loading
    }

    // Simulate loading an image from disk (time-consuming operation), it may involve DB connection or SQL Query execution.
    public void loadFromDisk(){
        System.out.println("Loading from image from disk:: "+ filename);
    }

    @Override
    public void display(){
        System.out.println("Displaying image:: " + filename);
    }
}
