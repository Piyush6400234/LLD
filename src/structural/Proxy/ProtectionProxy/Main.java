package structural.Proxy.ProtectionProxy;
/*
=============================================== :Scenario: =====================================
We'll create a system where access to certain methods (e.g., deleteFile()) is restricted based on the role of the user.
An admin user can delete files, but a regular user cannot.
 */
public class Main {
    public static void main(String[] args) {
        FileAccess file1 = new FileAccessProxy("High res Image1", "admin");
        FileAccess file2 = new FileAccessProxy("High res Image2", "member");

        file2.readFile();
        file2.deleteFile();
        file1.readFile();
        file1.deleteFile();
    }
}
