package Applications.MeetingSchedular;

public class RoomAlreadyBookedException extends RuntimeException{

    public RoomAlreadyBookedException(String message){
        super(message);
    }
}