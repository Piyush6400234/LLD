package Applications.MeetingSchedular;

import java.time.LocalDateTime;

// Record class which contains the slot(Date + Timings)
public record Slot(LocalDateTime startTime, LocalDateTime endTime) {
}
