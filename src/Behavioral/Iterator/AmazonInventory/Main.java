package Behavioral.Iterator.AmazonInventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventoryColl = new Inventory();
        Product prdt1 = new Product("mouse", 600);
        Product prdt2 = new Product("keyboard", 300);
        inventoryColl.addItems(prdt1);
        inventoryColl.addItems(prdt2);
        ProductIterator iter =  inventoryColl.getIterator();
        ProductReverseIterator iterRev = inventoryColl.getReverseIterator();
        while(iter.hasNext()){
            Product p = iter.next();
            System.out.println("name: "+p.getName()+", price: "+p.getPrice());
        }

        while(iterRev.hasNext()){
            Product p = iterRev.next();
            System.out.println("name: "+p.getName() +", price: "+p.getPrice());
        }
    }
}
