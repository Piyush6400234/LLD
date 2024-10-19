package Behavioral.ChainOfResponsibility.ATMDispensers;
// Handler interface
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}
