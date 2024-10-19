package Applications.InventoryManagement;
import java.util.*;
public class Cart {
    public Map<Integer, Integer> categoryVsCount;

    public Cart(){
        this.categoryVsCount = new HashMap<>();
    }
    public void addCategory(int categoryId, int count){
        categoryVsCount.put(categoryId, categoryVsCount.getOrDefault(categoryId,0)+count);
    }
    public void removeCategory(int categoryId, int count){
        int cnt = categoryVsCount.getOrDefault(categoryId, 0);
        if(cnt - count >= 0){
            categoryVsCount.put(categoryId, cnt-count);
        }
        else{
            categoryVsCount.remove(categoryId);
        }
    }
    public Map<Integer, Integer> showCart(){
        for(Integer key: categoryVsCount.keySet()){
            System.out.println("CategoryId: "+key+" count: "+categoryVsCount.get(key));
        }
        return categoryVsCount;
    }
    public void emptyCart(){
        System.out.println("cart reset to null items");
        categoryVsCount.clear();
    }
}