package practice.Threads.Twelve;
// Deadlock when there's no consumer and so we did timeout for 10 seconds
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class VisitorList {
    private static final CopyOnWriteArrayList<Person> masterList;
    static {
        masterList = Stream.generate(Person::new)
                .distinct()
                .limit(2500)
                .collect(CopyOnWriteArrayList::new, CopyOnWriteArrayList::add, CopyOnWriteArrayList::addAll);
    }
    private static final ArrayBlockingQueue<Person> newVisitors = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Runnable producer = () -> {
            Person visitor = new Person();
            System.out.println("Queuing "+ visitor);
            boolean queued = false;

            try{
                queued = newVisitors.offer(visitor, 5, TimeUnit.SECONDS);
            }
            catch (InterruptedException e){
                System.out.println("Illegal state Exception.");
            }

            if(queued){
//                System.out.println(
//                        newVisitors
//                );
            }else{
                System.out.println("Queue is full, cannot add "+ visitor);
                System.out.println("writing to file and Draining queue");
                List<Person> tempList = new ArrayList<>();
                newVisitors.drainTo(tempList);

                List<String> lines = new ArrayList<>();
                tempList.forEach((customer) -> lines.add(customer.toString()));
            }
        };

        Runnable consumer = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Polling queue "+ newVisitors.size());
            Person visitor = newVisitors.poll();
            if(visitor != null){
                System.out.println(threadName + " "+ visitor);
                if(!masterList.contains((visitor))){
                    masterList.add(visitor);
                    System.out.println("--> New visitor gets Coupon: "+ visitor);
                }
            }
            System.out.println(threadName+ " done "+newVisitors.size());
        };
        ScheduledExecutorService producerExecutor = Executors.newSingleThreadScheduledExecutor();
        producerExecutor.scheduleWithFixedDelay(producer, 0, 1, TimeUnit.SECONDS);


        ScheduledExecutorService consumerPool = Executors.newScheduledThreadPool(3);
        for(int i = 0; i<3; i++){
            consumerPool.scheduleAtFixedRate(consumer, 6, 3, TimeUnit.SECONDS);
        }


        // Running Producer code
        while(true){
            try{
                if(!producerExecutor.awaitTermination(10, TimeUnit.SECONDS)){
                    break;
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        producerExecutor.shutdown();
        // running Consumer code
        while(true){
            try{
                if(!consumerPool.awaitTermination(3, TimeUnit.SECONDS)){
                    break;
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        consumerPool.shutdown();


    }
}
