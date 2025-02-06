package practice.Threads.Seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouse {

    private List<Order> shippingItems;

    private final ExecutorService fulfillmentService;

    public final static String[] PRODUCT_LIST = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};


    public ShoeWarehouse(){
        this.shippingItems = new ArrayList<>();
        fulfillmentService = Executors.newFixedThreadPool(3);
    }

    public void shutDown(){
        fulfillmentService.shutdown();
    }

    public synchronized void receiveOrder(Order product){
        while(shippingItems.size() > 20){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        shippingItems.add(product);
        System.out.println(Thread.currentThread().getName() +  " Incoming: "+ product);
        fulfillmentService.submit(this::fulfillOrder);
        notifyAll();
    }

    public synchronized Order fulfillOrder(){
        while(shippingItems.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Order a = shippingItems.remove(0);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " fulling: " + a);
        return a;
    }
}
