package Applications.ATM.ATMStates;
import Applications.ATM.*;
public class CheckBalanceState extends ATMStates{

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your account Balance is: "+card.getBankBalance());
        exit(atm);
    }
    @Override
    public void exit(ATM atm){
        System.out.println("Exiting current Transaction!!");
        atm.setCurrentState(new IdleState());
        returnCard();
    }
    @Override
    public void returnCard(){
        System.out.println("Please collect your card!!");
    }

}
