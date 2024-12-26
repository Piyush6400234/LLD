package practice.Threads.Thirteen;

import structural.composite.Files.File;

// Deadlock
// solution all threads should acquire locks on resources in same order, see, commented out code for thread-B it's
// locking order is same as in Thread-A
// New code in Thread-B has same order as in Thread-A
public class Deadlock {
    public static void main(String[] args) {

        File resourceA = new File("inputData.csv");
        File resourceB = new File("outputData.json");


        Thread threadA = new Thread(()->{
           String threadName = Thread.currentThread().getName();
            System.out.println(threadName+ " attempting to lock resourceA (csv)");

            synchronized (resourceA){
                System.out.println(threadName + " has lock on resourceA (csv)");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(threadName + "NEXT attempting to locak resourceB (json), "+ "Still has lock on resourceA (csv).");
                synchronized (resourceB){
                    System.out.println(threadName + " has lock on resourceB (json)");
                }
                System.out.println(threadName + " has released lock on resourceB (json)");
            }
            System.out.println(threadName + " has released lock on resourceA (csv)");

        }, "THREAD-A");

        Thread threadB = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+ " attempting to lock resourceA (csv)");

            synchronized (resourceA){
                System.out.println(threadName + " has lock on resourceA (csv)");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(threadName + "NEXT attempting to locak resourceB (json), "+ "Still has lock on resourceA (csv).");
                synchronized (resourceB){
                    System.out.println(threadName + " has lock on resourceB (json)");
                }
                System.out.println(threadName + " has released lock on resourceB (json)");
            }
            System.out.println(threadName + " has released lock on resourceA (csv)");
        }, "THREAD-B");

//        Thread threadB = new Thread(() -> { // lock should be orde
//           String threadName = Thread.currentThread().getName();
//            System.out.println(threadName + " attempting lock resourceB (json)");
//            synchronized (resourceB){
//                System.out.println(threadName + " has lock on resourceB (json)");
//                try{
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println("NEXT attempting to lock resourceA (csv), "+ "still has lock on resoueceB (json)");
//
//                synchronized (resourceA){
//                    System.out.println(threadName + " has lock on resourceA (csv)");
//                }
//                System.out.println("releases lock on resourceA (csv)");
//            }
//            System.out.println(threadName + " has released lock on resourceB (json)");
//        }, "THREAD-B");


        threadA.start();
        threadB.start();

        try{
            threadA.join();
            threadB.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
