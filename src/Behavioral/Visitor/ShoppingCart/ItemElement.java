package Behavioral.Visitor.ShoppingCart;

public interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
