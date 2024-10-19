package creational.abstractFactory.Furniture;

import creational.abstractFactory.Furniture.Chair.Chair;
import creational.abstractFactory.Furniture.Chair.VictorianChair;
import creational.abstractFactory.Furniture.Sofa.Sofa;
import creational.abstractFactory.Furniture.Sofa.VictorianSofa;
import creational.abstractFactory.Furniture.Table.Table;
import creational.abstractFactory.Furniture.Table.VictorianTable;

public class VictorianFactory extends Factory{
    @Override
    protected Chair createChair(){
        return new VictorianChair();
    }

    @Override
    protected Table createTable(){
        return new VictorianTable();
    }

    @Override
    protected Sofa createSofa(){
        return new VictorianSofa();
    }

}
