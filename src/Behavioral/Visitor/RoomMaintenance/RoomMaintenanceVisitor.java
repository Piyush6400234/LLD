package Behavioral.Visitor.RoomMaintenance;

public class RoomMaintenanceVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom){
        System.out.println("Providing maintenance for singleRoom!!");
    }

    @Override
    public void visit(DoubleRoom doubleRoom){
        System.out.println("Providing maintenance for doubleRoom!!");
    }
    @Override
    public void visit(DeluxeRoom deluxeRoom){
        System.out.println("Providing maintenance for DeluxeRoom!!");
    }
}
