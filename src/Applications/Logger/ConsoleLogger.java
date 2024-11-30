package Applications.Logger;

public class ConsoleLogger implements LogObserver{
    @Override
    public void log(String msg){
        System.out.println("Write to console: "+msg);
    }
}
