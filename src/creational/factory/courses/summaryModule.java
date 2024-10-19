package creational.factory.courses;

public class summaryModule implements Module{
    private String module;
    public summaryModule(String name){
        this.module = name;
    }
    @Override
    public void moduleName(){
        System.out.println(module+" accessed");

    }
}
