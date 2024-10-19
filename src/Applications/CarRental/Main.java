package Applications.CarRental;
import Applications.CarRental.Product.*;

import java.util.ArrayList;
import java.time.*;
import java.util.*;
/*
    story point:
        Search Capability: A user went to car rental site. He should see all his local store where he can pick a car from.
           He'll see store1, store2 ... The store should list down all the vehicles. Vehicle should be extensible, it
           can be various types i.e car, bike etc.

        user will reserve a vehicle, and pay the bill (Now Bill is an object which can be paid or not paid at that time
        of reservation)

        At the end user will submit the vehicle, and make payments if not already done.


    Objects:
    1). User -
    2). Location -
    3). Stores -
    4). Vehicle -
    5). Reserve -
    6). Bill -
    7). Payments -
    8).
*/

public class Main {
    public static void main(String[] args) {
        // In next few lines we will add the vehicles into store using Inventory Management.
        // vehicles.
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        v1.setCompanyName("hero");
        v1.setVehicleType(VehicleType.BIKE);
        v1.setStatus(Status.ACTIVE);
        v1.setAverage(20);
        v1.setDailyRentalCost(20);
        v1.setHourlyRentalCost(14);
        v1.setNoOfSeat(2);
        v1.setVehicleID(2354);
        v1.setKmDriven(2014);

        v2.setCompanyName("Maruti");
        v2.setVehicleType(VehicleType.CAR);
        v2.setStatus(Status.ACTIVE);
        v2.setAverage(8);
        v2.setDailyRentalCost(30);
        v2.setHourlyRentalCost(20);
        v2.setNoOfSeat(4);
        v2.setVehicleID(6598);
        v2.setKmDriven(8541);
        List<Vehicle> vehicles1 = new ArrayList<>();
        vehicles1.add(v1);
        vehicles1.add(v2);

        Vehicle v3 = new Vehicle();
        v3.setCompanyName("Suzuki");
        v3.setVehicleType(VehicleType.BIKE);
        v3.setStatus(Status.ACTIVE);
        v3.setAverage(15);
        v3.setDailyRentalCost(10);
        v3.setHourlyRentalCost(1);
        v3.setNoOfSeat(2);
        v3.setVehicleID(7108);
        v3.setKmDriven(1541);

        Vehicle v4 = new Vehicle();
        v4.setCompanyName("BMW");
        v4.setVehicleType(VehicleType.CAR);
        v4.setStatus(Status.ACTIVE);
        v4.setAverage(8);
        v4.setDailyRentalCost(30);
        v4.setHourlyRentalCost(5);
        v4.setNoOfSeat(4);
        v4.setVehicleID(1208);
        v4.setKmDriven(2851);

        List<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(v3);
        vehicles2.add(v4);

        // stores
        Store store1 = new Store();
        Location l1 = new Location(125466, "kundalahalli", "bengaluru", "karnataka", "India");
        store1.setVehicle(vehicles1);
        store1.setLocation(l1);

        Store store2 = new Store();
        Location l2 = new Location(2133654, "Bela", "darbhanga", "bihar", "India");
        store2.setVehicle(vehicles2);
        store2.setLocation(l2);

        List<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);



        //users
        User piyush = new User();
        piyush.setDrivingLicence(2548752);
        piyush.setUserId(2532);
        piyush.setUserName("Piyush");

        User ritu = new User();
        ritu.setUserName("ritu");
        ritu.setUserId(6584);
        ritu.setDrivingLicence(85987456);

        List<User> users = new ArrayList<>();
        users.add(piyush);
        users.add(ritu);
// ------------------------------------- :Object Creation done: ------------------------------------------
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(storeList, users);

        Store store  = rentalSystem.getStoreByLocation(l1);

        List<Vehicle> options = store.getVehicles(); // get all vehicles.
        List<Vehicle> filteresCars = store.getVehicleBasedOnVehicleType(VehicleType.CAR); // can search based on Type
        for(Vehicle v: options){
            System.out.println(v.getVehicleID());
        }

        Reservation piyushReserv = store.createReservation(2354, piyush);

        LocalDate today = LocalDate.now();
        LocalDate twoDaysLater = today.plusDays(2);
        Date date = Date.from(twoDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());

        piyushReserv.setDuration(date, System.currentTimeMillis());
        System.out.println("Reservation status: "+piyushReserv.reservationStatus);

        Bill piyushBill = store1.completeReservation(piyushReserv.getReservationId());
        System.out.println("Total Bill amount: "+piyushBill.totalBillAmount);
        System.out.println("Is Bill Paid? "+piyushBill.isBillPaid);

        PaymentDetails details = piyushBill.payBill("My card Details");
        System.out.println("Is Bill Paid? "+piyushBill.isBillPaid);



    }
}
