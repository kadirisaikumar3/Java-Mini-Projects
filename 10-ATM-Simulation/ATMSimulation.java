import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Bank Account
        BankAccount account = new BankAccount(
                "Sai Kumar",
                123456789,
                10000.00);

        while (true) {

            System.out.println("\n========== ATM SIMULATION ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction Summary");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.printf("Current Balance : ₹%.2f%n",
                            account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ₹");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);

                    System.out.printf("Current Balance : ₹%.2f%n",
                            account.getBalance());
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ₹");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);

                    System.out.printf("Current Balance : ₹%.2f%n",
                            account.getBalance());
                    break;

                case 4:
                    account.displaySummary();
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}