package Applications.CarRental;

public class Location {

    String address;
    int pincode;
    String city;
    String state;
    String country;

    public Location(int pincode, String address, String city, String state, String country){
        this.pincode = pincode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}