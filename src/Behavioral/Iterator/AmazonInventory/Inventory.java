package Behavioral.Iterator.AmazonInventory;

import java.util.ArrayList;
import java.util.List;

// iterator collection - here we're directly implementing it, instead of implementing collection interface.
public class Inventory {
    private List<Product> products;

    public Inventory(){
        this.products = new ArrayList<>();
    }

    public void addItems(Product product){
        this.products.add(product);
    }

    public ProductIterator getIterator(){
        return new ProductIterator(this.products);
    }
    public ProductReverseIterator getReverseIterator(){
        return new ProductReverseIterator((this.products));
    }

}