package Applications.ATM;
import Applications.ATM.*;
public class ATMRoom {
    private ATM atm;
    User user;

    public void initialize() {
        atm = ATM.getAtmObject();
        atm.setAtmBalance(3500, 2, 5, 2);
    }

    public void createUser() {// we can pass credentials here(cvv, cardNum, BankName, expDate, CardUser)
        // Using those credential details we can call an external API to get further details like, user info, Account info, card's hidden Info(e.g. PIN)
        User user = new User();
        UserBankAccount account = new UserBankAccount();
        Card card = createCard(account);
        user.setCard(card);
        user.setBankAccount(account);
        this.user = user;
    }

    private Card createCard(UserBankAccount account){ // Apart from this, we can pass card details as well,
        Card card = new Card();
        card.setUserBankAccount(account);
        return card;
    }
    private UserBankAccount createBankAccount(){
        UserBankAccount account = new UserBankAccount();
        return account;
    }
    public ATM getAtm(){
        return this.atm;
    }
    public User getUser(){
        return this.user;
    }
}