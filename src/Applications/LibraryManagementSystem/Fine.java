package Applications.LibraryManagementSystem;

import java.time.*;
import java.util.Date;

public class Fine {
    private Date creationDate;
    private double fineAmount;
    private String memberId;

    public static void collectFine(String memberId, long days) {
        System.out.println("Collected fine for " + days + " days.");
    }
}