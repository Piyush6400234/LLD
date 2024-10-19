package creational.factory.courses;

public class conceptModule implements Module{
    private String module;
    public conceptModule(String name){
        this.module = name;
    }
    @Override
    public void moduleName(){
        System.out.println(module+" accessed");
    }
}
