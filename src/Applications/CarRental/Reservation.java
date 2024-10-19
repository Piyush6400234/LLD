package Applications.CarRental;
import java.util.*;
import Applications.CarRental.Product.*;
// Reservation will not exist independently, it has to be inside store, because reservation will be for a vehicle
// and vehicle will be a part of the store.

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationStatus reservationStatus;
    ReservationType reservationType;
    Location location;// user's location

    public int createReservation(User user, Vehicle vehicle){
        // Generate random digits
        this.reservationId = (int)(Math.random()*1000);
        this.user = user;
        this.vehicle = vehicle;
        this.reservationType = ReservationType.DAILY;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.dateBookedFrom = new Date();
        this.fromTimeStamp = System.currentTimeMillis();
//        this.toTimeStamp = System.currentTimeMillis();
        return reservationId;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public void setReservationStatus(ReservationStatus status){
        this.reservationStatus = status;
    }
    public void setDuration(Date dateBookedTo, Long toTimeStamp){
        this.dateBookedTo = dateBookedTo;
        this.toTimeStamp = toTimeStamp;
    }
    public void setLocation(Location pickUpLocation, Location dropLocation, Location userLocation){
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.location = userLocation;
    }
    public Date getDateBookedFrom(){
        return this.dateBookedFrom;
    }
    public Date getDateBookedTo(){
        return this.dateBookedTo;
    }
    public Long getFromTimeStamp(){
        return this.fromTimeStamp;
    }
    public Long getToTimeStamp(){
        return this.toTimeStamp;
    }
    public int getReservationId(){
        return this.reservationId;
    }
}