package Behavioral.Visitor.ShoppingCart;
// Implement Concrete Visitor
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

    @Override
    public int visit(Book book){
        int cost = book.getPrice();
        if(cost>50){
            cost-=5;
        }
        System.out.println("Book with ISBN: "+book.getIsbnNumber()+" costs = "+cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit){
        int cost = fruit.getPricePerKg()* fruit.getWeight();
        System.out.println("No discount on fruit, total cost = "+cost);
        return cost;
    }
}
