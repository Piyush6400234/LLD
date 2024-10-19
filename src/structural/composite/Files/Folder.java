package structural.composite.Files;

import java.util.List;
import java.util.ArrayList;

public class Folder implements FileSystem{
    private String name;
    private List<FileSystem> contents = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addFile(FileSystem fileSystem){
        contents.add(fileSystem);
    }

    public void removeFile(FileSystem fileSystem){
        contents.remove(fileSystem);
    }

    @Override
    public void ShowDetails(){
        System.out.println("Folder: "+name);
        for (FileSystem fileSys: this.contents){
            fileSys.ShowDetails();
        }
    }
}
