package creational.factory.courses;

public class hld extends course{
    @Override
    public void createCourses(){
        System.out.println("hld course created");
        modules.add(new introModule("intromodule"));
        modules.add(new demoModule("demomodule"));
        modules.add(new summaryModule("summarymodule"));
    }
}
