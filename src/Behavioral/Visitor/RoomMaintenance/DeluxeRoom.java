package Behavioral.Visitor.RoomMaintenance;

public class DeluxeRoom implements RoomElement{
    private int roomPrice = 2500;
    @Override
    public void accept(RoomVisitor visitor){
        visitor.visit(this);
    }
    public int getRoomPrice(){
        return roomPrice;
    }
}