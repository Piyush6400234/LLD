package creational.factory.courses;

public class demoModule implements Module{
    private String module;
    public demoModule(String name){
        this.module = name;
    }
    @Override
    public void moduleName(){
        System.out.println(module+" accessed");

    }
}
