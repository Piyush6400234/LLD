package Applications.ATM;

import Applications.ATM.ATMStates.ATMStates;
import Applications.ATM.ATMStates.*;

public class ATM {
    private static ATM atmObject = new ATM(); //Singleton: eager initialization
    ATMStates currentState;
    private int atmBalance;
    private int numOfThousandNotes;
    private int numOfFiveHundredNotes;
    private int numOfOneHundredNotes;

    private ATM(){

    }
    public void setCurrentState(ATMStates state){
        this.currentState = state;
    }
    public ATMStates getCurrentState(){
        return this.currentState;
    }
    public static ATM getAtmObject(){
        atmObject.setCurrentState(new IdleState());
        return atmObject;
    }
    public int getAtmBalance(){
        return this.atmBalance;
    }
    public void setAtmBalance(int atmBalance, int numOfFiveHundredNotes, int numOfOneHundredNotes, int numOfThousandNotes){
        this.atmBalance = atmBalance;
        this.numOfFiveHundredNotes = numOfFiveHundredNotes;
        this.numOfThousandNotes = numOfThousandNotes;
        this.numOfOneHundredNotes = numOfOneHundredNotes;
    }
    public int getNumOfThousandNotes(){
        return numOfThousandNotes;
    }
    public int getNumOfFiveHundredNotes(){
        return numOfFiveHundredNotes;
    }
    public int getNumOfOneHundredNotes(){
        return numOfOneHundredNotes;
    }
    public void deductATMBalance(int amt){
        this.atmBalance-= amt;
    }
    public void deductOneHundredNotes(int numb){
        numOfOneHundredNotes-= numb;
    }
    public void deductThousandNotes(int numb){
        numOfThousandNotes-= numb;
    }
    public void deductFiveHundredNotes(int numb){
        numOfFiveHundredNotes-= numb;
    }
    public void printATMState(){
        System.out.println("Balance: "+atmBalance);
        System.out.println("1KNotes: "+numOfThousandNotes);
        System.out.println("500 notes: "+numOfFiveHundredNotes);
        System.out.println("100 notes: "+numOfOneHundredNotes);
    }
}