package Behavioral.Visitor.RoomMaintenance;

public class RoomPricingVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom singleRoom){
        System.out.println("single room price is: " + singleRoom.getRoomPrice());
    }
    @Override
    public void visit(DoubleRoom doubleRoom){
        System.out.println("double room price is: " + doubleRoom.getRoomPrice());
    }
    @Override
    public void visit(DeluxeRoom deluxeRoom){
        System.out.println("Deluxe room price is: " + deluxeRoom.getRoomPrice());
    }
}
