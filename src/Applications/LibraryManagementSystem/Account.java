package Applications.LibraryManagementSystem;

abstract class Account {
    public String id;
    public String password;
    public AccountStatus status;
    public LibraryCard libraryCard;
//    private Person person

    public Account(String id, LibraryCard libraryCard, AccountStatus status, String password) {
        this.id = id;
        this.libraryCard = libraryCard;
        this.status = status;
        this.password = password;
    }

    public boolean resetPassword(String OldPassword, String newPassword) {
        if (OldPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }
}