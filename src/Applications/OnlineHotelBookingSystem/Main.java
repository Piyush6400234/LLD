package Applications.OnlineHotelBookingSystem;
import Applications.OnlineHotelBookingSystem.Payments.*;
/*
Requirements:
The hotel management system should allow guests to book rooms, check-in, and check-out.
The system should manage different types of rooms, such as single, double, deluxe, and suite.
The system should handle room availability and reservation status.
The system should allow the hotel staff to manage guest information, room assignments, and billing.
The system should support multiple payment methods, such as cash, credit card, and online payment.
The system should handle concurrent bookings and ensure data consistency.
The system should provide reporting and analytics features for hotel management.
The system should be scalable and handle a large number of rooms and guests.

*/
import java.time.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();

        // Create guests
        Guest guest1 = new Guest("G001", "John Doe", "john@example.com", "1234567890");
        Guest guest2 = new Guest("G002", "Jane Smith", "jane@example.com", "9876543210");
        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);

        // Create rooms
        Room room1 = new Room("R001", RoomType.SINGLE, 100.0);
        Room room2 = new Room("R002", RoomType.DOUBLE, 200.0);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        // Book a room
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = checkInDate.plusDays(3);
        List<Room>boookedroom = new ArrayList<>(List.of(room1));
//        booked
        Reservation reservation1 = hotelManagementSystem.bookRoom(guest1, boookedroom, checkInDate, checkOutDate);
        if (reservation1 != null) {
            System.out.println("Reservation created: " + reservation1.getId());
        } else {
            System.out.println("Room not available for booking.");
        }

        // Check-in
//        if(reservation1 != null){
//            hotelManagementSystem.checkIn(reservation1.getId());
//            System.out.println("Checked in: " + reservation1.getId());
//        }
//
//
//        // Check-out and process payment
//        Payment payment = new CreditCardPayment();
//        if(reservation1 != null){
//            hotelManagementSystem.checkOut(reservation1.getId(), payment);
//            System.out.println("Checked out: " + reservation1.getId());
//        }


        // Cancel a reservation
        if(reservation1 != null){
            hotelManagementSystem.cancelReservation(reservation1.getId());
            System.out.println("Reservation cancelled: " + reservation1.getId());
        }

    }
}