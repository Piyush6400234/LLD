package creational.factory.courses;

public class exerciseModule implements Module {
    private String module;
    public exerciseModule(String name){
        this.module = name;
    }
    @Override
    public void moduleName(){
        System.out.println(module+" accessed");

    }
}
