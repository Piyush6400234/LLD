package Behavioral.ChainOfResponsibility.ATMDispensers;

public class Dollar50Dispenser implements DispenseChain{
    DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain){
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency){
        if(currency.getAmount()>=50){
            int num = currency.getAmount()/50;
            int rem = currency.getAmount()%50;
            System.out.println("Dispensing "+num+" $50 notes!!");
            if(rem > 0 && nextChain != null){
                nextChain.dispense(new Currency(rem));
            }
        } else if (nextChain != null) {
            nextChain.dispense(currency);

        }
    }
}
