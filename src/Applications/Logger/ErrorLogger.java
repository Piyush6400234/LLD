package Applications.Logger;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSubject logSubject){
        msg = "ERROR: "+msg;
        System.out.println(msg);
        logSubject.notifyAllObservers(level, msg);
    }
}