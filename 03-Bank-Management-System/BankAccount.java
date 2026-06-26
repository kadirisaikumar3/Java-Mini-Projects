public class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit Money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.println("Rs." + amount + " deposited successfully.");
    }

    // Withdraw Money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return;
        }

        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully.");
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance : Rs." + balance);
    }

    // Display Account Details
    public void displayAccount() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : Rs." + balance);
    }
}