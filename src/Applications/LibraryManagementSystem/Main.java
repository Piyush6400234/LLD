package Applications.LibraryManagementSystem;

import java.time.LocalDate;
import java.util.Date;
import java.text.*;

/*
Requirements:
Member can search for books by their author, title or publication date.
Each Book will have a unique id and rack number where a book is physically placed.
A book can have multiple copies, and member can check out any copy.
The system can retrieve information about a particular book.
There should be a maximum limit (5) on how many books a member can check out.
There should be a maximum limit (10) on how many days a member can keep a book.
The system should be able to collect fines for books returned after the due date.
Each member will have a library card with a unique barcode.

 */
public class Main {
    public static void main(String[] args) {
        LibraryCard c1 = new LibraryCard("5487", "8888", new Date(), true);
        LibraryCard c2 = new LibraryCard("9887", "888788", new Date(), true);
        Member mb = new Member("iuij", c1, AccountStatus.ACTIVE, "854254");
        Member ma = new Member("iui45j", c1, AccountStatus.ACTIVE, "8542fgg54");
        Rack rack1 = new Rack(58241, "p-8");
        Rack rack2 = new Rack(87456, "p-9");
        String dateString = "2024-05-08";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date purchaseDate = null;
        try{
             purchaseDate = dateFormat.parse(dateString);
        }
        catch (ParseException e){
            System.out.println("undefined date string.");
        }
        if(purchaseDate == null)return;

        BookItem book1 = new BookItem("54215", "book1", "Hindi", "publisher1", "Hindi", 200, "2154iu765", false,  purchaseDate, purchaseDate, 500.5, BookFormat.HARDCOVER, BookStatus.AVAILABLE, rack1);
        BookItem book2 = new BookItem("89215", "book2", "english", "publisher2", "english", 250, "8554i8frt5", false,  purchaseDate, purchaseDate, 600.5, BookFormat.HARDCOVER, BookStatus.AVAILABLE, rack2);
        BookItemManager bookManager = BookItemManager.getInstance();
        bookManager.addBookItem(book1);
        bookManager.addBookItem(book2);
        MemberManager mm = MemberManager.getInstance();
        mm.addMember(mb);
        mm.addMember(ma);
        mm.displayAllUsers();
        bookManager.displayBook("2154iu765");
        boolean confirm =  mm.checkoutBookItem(book1, "iuij");
        System.out.println("is checkout complete? : "+ confirm);
        bookManager.displayBook("2154iu765");
//        boolean confirm2 = mm.checkoutBookItem(book1, "iui45j");
//        System.out.println("lending same book possible: "+ confirm2);
        mm.returnBookItem(book1, "iuij");


        BookLendingManager lendingManager = BookLendingManager.getInstance();
        BookLending bl = lendingManager.fetchLendingDetails("2154iu765");
        System.out.println(bl);

    }
}
