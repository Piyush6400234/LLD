package Applications.LibraryManagementSystem;

import java.util.Date;

public class LibraryCard {
    private String cardNumber;
    private String barCode;
    private Date issuedAt;
    private boolean isActive;

    public LibraryCard(String cardNumber, String barCode, Date issuedAt, boolean isActive) {
        this.cardNumber = cardNumber;
        this.barCode = barCode;
        this.issuedAt = issuedAt;
        this.isActive = isActive;
    }

    public String getBarCode(){
        return this.barCode;
    }

}