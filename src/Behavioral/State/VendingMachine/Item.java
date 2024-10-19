package Behavioral.State.VendingMachine;
// One Item can have multiple ItemType.
public class Item {
    ItemType type;
    int price;
    public ItemType getType(){
        return this.type;
    }
    public void setType(ItemType type){
        this.type = type;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
}