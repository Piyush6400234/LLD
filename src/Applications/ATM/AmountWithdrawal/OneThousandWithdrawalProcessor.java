package Applications.ATM.AmountWithdrawal;
import Applications.ATM.*;
public class OneThousandWithdrawalProcessor extends CashWithdrawalProcessor{

    public OneThousandWithdrawalProcessor(CashWithdrawalProcessor nextProcessor){
        super(nextProcessor);
    }

    @Override
    public void processTransaction(int amount, ATM atm){
        int availableNotes = atm.getNumOfThousandNotes();
        int num = amount/1000;
        int rem = amount%1000;
        if(num<availableNotes){
            atm.deductThousandNotes(num);
        }
        else if(num > availableNotes){
            int offset = num - availableNotes;
            atm.deductThousandNotes(availableNotes);
            amount = amount - 1000*(offset);
        }
        if(amount != 0){
            nextResponsibility.processTransaction(amount, atm);
        }
    }
}
