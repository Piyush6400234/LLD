package Applications.Logger;

import java.util.ArrayList;
import java.util.*;

public class LogSubject {
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    void addObserver(int level, LogObserver logObserver){
        List<LogObserver> val = logObservers.getOrDefault(level, new ArrayList<>());
        val.add(logObserver);
        logObservers.put(level, val);
    }

    void notifyAllObservers(int level, String msg){
        List<LogObserver> channel = logObservers.get(level);
        for(LogObserver logObserver: channel){
            logObserver.log(msg);
        }

    }
}
