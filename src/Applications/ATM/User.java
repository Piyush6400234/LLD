package Applications.ATM;
// User has both card and BankAccount.
public class User {
    private Card card; // because for 1 user, there can be multiple cards linked to his single bank Account.
    private UserBankAccount bankAccount; // that single bank account

    public void setCard(Card card){
        this.card = card;
    }
    public Card getCard(){
        return card;
    }
    public void setBankAccount(UserBankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    public UserBankAccount getBankAccount(){
        return bankAccount;
    }
}