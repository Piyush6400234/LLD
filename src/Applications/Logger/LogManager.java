package Applications.Logger;

// responsibility of this class is to build the chain
public class LogManager {
    protected static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new InfoLogger(3);

        errorLogger.setNextLoggingLevel(debugLogger);
        infoLogger.setNextLoggingLevel(errorLogger);
        return infoLogger;
    }
    protected static LogSubject buildSubject(){

        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();
        DBLogger dbLogger = new DBLogger();

        logSubject.addObserver(1, consoleLogger);
        logSubject.addObserver(2, fileLogger);
        logSubject.addObserver(2, dbLogger);
        logSubject.addObserver(3, fileLogger);

        return logSubject;
    }

}
