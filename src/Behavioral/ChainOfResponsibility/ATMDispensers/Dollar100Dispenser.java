package Behavioral.ChainOfResponsibility.ATMDispensers;

public class Dollar100Dispenser implements DispenseChain{
    DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain){
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency){
        if(currency.getAmount() >=100)
        {
            int num = currency.getAmount()/100;
            System.out.println("Dispensing "+num+" $100 notes!!");
            int rem = currency.getAmount()%100;
            if(rem > 0 && nextChain != null){
                nextChain.dispense(new Currency(rem));
            }

        } else if (nextChain != null) {
            nextChain.dispense(currency);
        }

    }
}
