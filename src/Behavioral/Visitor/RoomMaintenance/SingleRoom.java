package Behavioral.Visitor.RoomMaintenance;

public class SingleRoom implements RoomElement{
    private int roomPrice = 1500;
    @Override
    public void accept(RoomVisitor visitor){
        visitor.visit(this);
    }
    public int getRoomPrice(){
        return roomPrice;
    }
}