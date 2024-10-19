package structural.Proxy.ProtectionProxy;
// RealSubject: Actual file access class
public class RealFileAccess implements FileAccess{
    String fileName;

    public RealFileAccess(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void readFile(){
        System.out.println("Reading file:: " + fileName);
    }

    @Override
    public void deleteFile(){
        System.out.println("Deleting file:: " + fileName);
    }
}