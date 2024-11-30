package Applications.OnlineHotelBookingSystem;
import java.time.*;
import java.util.*;
//import java.util
public class Reservation {
    private final String id;
    private final List<Room> rooms;
    private final Guest guest;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, List<Room> room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.guest = guest;
        this.rooms = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = ReservationStatus.CONFIRMED;
    }

    public synchronized void cancel() {
        if (status == ReservationStatus.CONFIRMED) {
            status = ReservationStatus.CANCELLED;
            for(Room room: rooms) {
                room.checkOut();
            }
        } else {
            throw new IllegalStateException("Reservation is not confirmed.");
        }
    }
    public synchronized void complete(){
        if (status == ReservationStatus.CONFIRMED) {
            status = ReservationStatus.COMPLETED;
            for(Room room: rooms) {
                room.checkOut();
            }
        } else {
            throw new IllegalStateException("Reservation is not confirmed.");
        }
    }
    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public List<Room> getRoom() {
        return rooms;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}