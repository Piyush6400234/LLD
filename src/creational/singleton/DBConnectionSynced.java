package creational.singleton;
/*
TO solve issues in LazyInitialization. We'll put a lock on the method that creates connection.
We used synchronized keyword on method signature
 */
public class DBConnectionSynced {
    private static DBConnectionSynced conObj;

    private DBConnectionSynced(){

    }
    synchronized public DBConnectionSynced getInstance(){
        if(conObj == null){
            conObj = new DBConnectionSynced();
        }
        return conObj;
    }
}
/*
PROBLEM: It's expensive.
Everytime a new request comes it will put a lock on the getInstance function.
Let's say 1000 requests comes, it will put Lock 1000 times.
And since each lock is expensive it's not scalable.

Solution: Double Lock

 */