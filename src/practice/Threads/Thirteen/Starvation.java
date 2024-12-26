package practice.Threads.Thirteen;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Occurs when one thread is unable to obtain the resource it needs, to execute, usually caused by other concurrent threads
being greedy, some threads making progress, while others can't


Options:
Monitor locks (synchronized method) is always unfair
reentrant lock can be fair or unfair, depending on the implementations
 */
public class Starvation {
    private static final Lock lock = new ReentrantLock(true);// fairness policy true else greedy lock
    public static void main(String[] args) {

        Callable<Boolean> thread  = () ->{
          String threadName = Thread.currentThread().getName();
          int threadno = Integer.parseInt(
                  threadName.replaceAll(".*-[1-9]*-.*-", "")
          );
          boolean keepGoing = true;

          while (keepGoing){
              lock.lock();
              try{
                  System.out.println(threadno+  " acquired the lock" );
                  TimeUnit.SECONDS.sleep(1);
              }
              catch (InterruptedException e){
                  System.out.printf("Shutting down %d%n", threadno);
                  Thread.currentThread().interrupt();
                  return false;
              }
              finally{
                  lock.unlock();
              }
          }
          return true;
        };


        var executor = Executors.newFixedThreadPool(3);
        try{
            var futures = executor.invokeAll(
                    List.of(thread, thread, thread), 10, TimeUnit.SECONDS
            );
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        executor.shutdownNow();
    }
}
