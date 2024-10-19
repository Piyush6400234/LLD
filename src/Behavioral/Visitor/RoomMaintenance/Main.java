package Behavioral.Visitor.RoomMaintenance;
/*
--------------------------------------------------- :USE CASE: ------------------------------------------------
We have different Room types and each of them should have different pricing logic as well as maintenance logic.
So, we extract maintenance logic and pricing logic to different visitor classes, instead of keeping it into
the class themselves.
---------------------------------------------------------------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) {
        DeluxeRoom deluxeRoom = new DeluxeRoom();
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();

        RoomMaintenanceVisitor maintenanceVisitor = new RoomMaintenanceVisitor();
        maintenanceVisitor.visit(deluxeRoom);

    }
}
