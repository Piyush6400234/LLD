package Applications.ATM.ATMStates;
import Applications.ATM.*;
public class IdleState extends ATMStates{
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("card inserted");
        atm.setCurrentState(new HasCardState());
    }
}
