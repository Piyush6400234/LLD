package Applications.OnlineHotelBookingSystem;
import java.util.*;

public class RoomManager {
    List<Room> rooms;

    public RoomManager(){
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Room getRoomByRoomId(String roomId){
        for(Room r: rooms){
            if(r.getId().equals(roomId)){
                return r;
            }
        }
        return null;
    }
    public RoomStatus getRoomStatus(List<Room> queriedRoom){
        for(Room room : queriedRoom){
            if(room.getStatus() != RoomStatus.AVAILABLE){
                return RoomStatus.OCCUPIED;
            }
        }
        return RoomStatus.AVAILABLE;
    }
    public void bookRoom(List<Room> room){
        for(Room r: room){
            r.book();
        }
    }

    public List<Room> getRoomByRoomType(RoomType type){
        List<Room> ans = new ArrayList<>();
        for(Room r: rooms){
            if(r.getType() == type){
                ans.add(r);
            }
        }
        return ans;
    }

    public List<Room> getAvailableRoom(){
        List<Room> ans = new ArrayList<>();
        for(Room r: rooms){
            if(r.getStatus() == RoomStatus.AVAILABLE){
                ans.add(r);
            }
        }
        return ans;
    }
}
