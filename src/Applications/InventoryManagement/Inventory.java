package Applications.InventoryManagement;

import java.util.*;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory(){
        this.productCategoryList = new ArrayList<>();
    }
    public void addCategory(int categoryId, String name, double price){
        ProductCategory category = new ProductCategory(name);
        category.categoryId = categoryId;
        category.price = price;
        productCategoryList.add(category);
    }
    public void addProduct(Product product, int categoryId){
        ProductCategory filteredCategory = null;

        for(ProductCategory category: productCategoryList){
            if(category.categoryId == categoryId){
                filteredCategory = category;
                break;
            }
        }
        if(filteredCategory != null){
            filteredCategory.addCategory(product);
        }
    }
    public void removeProduct(Map<Integer, Integer> categoryVsCount){
        for(Map.Entry<Integer, Integer> entry: categoryVsCount.entrySet()){
            ProductCategory category = getCategoryById(entry.getKey());
            if(category != null){
                category.removeProduct(entry.getValue());
            }
        }
    }
    public ProductCategory getCategoryById(int categoryId){
        for(ProductCategory category: productCategoryList){
            if(category.categoryId == categoryId){
                return category;
            }
        }
        return null;
    }
}