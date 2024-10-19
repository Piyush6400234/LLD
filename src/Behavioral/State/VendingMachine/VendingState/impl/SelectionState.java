package Behavioral.State.VendingMachine.VendingState.impl;
import Behavioral.State.VendingMachine.VendingState.*;
import java.util.*;
import Behavioral.State.VendingMachine.*;
public class SelectionState implements State{
    public SelectionState(){
        System.out.println("currently Vending machine is in Selection state!!");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("you can not insert Coin in selection state");
    }
    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception{
        Item item = machine.getInventory().getItem(codeNumber);

        //total amount paid by user
        int paidByUser = 0;
        for(Coin coin: machine.getCoinList()){
            paidByUser = paidByUser + coin.value;
        }

        if(paidByUser < item.getPrice() ){
            System.out.println("Insufficient amount, you paid "+paidByUser+" but the selected item is worth "+item.getPrice());
            refundFullMoney(machine);
            throw new Exception("Insufficient Amount!");
        } else if (paidByUser>= item.getPrice()) {
            if (paidByUser > item.getPrice()){
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }
    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        System.out.println("Returned the change in the coin Dispense tray: "+returnExtraMoney);
        return returnExtraMoney;
    }
    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back to the coin dispense tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
