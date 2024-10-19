package Behavioral.State.VendingMachine;
// Inventory has shelves and each shelf has an Item and each Item is represented by a codeNumber.
public class Inventory {
    ItemShelf[] inventory = null;
    public Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventoryShelves(){
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory){
        this.inventory = inventory;
    }
    // initializeEmptyInventory will not insert any item on shelf, it will just initialize the shelves of inventory.
    public void initialEmptyInventory(){
        int startCode = 101;
        for(int i = 0; i<inventory.length; i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }
    // this function will add the item on itemShelf whose code matches with codeNumber
    public void addItem(Item item, int codeNumber) throws Exception{

        for (ItemShelf itemShelf: inventory){
            if(itemShelf.code == codeNumber){
                if(itemShelf.isSoldOut()){
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                }
                else{
                    throw new Exception("Item already added, can't add here!!");
                }
            }
        }
    }
    // Item to be fetched and given according to codeNumber of the shelf, if not present then raise Exception.
    public Item getItem(int codeNumber) throws Exception{
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(!itemShelf.isSoldOut()){
                    return itemShelf.getItem();
                }
                else{
                    throw new Exception("Item already sold out!!");
                }
            }
        }
        throw new Exception("Invalid code!");
    }
    // mark the Item present on a shelf as soldOut.
    public void updateSoldOutItem(int codeNumber){
        for(ItemShelf itemShelf: inventory){
            if(itemShelf.getCode() == codeNumber){
                itemShelf.setSoldOut(true);
            }
        }
    }
}
