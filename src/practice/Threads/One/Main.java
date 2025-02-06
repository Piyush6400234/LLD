package practice.Threads.One;


import java.sql.Time;
import java.util.concurrent.TimeUnit;

/*
Thread instance can be created in two ways.
1). Extend the thread class, and create an instance of this new subclass
2). Create a new instance of Thread, and pass it any instance that implements the Runnable interface. including passing a
    lambda expression.

run() executes the thread synchronously, that means the thread calling run method on other thread waits for other thread to
finish and then executes rest of the codes. This is not multithreading, but like a normal functional call. No new
thread is created here.

start() executes the thread concurrently, that means the calling thread and called thread runs concurrently. True Multithreading
and this creates a new thread and that new thread calls the run() method on the new thread.


Runnable is a Functional Interface. with run() method as its single access method.

Runnable type is a target for a lambda expression.


* */
public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);

        printThreadState(currentThread);


        CustomThread customThread = new CustomThread();
        customThread.start(); // using Thread class extension

        Runnable myRunnable = () -> {
          for(int i = 1; i<=8; i++){
              System.out.print(" 2 ");
              try{
                  TimeUnit.MILLISECONDS.sleep(250);
              }
              catch (InterruptedException e){
                  e.printStackTrace();
              }
          }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start(); // using Runnable as Functional Interface reference.

        CustomRunnable custom = new CustomRunnable();
        Thread myRunnableThread = new Thread(custom);
        myRunnableThread.start(); // Extending Runnable class and passing the class in the Thread.


        for(int i = 1; i<=3; i++){
            System.out.print(" 0 ");
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void printThreadState(Thread thread){
        System.out.println("-------------------------------------");
        System.out.println("Thread ID: "+ thread.getId());
        System.out.println("Thread Name: "+ thread.getName());
        System.out.println("Thread priority: "+ thread.getPriority());
        System.out.println("Thread State: "+ thread.getState());
        System.out.println("Thread Group: "+thread.getThreadGroup());
        System.out.println("Thread is Alive: "+thread.isAlive());
        System.out.println("--------------------------------------");
    }
}
