package Behavioral.Iterator.AmazonInventory;

public interface Iterator {
    Product first();
    Product next();
    boolean hasNext();
}
