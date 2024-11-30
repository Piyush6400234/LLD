package Applications.ATM;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String cardHolderName;
    private UserBankAccount userBankAccount;
    private int PIN = 1234;

    public Card(){ // can pass different parameters here like, cvv, cardNumber, expDate, cardHolder's Name, BankAccount etc. PIN

    }

    public boolean isCorrectPin(int pin){
        return pin == PIN;
    }
    public void setUserBankAccount(UserBankAccount bankAccount){
        this.userBankAccount = bankAccount;
    }
    public int getBankBalance(){
        return userBankAccount.getBalance();
    }
    public void deductBankBalance(int amount){
        userBankAccount.withdrawAmount(amount);
    }
}