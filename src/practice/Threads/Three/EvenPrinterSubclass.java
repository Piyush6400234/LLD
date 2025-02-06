package practice.Threads.Three;

import java.util.concurrent.TimeUnit;

public class EvenPrinterSubclass extends Thread{

    @Override
    public void run(){
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
    }
}
