package Behavioral.Visitor.RoomMaintenance;

public class DoubleRoom implements RoomElement{
    private int roomPrice = 1900;
    @Override
    public void accept(RoomVisitor visitor){
        visitor.visit(this);
    }

    public int getRoomPrice(){
        return roomPrice;
    }
}
