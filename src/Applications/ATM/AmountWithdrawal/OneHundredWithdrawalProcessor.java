package Applications.ATM.AmountWithdrawal;
import Applications.ATM.*;

public class OneHundredWithdrawalProcessor extends CashWithdrawalProcessor{

    public OneHundredWithdrawalProcessor(CashWithdrawalProcessor nextProcessor){
        super(nextProcessor);
    }

    @Override
    public void processTransaction(int amount, ATM atm){
        int availableHundredNotes = atm.getNumOfOneHundredNotes();
        int num = amount/100;
        int rem = amount%100;
        if(availableHundredNotes > num){
            atm.deductOneHundredNotes(num);
        }
        else if(availableHundredNotes < num){
            atm.deductOneHundredNotes(availableHundredNotes);
            amount = amount - 100*(num - availableHundredNotes);
        }
        if(amount != 0)
        {
            System.out.println("Something went wrong, couldn't complete Transaction");
        }

    }
}
