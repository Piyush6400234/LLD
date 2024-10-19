package Applications.InventoryManagement.WarehouseStrategy;
import Applications.InventoryManagement.*;
public class NearestWarehouse implements WarehouseSelectionStrategy{
    @Override
    public Warehouse selectWarehouse(WarehouseController warehouseController){
        if(!warehouseController.warehouseList.isEmpty()){
            return warehouseController.warehouseList.getFirst();
        }
        return null;
    }
}