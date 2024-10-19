package Applications.InventoryManagement;
import Applications.InventoryManagement.WarehouseStrategy.WarehouseSelectionStrategy;

import java.util.*;
public class WarehouseController {
    public List<Warehouse> warehouseList;
    WarehouseSelectionStrategy selectionStrategy;

    public WarehouseController(){
        this.warehouseList = new ArrayList<>();
    }

    public void addWarehouse(Warehouse warehouse){
        this.warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){
        this.warehouseList.remove(warehouse);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy strategy){
        return strategy.selectWarehouse(this);
    }
}

