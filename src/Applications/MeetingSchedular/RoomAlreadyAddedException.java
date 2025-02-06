package Applications.MeetingSchedular;

public class RoomAlreadyAddedException extends RuntimeException {
    public RoomAlreadyAddedException(String message) {
        super(message);
    }
}