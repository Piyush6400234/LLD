package practice.Threads.Three;

import java.util.concurrent.TimeUnit;

public class OddPrinterSubclass implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i<=11; i++){
            if(i%2 != 0){
                System.out.println("Odd number "+ i);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("OddRunnable interrupted.");
            }
        }
    }
}
