package Applications.ATM;

public class UserBankAccount {
    private int balance;

    public UserBankAccount(){
        balance = 5000;
    }

    public int getBalance(){
        return balance;
    }
    public void withdrawAmount(int amount){
        balance = balance - amount;
        System.out.println("Amount withdrawn: "+ amount+ " remaining balance: "+balance);
    }
}
