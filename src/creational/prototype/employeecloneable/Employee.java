package creational.prototype.employeecloneable;

import java.util.ArrayList;

public class Employee implements Prototype{
    private int id;
    private String name;
    private String department;
    private ArrayList<String> courses;
    public Employee(int id, String name, String department, ArrayList<String> course){
        this.id = id;
        this.name = name;
        this.department = department;
        this.courses = course;
    }
    public String getName(){
        return this.name;
    }
    public String getDept(){
        return this.department;
    }
    public ArrayList<String> getCourse(){
        return this.courses;
    }
    public void addCourse(String c){
        this.courses.add(c);
    }
    @Override
    public Prototype clone() throws CloneNotSupportedException{
//        Employee empClone =  (Employee) super.clone(); // This creates a new Employee object with the same references to the original object's attributes.
        //We then explicitly deep copy the primitive attributes
        ArrayList<String> newc = new ArrayList<>(this.courses);
        Prototype empClone = new Employee(this.id, this.name, this.department, newc);
//        empClone.id = this.id;
//        empClone.name = this.name;
//        empClone.department = this.department;
        return empClone;
    }
}
