package practice.Threads.Two;
// when a thread is interrupted and catched we need to call interrupt on the same method again from catch block as
// in "thread" Thread given below.
public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread running");
        try {
            System.out.println("Main thread paused for one second.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname+ " should take 10 dots to run. ");
            for(int i = 0; i<10; i++){
                System.out.print(". ");
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    System.out.println("Ohh! "+ tname + " was interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + tname + " completed execution successfully.");
        });

        Thread installThread = new Thread(() -> {
            try{
                for(int i = 0; i<3; i++){
                    Thread.sleep(250);
                    System.out.println("Installation step + " + i+1 +" is completed.");
                }

            }
            catch(InterruptedException e){
        e.printStackTrace();
            }
        }, "InstallThread");



        Thread threadMonitor = new Thread(() -> {

            long now = System.currentTimeMillis();

            while (thread.isAlive()){
                try{
                    Thread.sleep(1000);
                    if(System.currentTimeMillis() - now > 8000){
                        thread.interrupt();
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });


        System.out.println(thread.getName() + " starting. " +"state "+ thread.getState());
        thread.start();
        threadMonitor.start();


        try {
            thread.join(); // will join this thread to current thread, which in this case is the Main thread. sort of dependency on main thread. Main thread will wait here until this thread is complete.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if(!thread.isInterrupted()){
            installThread.start();
        }
        else {
            System.out.println("Previous thread was interrupted, "+ installThread.getState() + " can't run.");
        }


    }
}
