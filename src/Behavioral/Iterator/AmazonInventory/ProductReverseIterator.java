package Behavioral.Iterator.AmazonInventory;

import java.util.List;

public class ProductReverseIterator implements Iterator{
    private List<Product> products;
    private int rpos;

    public ProductReverseIterator(List<Product> products){
        this.products = products;
        rpos = products.size()-1;
    }
    @Override
    public Product first(){
        if(products.isEmpty()){
            return null;
        }
        else{
            int len = products.size();
            this.rpos = len-1;
            return products.get(len-1);
        }
    }
    @Override
    public boolean hasNext(){
        return rpos >=0;
    }
    @Override
    public Product next(){
        if(hasNext()){
            return products.get(rpos--);
        }
        return null;
    }
}