package Applications.ATM.ATMStates;
import Applications.ATM.*;
public class SelectOperationState extends ATMStates{
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType type){
        if(type == TransactionType.BALANCE_CHECK){
            atm.setCurrentState(new CheckBalanceState());
        }
        else if(type == TransactionType.CASH_WITHDRAWAL){
            atm.setCurrentState(new CashWithdrawalState());
        }
        else{
            System.out.println("Invalid operation selected!!");
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exiting selection State");
    }
    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
    public void showOperations(){
        System.out.println("Available Operations are: ");
        TransactionType.showAllTransactionTypes();
    }
}