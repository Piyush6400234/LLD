package creational.prototype.employeecloneable;

import java.util.ArrayList;

// Method-2:  In Java we have an additional way to clone objects and that is using cloneable interface.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        ArrayList<String> course = new ArrayList<>();
        course.add("devcourse1");
        course.add("devcourse2");
        Employee emp1 = new Employee(1, "piyush", "development", course);
        ArrayList<String> course2 = new ArrayList<>();
        course2.add("Marketcourse1");
        course2.add("Marketcourse2");

        Employee emp2 = new Employee(2, "piyush", "marketing", course2);
        ArrayList<String> c1 = emp1.getCourse();
        for(String cour: c1){
            System.out.println(cour);
        }

        System.out.println(emp1.getName());
        System.out.println(emp1.getDept());

        PrototypeFactory.addPrototype("MARKET", emp2);
        PrototypeFactory.addPrototype("DEV", emp1);

        Employee cloned = (Employee) PrototypeFactory.getClone("MARKET");
        System.out.println(cloned.getDept());

        ArrayList<String> c2 = cloned.getCourse();
        for(String cour: c2){
            System.out.println(cour);
        }
        cloned.addCourse("newcourse");


        ArrayList<String> c3 = emp2.getCourse();
        for(String cour: c3){
            System.out.println(cour);
        }

    }
}
