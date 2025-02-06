package Applications.MeetingSchedular;
//class which contains the meeting information.
import java.time.LocalDate;
import java.util.*;
public class Meeting {
    String meetingTitle;

    LocalDate meetingDate;

    Slot meetingDuration;

    List<User> attendees;

    User host;

    public Meeting(String meetingTitle, LocalDate meetingDate, Slot meetingDuration, User host) {
        this.meetingTitle = meetingTitle;
        this.meetingDate = meetingDate;
        this.meetingDuration = meetingDuration;
        this.attendees = new ArrayList<>();
        this.host = host;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public Slot getMeetingDuration() {
        return meetingDuration;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void addAttendees(User user) {
        this.attendees.add(user);
    }

    public User getHost() {
        return host;
    }

}
