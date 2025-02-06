package Applications.LibraryManagementSystem;

public class Librarian extends Account {

    public Librarian(String id, LibraryCard libraryCard, AccountStatus status, String password) {
        super(id, libraryCard, status, password);
    }

    public boolean addBookItem(Book bookItem){
        return true;
    }
    public boolean blockMember(Member member){return true;}
    public boolean unBlockMember(Member member){return true;}
    public boolean cancelMembership(Member member){return true;}
}
