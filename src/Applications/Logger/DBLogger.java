package Applications.Logger;

public class DBLogger implements LogObserver{
    @Override
    public void log(String msg){
        System.out.println("Write to DB: "+msg);
    }
}
