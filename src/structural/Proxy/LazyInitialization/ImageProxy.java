package structural.Proxy.LazyInitialization;

public class ImageProxy implements Image{
    ReaImage realimage;
    String filename;
    public ImageProxy(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        if(realimage == null){
            this.realimage = new ReaImage(filename);
        }
        realimage.display();
    }
}
