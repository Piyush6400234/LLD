package Applications.MeetingSchedular;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//It will manage the meeting room service.
public class RoomManagementService {
    private final MeetingDao meetingDao;

    public RoomManagementService(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingDao.addNewRoom(meetingRoom);
        System.out.println("Room " + meetingRoom.getRoomName() + " added successfully!!!");
    }

    public void removeMeetingRoom(String roomName) {
        meetingDao.removeRoom(roomName);
    }

    public boolean isSlotAvailable(String roomName, LocalDate meetingDate, Slot meetingTimings) {
        return meetingDao.isMeetingRoomAvailable(roomName, meetingDate, meetingTimings);
    }

    public List<String> allRoomsWithCapacity(int capacity) {
        var allRooms = meetingDao.getAllMeetingRooms();
        allRooms.removeIf(meetingRoom ->
                meetingRoom.getCapacity() < capacity
        );

        return allRooms.stream().map(MeetingRoom::getRoomName).collect(Collectors.toList());
    }

}
