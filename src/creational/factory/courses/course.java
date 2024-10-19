package creational.factory.courses;

import java.util.ArrayList;
import java.util.List;
public abstract class course {
    protected List<Module> modules = new ArrayList<>();
    public course(){
         this.createCourses();
    }
    public List<Module> getCourses(){
        return modules;
    }
    public abstract void createCourses();

}
