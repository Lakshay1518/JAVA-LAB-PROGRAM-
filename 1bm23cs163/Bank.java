import java.util.Scanner;

abstract class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public abstract void withdraw(double amount);
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest deposited: " + interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Service charge applied: " + SERVICE_CHARGE);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter account number:");
        String accNumber = scanner.nextLine();

        System.out.println("Choose account type (1 for Savings, 2 for Current):");
        int accountType = scanner.nextInt();
        Account account;

        if (accountType == 1) {
            System.out.println("Enter interest rate:");
            double interestRate = scanner.nextDouble();
            account = new SavAcct(name, accNumber, interestRate);
        } else {
            account = new CurAcct(name, accNumber);
        }

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Display Balance\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}