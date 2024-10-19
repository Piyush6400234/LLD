package Applications.InventoryManagement;

import java.util.*;

public class Warehouse {
    Inventory inventory;
    Address address;
    int warehouseId;

    public Warehouse(Inventory inventory, Address address){
        this.inventory = inventory;
        this.address = address;
    }

    public void addItemToInventory(Product product, int categoryId){
        inventory.addProduct(product, categoryId);
    }

    public void removeItemFromInventory(Map<Integer, Integer> categoryVsCount){
        this.inventory.removeProduct(categoryVsCount);
    }
}