package Applications.MeetingSchedular;
import java.util.*;
//class which contains the meeting room information.
public class MeetingRoom {
    int capacity;

    String roomName;

    List<Meeting> scheduledMeetings;

    public MeetingRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
        this.scheduledMeetings = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public List<Meeting> getScheduledMeetings() {
        return this.scheduledMeetings;
    }

}
