package practice.Threads.One;

public class CustomRunnable implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.print(" 5 ");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
