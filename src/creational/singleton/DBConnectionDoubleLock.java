package creational.singleton;

public class DBConnectionDoubleLock {
    private static DBConnectionDoubleLock conObj;

    private DBConnectionDoubleLock(){}

    public static DBConnectionDoubleLock getInstance(){
        if(conObj == null){
            synchronized (DBConnectionDoubleLock.class){
                if(conObj == null){
                    conObj = new DBConnectionDoubleLock();
                }
            }
        }
        return conObj;
    }
}
/*
Note: DBConnectionDoubleLock.class is a class level lock, applied to class itself, and not the instance of the class

Since getInstance() is a static method (called on the class, not on an object), and the conObj variable is static, you
need to ensure that only one thread at a time can access the block of code that creates the instance.
And that is what's done by "synchronized (DBConnectionDoubleLock.class)"
 */
