package Applications.splitwise;

import java.util.*;

// Every user has UserExpenseBalanceSheet and this class has a list off all the friends who took part in  bill splliting
public class UserExpenseBalanceSheet {
    /*
    suppose we've a Balance object for "user1", in  ExpenseBalanceSheet Map of "User"
    user1 -> Balance(amountOwe=500, amountGetBack=600)  implies => 1). user owes "user1" 500 -- "user" has to give "user1" 500  2)."user" has to get back 600 from "user1"
    */
    Map<String, Balance> userVsBalance;
    double totalYourExpense;

    double totalPayment;

    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
