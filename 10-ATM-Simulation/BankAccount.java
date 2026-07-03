public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;
    private double totalDeposits;
    private double totalWithdrawals;

    // Constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.totalDeposits = 0;
        this.totalWithdrawals = 0;
    }

    // Getters
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }

    public double getTotalWithdrawals() {
        return totalWithdrawals;
    }

    // Deposit Money
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            totalDeposits += amount;
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    // Withdraw Money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            balance -= amount;
            totalWithdrawals += amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    // Display Summary
    public void displaySummary() {

        System.out.println("\n========== ACCOUNT SUMMARY ==========");

        System.out.println("Account Holder     : " + accountHolder);
        System.out.println("Account Number     : " + accountNumber);
        System.out.printf("Current Balance    : Rs%.2f%n", balance);
        System.out.printf("Total Deposits     : Rs%.2f%n", totalDeposits);
        System.out.printf("Total Withdrawals  : Rs%.2f%n", totalWithdrawals);
    }
}