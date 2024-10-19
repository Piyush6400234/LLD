package creational.abstractFactory.Furniture;

import creational.abstractFactory.Furniture.Chair.Chair;
import creational.abstractFactory.Furniture.Chair.TraditionalChair;
import creational.abstractFactory.Furniture.Sofa.Sofa;
import creational.abstractFactory.Furniture.Sofa.TraditionalSofa;
import creational.abstractFactory.Furniture.Table.Table;
import creational.abstractFactory.Furniture.Table.TraditionalTable;

public class TraditionalFactory extends Factory{
    @Override
    protected Chair createChair(){
        return new TraditionalChair();
    }
    @Override
    protected Table createTable(){
        return new TraditionalTable();
    }
    @Override
    protected Sofa createSofa(){
        return new TraditionalSofa();
    }
}
