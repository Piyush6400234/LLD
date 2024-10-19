package creational.factory.courses;
import java.util.List;
// We have a module interface that declares a method which should be implemented by all the subclass that are
// implementing this module.

// then we have conceptModule, demoModule, exerciseModule, introModule, summaryModule that implements Module interface,
// Each of them implements the method declared by Module interface and also have string that has name of the module

// We have abstract class course that will have two subclasses hld and lld. Course module has a list of modules and
// a method to access that list

// hld and lld modules will implement course module and they will take care of which module should be part of which course

public class Main {
    public static void main(String[] args){

//        Line number 18 to 25 can be moved into a separate class and called as factory class
       String module = "hld";
       course cours;
       if(module.equals("hld")){
           cours = new hld();
       }
       else{
           cours = new lld();
       }
       List<Module> l = cours.getCourses();
       for(Module m : l){
           m.moduleName();
       }
    }
}
