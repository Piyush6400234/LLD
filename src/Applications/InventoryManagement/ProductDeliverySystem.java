package Applications.InventoryManagement;

import Applications.InventoryManagement.WarehouseStrategy.WarehouseSelectionStrategy;

import java.util.*;

public class ProductDeliverySystem {
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList){
        this.userController = new UserController();
        for(User user: userList){
            userController.addUser(user);
        }
        this.warehouseController = new WarehouseController();
        for(Warehouse warehouse: warehouseList){
            this.warehouseController.addWarehouse(warehouse);
        }
        this.orderController = new OrderController();
    }

    public User getUser(int userId){
        return this.userController.getUserById(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy strategy){
        return warehouseController.getWarehouse(strategy);
    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;
    }

    public void addProductToCart(User user, ProductCategory product, int count){
        Cart cart = user.cart;
        cart.addCategory(product.categoryId, count);
    }

    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createOrder(user, warehouse);
    }

    public void checkout(Order order, PaymentMode mode){
        order.checkout(mode);
    }
}