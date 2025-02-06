package practice.Threads.Three;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        EvenPrinterSubclass even = new EvenPrinterSubclass();

        Thread oddPrinter = new Thread(new OddPrinterSubclass());
        even.start();
        oddPrinter.start();

        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        oddPrinter.interrupt();


        Runnable runnable  = () -> {
            for(int i = 0; i<11; i++){
                if(i%2 == 0){
                    System.out.println("even number is: "+ i);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("EvenRunnable interrupted.");
                }
            }
        };

        Thread evenRunnable = new Thread(runnable);
        evenRunnable.start();
    }
}
