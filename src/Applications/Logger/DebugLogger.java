package Applications.Logger;

public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSubject logSubject){
        msg = "DEBUG: "+msg;
        System.out.println();
        logSubject.notifyAllObservers(level, msg);
    }

}
