package Behavioral.Visitor.ShoppingCart;

public class Book implements ItemElement{
    private int price;
    private String isbnNumber;
    public Book(int price, String isbnNumber){
        this.isbnNumber = isbnNumber;
        this.price = price;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
    public int getPrice(){
        return this.price;
    }
    public String getIsbnNumber(){
        return this.isbnNumber;
    }
}