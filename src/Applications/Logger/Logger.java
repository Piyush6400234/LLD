package Applications.Logger;

public class Logger {
    private volatile static Logger loggerObject;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;

    private Logger(){
        if(loggerObject != null){
            throw new IllegalStateException("Object already created");
        }
    }
    public static Logger getInstance(){
        if(loggerObject == null){
            synchronized (Logger.class){
                if(loggerObject == null){
                    loggerObject = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                    logSubject = LogManager.buildSubject();
                }
            }
        }
        return loggerObject;
    }
    private void createMessage(int level, String msg){
        chainOfLogger.logMessage(level, msg, logSubject);
    }
    public void into(String msg){
        createMessage(1, msg);
    }
    public void error(String msg){
        createMessage(2, msg);
    }
    public void debug(String msg){
        createMessage(3, msg);
    }
}