package Behavioral.ChainOfResponsibility.ATMDispensers;

public class Dollar10Dispenser implements DispenseChain{
    DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain){
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency)
    {
        if(currency.getAmount()>=10){

            int num = currency.getAmount()/10;
            int rem = currency.getAmount()%10;
            System.out.println("Dispensing "+num+" $10 notes!!");
            if(rem>0 && nextChain != null)
            {
                nextChain.dispense(new Currency(rem));
            }
        } else if (nextChain != null) {
            nextChain.dispense(currency);
        }
    }
}
