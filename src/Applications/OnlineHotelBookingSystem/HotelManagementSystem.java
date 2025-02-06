package Applications.OnlineHotelBookingSystem;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import Applications.OnlineHotelBookingSystem.Payments.*;
public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private RoomManager roomManager;
    private ReservationManager reservationManager;
    private GuestManager guestManager;

    private HotelManagementSystem(){
        roomManager = new RoomManager();
        reservationManager = new ReservationManager();
        guestManager = new GuestManager();


    }
    public static synchronized HotelManagementSystem getInstance() {
        if (instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }
    public void addGuest(Guest guest) {
        guestManager.addGuest(guest);
    }
    public Guest getGuest(String guestId) {
        return guestManager.getGuestById(guestId);
    }
    public void addRoom(Room room) {
        roomManager.addRoom(room);
    }
    public Room getRoom(String roomId) {
        return roomManager.getRoomByRoomId(roomId);
    }
    public synchronized Reservation bookRoom(Guest guest, List<Room> room, LocalDate checkInDate, LocalDate checkOutDate) {
        if (roomManager.getRoomStatus(room) == RoomStatus.AVAILABLE) {
            roomManager.bookRoom(room);
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
            reservationManager.addReservation(reservation);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservationManager.getReservationById(reservationId);
        if (reservation != null) {
            reservationManager.cancelReservation(reservation);
        }
    }
    public synchronized void checkIn(String reservationId) {
        Reservation reservation = reservationManager.getReservationById(reservationId);
        if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
            List<Room> rooms = reservation.getRoom();
            for(Room r: rooms){
                r.checkIn();
            }
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public synchronized void checkOut(String reservationId, Payment payment) {
        Reservation reservation = reservationManager.getReservationById(reservationId);
        if (reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED) {
            List<Room> rooms = reservation.getRoom();
            double amount = 0;
            for(Room room: rooms){
                amount+= room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            }
            if (payment.processPayment(amount)) {
                reservation.complete();
            } else {
                throw new IllegalStateException("Payment failed.");
            }
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }



    private String generateReservationId() {
        // Generate a unique reservation ID
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


}
