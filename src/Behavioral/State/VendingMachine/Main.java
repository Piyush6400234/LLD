package Behavioral.State.VendingMachine;
import Behavioral.State.VendingMachine.VendingState.*;
/*
We'll have a vending Machine which will have various drinks, user will insert a coin, can cancel the process, select
the product, machine checks if coin is enough or not, then machine will give product or cancel the process if
money is not enough, and machine can refund the remaining amount.
-----------------------------------------------------
state               |   operations                  |
-----------------------------------------------------
Idle                | Press Insert Cash Button      |
-----------------------------------------------------
HasMoney            | Insert Coin                   |
                    | click on select product Button|
                    | click on cancel/refund Button |
-----------------------------------------------------
selection State     | choose product                |
                    | cancel/refund                 |
                    | return change                 |
-----------------------------------------------------
dispensing          | Product dispensing            |
------------------------------------------------------


 */
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();// This will initialize an Inventory of 10 shelves.
        try {
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState.clickOnStartProductSelectionButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 103);

            displayInventory(vendingMachine);


        }
        catch (Exception e){
            System.out.println("Some error occured!!");
            displayInventory(vendingMachine);
        }
    }
    public static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] inventory = vendingMachine.getInventory().getInventoryShelves();

        for(int i = 0; i<inventory.length; i++){
            Item item = new Item();
            if(i>=0 && i<3){
                item.setType(ItemType.COKE);
                item.setPrice(12);
            } else if (i >=3 && i<6) {
                item.setType(ItemType.PEPSI);
                item.setPrice(9);
            } else if (i>=6 && i<9) {
                item.setType(ItemType.JUICE);
                item.setPrice(13);
            } else if (i>=9 && i<10) {
                item.setType(ItemType.SODA);
                item.setPrice(7);
            }
            inventory[i].setSoldOut(false);
            inventory[i].setItem(item);
        }
    }

    public static void displayInventory(VendingMachine vendingMachine){
        Inventory inventory = vendingMachine.getInventory();
        ItemShelf[] itemShelves = inventory.getInventoryShelves();
        for(int i = 0; i< itemShelves.length; i++){
            System.out.println("CodeNumber: "+ itemShelves[i].getCode()
            +" Item: "+ itemShelves[i].getItem().getType().name()
            +" Price: "+itemShelves[i].getItem().getPrice()
            +" isAvailable: "+itemShelves[i].isSoldOut()
            );
        }

    }
}

