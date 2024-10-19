package Applications.InventoryManagement.WarehouseStrategy;
import Applications.InventoryManagement.*;
public interface WarehouseSelectionStrategy {
    public Warehouse selectWarehouse(WarehouseController warehouseController);
}
