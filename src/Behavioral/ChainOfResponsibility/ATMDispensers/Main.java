package Behavioral.ChainOfResponsibility.ATMDispensers;
/*
In this use case:

--->The ATM needs to dispense a specific amount of money.
--->The money will be dispensed in various denominations, such as 100s, 50s, and 20s bills.
--->The ATM should try to dispense the largest denomination first, and if that’s not possible (due to the remaining
    balance), it moves to the next denomination, and so on.

*/
public class Main {
    public static void main(String[] args) {
        DispenseChain dispense100 = new Dollar100Dispenser();
        DispenseChain dispense50 = new Dollar50Dispenser();
        DispenseChain dispense10 = new Dollar10Dispenser();
        dispense100.setNextChain(dispense50);
        dispense50.setNextChain(dispense10);

        dispense100.dispense(new Currency(170));

    }
}
