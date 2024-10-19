package creational.factory.courses;

public class lld extends course{
    @Override
    public void createCourses(){
        System.out.println("lld course created");
        modules.add(new conceptModule("conceptmodule"));
        modules.add(new exerciseModule("exercisemodule"));
    }
}
