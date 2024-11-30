package Applications.Logger;

public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSubject logSubject){
        msg = "INFO: "+msg;
        System.out.println(msg);
        logSubject.notifyAllObservers(level, msg);
    }
}
