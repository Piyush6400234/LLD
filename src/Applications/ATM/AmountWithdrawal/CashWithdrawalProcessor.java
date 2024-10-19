package Applications.ATM.AmountWithdrawal;
import Applications.ATM.*;
public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextResponsibility;

    public CashWithdrawalProcessor(CashWithdrawalProcessor nextProcessor){
        this.nextResponsibility = nextProcessor;
    }

    public abstract void processTransaction(int amount, ATM atm);
}
