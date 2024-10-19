package creational.singleton;
/*
Instead of creating object at load time like in Eager method, here we'll create the connection only when needed
If there's a requirement then only create connection

*/
public class DBConnectionLazyInit {
    private static DBConnectionLazyInit conObject; // by default it's initialized with a null value

    private DBConnectionLazyInit(){
    }

    public static DBConnectionLazyInit getInstance(){
        if(conObject == null) { // initialize only when needed.
            conObject = new DBConnectionLazyInit();
        }
            return conObject;
    }
}
/*
PROBLEM:
    If two different thread comes at a point of time, both will see if(conObject == null), and we'll have two objet
    created in Memory

Solution:
We solve it through synchronized method
 */