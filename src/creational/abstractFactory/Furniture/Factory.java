package creational.abstractFactory.Furniture;
import creational.abstractFactory.Furniture.Chair.Chair;
import creational.abstractFactory.Furniture.Sofa.Sofa;
import creational.abstractFactory.Furniture.Table.Table;

public abstract class Factory {
    public Chair getChair(){
        return createChair();
    }
    public Table getTable(){
        return createTable();
    }
    public Sofa getSofa(){
        return createSofa();
    }
    protected abstract Chair createChair();

    protected abstract Table createTable();

    protected abstract Sofa createSofa();
}
