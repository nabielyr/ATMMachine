import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    // set the customer number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    // get the customer number
    public int getCustomerNumber() {
        return customerNumber;
    }

    //  set pin number
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    // get pin number
    public int getPinNumber() {
        return pinNumber;
    }

    // get checking balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // get saving balance
    public double getSavingBalance() {
        return savingBalance;
    }

    // calculate checking balance withdraw
    public double calcCheckingBalanceWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    //calculate checking balance deposit
    public double calcCheckingBalanceDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    // calculate saving balance withdraw
    public double calcSavingBalanceWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    // calculate saving balance deposit
    public double calcSavingBalanceDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    // get checking withdraw
    public void getCheckingWithdrawInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = sc.nextDouble();

        if (checkingBalance - amount >= 0) {
            calcCheckingBalanceWithdraw(amount);
            System.out.println("Money withdrawn successfully!");
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient balance, please try again!");
        }
    }

    // get checking deposit
    public void getCheckingDepositInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to deposit: ");
        double amount = sc.nextDouble();

        if (checkingBalance + amount >= 0) {
            calcCheckingBalanceDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Deposit amount cannot be negative, please try again!");
        }
    }

    // get saving withdraw
    public void getSavingWithdrawInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = sc.nextDouble();

        if (savingBalance - amount >= 0) {
            calcSavingBalanceWithdraw(amount);
            System.out.println("Money withdrawn successfully!)");
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient balance, please try again!");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to deposit: ");
        double amount = sc.nextDouble();

        if (savingBalance + amount >= 0) {
            calcSavingBalanceDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Deposit amount cannot be negative, please try again!");
        }
    }
}
