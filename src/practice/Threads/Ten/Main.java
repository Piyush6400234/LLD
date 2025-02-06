package practice.Threads.Ten;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength, 1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = "+ sum);

        ForkJoinPool threadpool = ForkJoinPool.commonPool();
        List<Callable<Long>> tasks = new ArrayList<>();

        int taskNo = 10;
        int splitCount = numbersLength / taskNo;
        for(int i = 0; i< taskNo; i++){
            int start = i * splitCount;
            int end = start + splitCount;
            tasks.add(() -> {
                long tasksum = 0;
                for(int j = start; j<end; j++){
                    tasksum += (long) numbers[j];
                }
                return tasksum;
            });

        }
        List<Future<Long>> futures = null;
        try {
            futures = threadpool.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("CPUs: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Parallelism = " + threadpool.getParallelism());
        System.out.println("Pool size = " + threadpool.getPoolSize());
        System.out.println("Steal count = " + threadpool.getStealCount());
        long tasksum = 0;
        for(Future<Long> future: futures){
            try {
                tasksum+= future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread Pool Sum = "+ tasksum);

        threadpool.shutdown();
        System.out.println(threadpool.getClass().getName());

    }
}
