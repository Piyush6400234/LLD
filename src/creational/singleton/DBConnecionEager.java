package creational.singleton;

/*
No matter if user needs connection or not a connection will be created at load time.
Here we'll make the class constructor as private so that, it can't be called from outside.
Also, we use static variable both to store the connection object as well as for calling getInstance(So that we do not need to create a class instance)

*/
public class DBConnecionEager {

    private static DBConnecionEager conn= new DBConnecionEager(); // A connection is created at load time, no matter whether user needs it or not
    private DBConnecionEager(){
    }
    public static DBConnecionEager getInstance(){
        System.out.println("Returning once created connection");
        return conn;
    }
}