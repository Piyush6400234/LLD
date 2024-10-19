package Applications.ATM.ATMStates;
import Applications.ATM.*;
public abstract class ATMStates {
    public void insertCard(ATM atm, Card card){
        System.out.println("Something went Wrong!!");
    }
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("Something went wrong!!");
    }
    public void selectOperation(ATM atm, Card card, TransactionType type){
        System.out.println("Something went Wrong!!");
    }
    public void cashWithdrawal(ATM atm, Card card, int amount){
        System.out.println("Something went Wrong!!");
    }
    public void displayBalance(ATM atm, Card card){
        System.out.println("Something went wrong!");
    }
    public void returnCard(){
        System.out.println("Something went wrong!!");
    }
    public void exit(ATM atm){
        System.out.println("Something went wrong!!");
    }
}
