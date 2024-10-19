package Applications.ATM.AmountWithdrawal;
import Applications.ATM.*;
public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{

    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nextProcessor){
        super(nextProcessor);
    }

    @Override
    public void processTransaction(int amount, ATM atm){
        int num = amount/500;
        int rem = amount%500;
        if(num < atm.getNumOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(num);
        }
        else if(num > atm.getNumOfFiveHundredNotes()){
            int offset = num - atm.getNumOfOneHundredNotes();
            atm.deductFiveHundredNotes(atm.getNumOfFiveHundredNotes());
            amount = amount - offset*500;
        }
        if(amount != 0){
            nextResponsibility.processTransaction(amount, atm);
        }
    }
}