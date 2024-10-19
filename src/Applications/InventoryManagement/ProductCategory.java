package Applications.InventoryManagement;

import java.util.*;

public class ProductCategory {
    int categoryId;
    List<Product> productList;
    String categoryName;
    double price;

    public ProductCategory(String categoryName){
        this.categoryId = (int)(Math.random()*9000)+1000;
        productList = new ArrayList<>();
        this.categoryName = categoryName;
        this.price = 0.0;
    }

    public void addCategory(Product product) {
        this.productList.add(product);
    }
    public void removeProduct(int count){
        for(int i = 0; i<count && !productList.isEmpty(); i++){
            productList.remove(0);
        }
    }
    public double calculateTotal(){
        return productList.size()*price;
    }
}