package Behavioral.Iterator.AmazonInventory;
import java.util.*;
public class ProductIterator implements Iterator{
    private List<Product> products;
    private int pos = 0;

    public ProductIterator(List<Product>products){
        this.products = products;
        pos = 0;
    }

    @Override
    public Product first(){
        if(products.isEmpty()){
            return null;
        }
        else{
            pos = 0;
            return products.get(pos);
        }
    }

    @Override
    public boolean hasNext(){
        return pos<=products.size()-1;
    }

    @Override
    public Product next(){
        if(hasNext()){
            return products.get(pos++);
        }
        return null;
    }
}
