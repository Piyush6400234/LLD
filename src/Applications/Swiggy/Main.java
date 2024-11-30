package Applications.Swiggy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
customer places an order from their App
when order is received, we've to take care of two major things
1). tell the restaurant to prepare food,
2). by the time this food is being prepared, we need to make sure that a delivery partner is assigned and it should reach the restaurant
    for food pick up and then delivery
so we divide the whole system into two subsystems 1). Food - also show all the nearby restaurants present, their menus, what they are delivering etc
                                                  2). Delivery - assigning partner nearest to restaurant (or other strategies), making sure they reach on time and everything related to delivery
After diving into two part we need to have a connecting point that connects food as well as delivery system that is ORDER
        Delivery
       /
      /
ORDER MGR
     \
      \
        FOOD

ORDER MGR will create order with a unique order_id and should send same to Delivery and order subsystem.
ORDER MGR will tell Delivery MGR that this is order_id and we need to deliver it from here to here e.t.c
ORDER MGR will tell Food MGR that this is order_id and this restaurant should start making this food and in this quantity.
    in case of restaurant chain like dominos, we'll keep different object for each of them.
Food Mgr and Restaurant Mgr will be sigleton and we can have a pool of Mgr that will contain multiple single Mgrs each based on
some specific area.

Add-ons can also be there and we'll keep add-ons option per dish basis. Like Restaurant has Menu, menu has Dish, dish has add-ons
Dish add-ons cannot be added separately, whereas dish can be added separately.
There can be other design decisions as well, add-ons can be ordered individually without having to order dish.
*/
public class Main {
    public static void main(String[] args) {
        RestaurantOwner owner1 = new RestaurantOwner("owner1");
        Restaurant chineseRest = new Restaurant("chinese vala", true, new Location(1, 2), owner1);
        Dish noodles = new Dish("noodles", CuisineType.CHINESE, "chinese noodles", 200.0);
        noodles.addAddon(new DishAddOn(522.0, "good addon"));
        Dish driedFish = new Dish("fried rice", CuisineType.CHINESE,"fried rice is good", 180.5);
        Dish springRolls = new Dish("spring rolls", CuisineType.CHINESE, "spring rolls", 150.0);
        Menu chineseMenu = new Menu(new ArrayList<>(List.of(noodles, driedFish, springRolls)));
        chineseRest.addMenu(chineseMenu);



        RestaurantOwner owner2 = new RestaurantOwner("owner2");
        Restaurant southRest = new Restaurant("south wala", true, new Location(85, 287), owner2);
        Dish idli = new Dish("idli", CuisineType.SOUTH_INDIAN, "idli is good", 200.0);
        idli.addAddon(new DishAddOn(522.0, "good addon"));
        Dish dosa = new Dish("dosa awesome", CuisineType.SOUTH_INDIAN,"dosa is good", 120.5);
        Dish uthappam = new Dish("uttapam", CuisineType.SOUTH_INDIAN, "uttapam is good", 187.0);
        Menu south_indian_menu = new Menu(new ArrayList<>(List.of(idli, dosa, uthappam)));
        southRest.addMenu(south_indian_menu);

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(chineseRest);
        restaurantManager.addRestaurant(southRest);


        DeliveryPartner alpha = new DeliveryPartner("alpha");
        DeliveryPartner beta = new DeliveryPartner("beta");
        DeliveryPartner gamma = new DeliveryPartner("gamma");

        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getInstance();
        deliveryPartnerMgr.addDeliveryPartner(alpha);
        deliveryPartnerMgr.addDeliveryPartner(beta);
        deliveryPartnerMgr.addDeliveryPartner(gamma);

        User piyush = new User("piyush", new Location(10,11));
        User kamran = new User("kamran", new Location(13, 14));
        User yogesh = new User("yogesh", new Location(15, 16));
        //users can exist without usermgr as well. That's why it is an aggregation relationship

        UserManager userManager = UserManager.getInstance();
        userManager.addUser(piyush);
        userManager.addUser(kamran);
        userManager.addUser(yogesh);
        Map<Dish, Integer> cart = new HashMap<>();
        cart.put(noodles, 2);
        cart.put(driedFish, 4);
        Order order1 = new Order(piyush, chineseRest, cart, "545iu", "iuytt65", OrderStatus.PLACED);


        OrderManager orderManager = OrderManager.getInstance();
        orderManager.createOrder(order1);






    }
}


/*
200+30+180+80+120+30+100+50+650+1400+400 = 3240
*
* */