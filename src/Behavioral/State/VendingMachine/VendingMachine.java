package Behavioral.State.VendingMachine;
import Behavioral.State.VendingMachine.VendingState.*;
import Behavioral.State.VendingMachine.VendingState.impl.*;

import java.util.*;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(){
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);// we're setting the size of inventory or number of ItemShelf each containing one item.
        this.coinList = new ArrayList<>();
    }

    public State getVendingMachineState(){
        return this.vendingMachineState;
    }
    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public List<Coin> getCoinList(){
        return coinList;
    }
    public void setCoinList(List<Coin> coinList){
        this.coinList = coinList;
    }
}
