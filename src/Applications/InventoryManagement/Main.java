package Applications.InventoryManagement;
import Applications.InventoryManagement.WarehouseStrategy.*;

import java.util.*;
/*
Inventory Management similar to but not same as Order Management.
Every unit has a different sku, even though they are let's say "coco cola 1L". and each unit/product belongs to "coca cola 1L" category

User comes and:
    1). view Products / categories from a particular warehouse
    2). Add product to cart
    3). Place order to generate Invoice
    4). Payment/checkout
All the user's requirements will be satisfied by only one warehouse, which is nearest to him/her.
Objects:
    1). User
    2). Product
    3). Cart
    4). Order
    5). Invoice
    6). Location
    7). Payments
    8). Inventory (to manage multiple Products)
    9). Warehouse - (let's say a product belongs to a particular warehouse, and there can be multiple warehouses, user should be able to select all the products belonging to same warehouse)

 Product category will have a list of products and the price of a single quantity of product.
 Product category will help us increase the quantity of product by clicking on +/- icon

 Inventory class has a list of product Category. It can add a product category, remove a product Category
 Now, who manages Inventories --> Warehouse

 Warehouse has an Inventory and address, it can add an item to inventory, remove an item from Inventory. Each warehouse will manage one Inventory

 We can have multiple warehouses, and who will manage all those?
 Warehouse controller--> It has a list of warehouse, warehouseSelectionStrategy, and can add warehouse, remove warehouse, or select warehouse.

 warehouseSelectionStrategy--> Selects one warehouse according to user's location. It can be extended to multiple strategy eg. nearestWarehouseStrategy, cheapestWarehouseStrategy

 Address: Pin code, city, state etc

 User: name, id, Cart(whenever user logs in we assign an empty cart to it), List<orderId>(to keep track of older orders as well)

 Cart: Map<Integer, Integer>CategoryIdVsCount, add a product category, remove a category, view the cart, empty the cart

 User Controller: List<User> userList, add user, remove user etc

 App: UserController, warehouseController, Can select a particular warehouse(using warehouseController), particular user(using UserController) etc

 Order: User, OrderId, cart/CategoryIdVsCount, Address(delivery address), warehouseInfo, Invoice, boolean Payment, order status

 Order Status(ENUM): pending, delivered, undelivered e.t.c
 Invoice: Total amount, tax, shipping charge e.t.c

 Payment: Payment mode(UPI, CARD, CASH) e.t.c

 OrderController: List<orders>, can fetch order by orderId, or Order by User

 */
public class Main {
    public static void main(String[] args) {
        Main mainobj = new Main();
        List<User> userList = new ArrayList<>();
        List<Warehouse> warehouseList = new ArrayList<>();
        userList.add(mainobj.createUser());
        warehouseList.add(mainobj.addInventoryAndItems());

        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);
        mainobj.runDeliveryFlow(productDeliverySystem, 1);

    }

    public Warehouse addInventoryAndItems(){

        Inventory inventory = new Inventory();
        inventory.addCategory(5201, "Pepsi Large Coco cola 1L", 98);
        inventory.addCategory(5875, "Dove small soap", 36);

        Product product1 = new Product();
        product1.productId = 23;
        product1.productName = "pepsi";

        Product product2 = new Product();
        product2.productName = "pepsi";
        product2.productId = 43;

        Product product3 = new Product();
        product3.productId = 85;
        product3.productName = "dove";

        inventory.addProduct(product1, 5201);
        inventory.addProduct(product2, 5201);
        inventory.addProduct(product3, 5875);

        Address address = new Address(854522, "bangalore", "karnataka");
        Warehouse warehouse = new Warehouse(inventory, address);
        return warehouse;
    }

    public User createUser(){
        User user = new User("Piyush");
        user.userId = 1;
        user.address = new Address(584785, "bangalore", "karnataka");
        return user;
    }
    public void runDeliveryFlow(ProductDeliverySystem deliverySystem, int userid){
        User user = deliverySystem.getUser(1);
        Warehouse warehouse = deliverySystem.getWarehouse(new NearestWarehouse());
        Inventory inventory = deliverySystem.getInventory(warehouse);

        ProductCategory productCategoryIWantToOrder = null;
        for(ProductCategory category: inventory.productCategoryList){
            if(category.categoryName.equalsIgnoreCase("Pepsi Large Coco cola 1L")){
                productCategoryIWantToOrder = category;
                break;
            }
        }

        deliverySystem.addProductToCart(user, inventory.getCategoryById(productCategoryIWantToOrder.categoryId), 2);
        Order order = new Order(user, warehouse);
        Invoice invoice = order.generateInvoice();
        System.out.println(inventory.getCategoryById(5201).productList.size());
        deliverySystem.checkout(order, new UPImode());
        System.out.println(inventory.getCategoryById(5201).productList.size());
    }
}