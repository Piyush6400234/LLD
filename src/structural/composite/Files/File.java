package structural.composite.Files;

public class File implements FileSystem{
    private String name;

    public File(String name){
        this.name = name;
    }
    @Override
    public void ShowDetails(){
        System.out.println("File: " + this.name);
    }
}
