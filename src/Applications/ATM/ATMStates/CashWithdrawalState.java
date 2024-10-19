package Applications.ATM.ATMStates;

import Applications.ATM.*;
import Applications.ATM.AmountWithdrawal.*;

public class CashWithdrawalState extends ATMStates{
    @Override
    public void cashWithdrawal(ATM atm, Card card, int amount){
        if(atm.getAtmBalance() < amount){
            System.out.println("Balance not available in this ATM, please visit another branch");
            exit(atm);
        }
        else if(card.getBankBalance() < amount){
            System.out.println("Insufficient Balance in your bank!!");
            exit(atm);
        }
        else{
            card.deductBankBalance(amount);
            atm.deductATMBalance(amount);

            CashWithdrawalProcessor withdrawer = new OneThousandWithdrawalProcessor(new FiveHundredWithdrawalProcessor(new OneHundredWithdrawalProcessor(null)));
            withdrawer.processTransaction(amount, atm);
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atm){
        System.out.println("Exiting the transaction!!");
        returnCard();
        atm.setCurrentState(new IdleState());
    }
    @Override
    public void returnCard(){
        System.out.println("Please collect your card!!");
    }
}