package creational.factory.courses;

public class introModule implements Module{
    private String module;
    public introModule(String name){
        this.module = name;
    }
    @Override
    public void moduleName(){
        System.out.println(module+" accessed");

    }
}
