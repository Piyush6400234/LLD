package Behavioral.Visitor.RoomMaintenance;

public interface RoomElement {
    public void accept(RoomVisitor visitor);
}
