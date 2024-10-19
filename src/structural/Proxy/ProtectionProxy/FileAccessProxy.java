package structural.Proxy.ProtectionProxy;
// Proxy class that controls access based on user role
public class FileAccessProxy implements FileAccess{
    String role;
    RealFileAccess realFileAccess;

    public FileAccessProxy(String fileName, String role){
        this.role = role;

        this.realFileAccess = new RealFileAccess(fileName);
    }

    @Override
    public void readFile(){
        realFileAccess.readFile();
    }

    @Override
    public void deleteFile(){

        if(role.equalsIgnoreCase("admin")){
            realFileAccess.deleteFile();
        }
        else{
            System.out.println("Not Authorised to delete");
        }
    }
}
