package Applications.CarRental;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
// Bill can't exist without Reservation
public class Bill {
    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;

    public Bill(Reservation reservation){
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false;
    }
    public PaymentDetails payBill(String cardDetails){
        System.out.println("Total amount: "+this.totalBillAmount);
        PaymentDetails details = makePayment(cardDetails);
        isBillPaid = true;
        return details;
    }
    private PaymentDetails makePayment(String cardDetails){
        Payment payment = new Payment();
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        return payment.makePayments((int)this.totalBillAmount, PaymentMode.ONLINE, true, cardDetails);
    }
    private double computeBillAmount(){
        long from = (this.reservation.getToTimeStamp() -  this.reservation.getFromTimeStamp())/(1000*60*60);
        System.out.println("from: "+ from);
        Date fromdate = this.reservation.getDateBookedFrom();
        Date todate = this.reservation.getDateBookedTo();
        long diffDays = ChronoUnit.DAYS.between(LocalDate.ofInstant(fromdate.toInstant(), ZoneId.systemDefault()), LocalDate.ofInstant(todate.toInstant(), ZoneId.systemDefault()));
        System.out.println("diffDays: "+ diffDays);
        long cost = from*(this.reservation.getVehicle().getHourlyRentalCost()); // hourly time.
        long costDays = diffDays*(this.reservation.getVehicle().getDailyRentalCost());
        return (double)cost + (double)costDays;
    }
}
