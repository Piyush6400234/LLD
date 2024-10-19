package creational.abstractFactory.Furniture;

import creational.abstractFactory.Furniture.Chair.Chair;
import creational.abstractFactory.Furniture.Chair.ModernChair;
import creational.abstractFactory.Furniture.Sofa.ModernSofa;
import creational.abstractFactory.Furniture.Sofa.Sofa;
import creational.abstractFactory.Furniture.Table.Table;
import creational.abstractFactory.Furniture.Table.ModernTable;

public class ModernFactory extends Factory{

    @Override
    protected Chair createChair(){
        return new ModernChair();
    }
    @Override
    protected Table createTable(){
        return new ModernTable();
    }
    @Override
    protected Sofa createSofa(){
        return new ModernSofa();
    }
}
