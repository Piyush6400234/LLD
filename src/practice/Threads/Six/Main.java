package practice.Threads.Six;
/*
Downsides of Intrinsic locks sing synchronized method:

1). There's no way to test if the intrinsic lock has already been acquired.
2). There's no way to interrupt a blocked thread.
3). There is not an easy way to debug, or examine the intrinsic lock.
4). The intrinsic lock is an exclusive lock.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

class MessageRepository{
    private String message;
    private boolean hasMessage = false;

    private final Lock lock = new ReentrantLock();

    public String read(){

//        lock.lock();
        if(lock.tryLock()) {
            try {
                while (!hasMessage) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                hasMessage = false;
            } finally {
                lock.unlock();
            }
        }
        else{
            System.out.println("Reads blocked. "+ lock);
            hasMessage = false;
        }

        return message;
    }

    public void write(String message){
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    while (hasMessage) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    hasMessage = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Write blocked. "+lock);
                hasMessage = true;
            }
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        this.message = message;

    }

}

class MessageWriter implements Runnable {
    private MessageRepository outgoingMessage;

    private final String text = """
            Humpty Dumpty sat on a wall,
            Humpty Dumpty had a great fall,
            ALl the  king's horses and all the king's men,
            Couldn't put Humpty together again.""";

    public MessageWriter(MessageRepository outgoingMessage) {
        this.outgoingMessage = outgoingMessage;
    }

    @Override
    public void run(){

        Random random = new Random();
        String[] lines = text.split("\n");
        for(int i = 0; i< lines.length; i++){
            outgoingMessage.write(lines[i]);
            try{
                Thread.sleep(random.nextInt(500, 2000));
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        outgoingMessage.write("Finished");

    }
}


class MessageConsumer implements Runnable {
    private MessageRepository incomingMessage;

    public MessageConsumer(MessageRepository incomingMessage){
        this.incomingMessage = incomingMessage;
    }

    @Override
    public void run(){
        Random random = new Random();
        String latestMessage = "";

        do{
            try{
                try {
                    Thread.sleep(random.nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            catch (RuntimeException e){
                throw new RuntimeException(e);
            }
            latestMessage = incomingMessage.read();
            System.out.println(latestMessage);
        }
        while(!latestMessage.equals("Finished"));
    }
}

public class Main {
    public static void main(String[] args) {
        MessageRepository messageRepository = new MessageRepository();

        Thread reader = new Thread(new MessageConsumer(messageRepository), "reader");
        Thread writer = new Thread(new MessageWriter(messageRepository), "writer");

        writer.setUncaughtExceptionHandler((thread, exc) -> {
            System.out.println("writer had exception: "+ exc);
            if(reader.isAlive()){
                System.out.println("Going to interrupt the reader.");
                reader.interrupt();
            }
        });


        reader.setUncaughtExceptionHandler((thread, exc) -> {
            System.out.println("writer had exception: "+ exc);
            if(writer.isAlive()){
                System.out.println("Going to interrupt the reader.");
                writer.interrupt();
            }
        });

        reader.start();
        writer.start();


    }
}
