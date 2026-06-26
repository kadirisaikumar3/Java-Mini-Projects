import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = null;

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    if (account != null) {
                        System.out.println("Account already exists.");
                        break;
                    }

                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    account = new BankAccount(accountNumber, accountHolder, balance);

                    System.out.println("Account Created Successfully!");
                    break;

                case 2:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 3:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 4:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    account.checkBalance();
                    break;

                case 5:

                    if (account == null) {
                        System.out.println("Please create an account first.");
                        break;
                    }

                    account.displayAccount();
                    break;

                case 6:

                    System.out.println("Thank you for using Bank Management System!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}