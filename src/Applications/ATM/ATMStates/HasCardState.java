package Applications.ATM.ATMStates;
import Applications.ATM.*;
public class HasCardState extends ATMStates{
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        if(card.isCorrectPin(pin)){
            atm.setCurrentState(new SelectOperationState());
        }
        else{
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exit happens!!");
    }

    @Override
    public void returnCard(){
        System.out.println("Returning card back to the user!!");
    }
}