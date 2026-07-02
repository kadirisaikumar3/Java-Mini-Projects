import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Show Total Expenses");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    searchExpense();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    showTotalExpenses();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Expense
    static void addExpense() {

        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Expense Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        expenses.add(new Expense(id, name, category, amount));

        System.out.println("Expense Added Successfully!");
    }

    // View Expenses
    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No Expenses Found.");
            return;
        }

        for (Expense expense : expenses) {
            System.out.println("---------------------------");
            System.out.println(expense);
        }
    }

    // Search Expense
    static void searchExpense() {

        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                System.out.println("Expense Found");
                System.out.println(expense);
                return;
            }
        }

        System.out.println("Expense Not Found.");
    }

    // Delete Expense
    static void deleteExpense() {

        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                expenses.remove(expense);
                System.out.println("Expense Deleted Successfully!");
                return;
            }
        }

        System.out.println("Expense Not Found.");
    }

    // Show Total Expenses
    static void showTotalExpenses() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        System.out.printf("Total Expenses: Rs%.2f%n", total);
    }
}