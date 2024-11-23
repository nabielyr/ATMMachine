import java.io.IOException;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    int selection;
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    // validate login information customer number and pin number
    public void getLogin() throws IOException {
        int x = 1;

        do { 
            try {

                data.put(245150400, 382913);
                data.put(245010100, 721450);

                System.out.println("Welcome to Manja Bank");
                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(sc.nextInt());
                
                System.out.print("Enter Your Pin Number: ");
                setPinNumber(sc.nextInt());
            

            } catch (Exception e){
            System.out.println("" + "Invalid character(s). please input only numbers." + "\n");
            x = 2;
        }

        for (Entry<Integer, Integer> entry : data.entrySet()) {
            if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
                getAccountType();
            }
            x = 2;
        }

        if (x == 1) {
            System.out.println("Wrong customer number or pin number, please try again!\n");
        }

        } while (x == 1);
    }

    // display account type menu with selection
    public void getAccountType() {
        System.out.printf("\nSelect the account you want to access:\n");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Exit");
        System.out.print("Enter your selection: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
        
            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using Manja Bank! Have a nice day!");
                break;

            default:
                System.out.println("Invalid selection, please try again!");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("\nChecking Account: ");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Exit"); 
        System.out.print("Enter you selection: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
        
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3: 
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using Manja Bank! Have a nice day!");
                break;
            default:
                System.out.println("Invalid selection, please try again!");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("\nSaving Account: ");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Exit");
        System.out.print("Enter your selection: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using Manja Bank! Have a nice day!");
                break;
        
            default:
                System.out.println("Invalid selection, please try again!");
                getSaving();
        }
    }
}