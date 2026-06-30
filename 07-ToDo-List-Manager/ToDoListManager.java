import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== TO-DO LIST MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Task
    static void addTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Name: ");
        String taskName = sc.nextLine();

        tasks.add(new Task(id, taskName));

        System.out.println("Task Added Successfully!");
    }

    // View Tasks
    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Found.");
            return;
        }

        for (Task task : tasks) {
            System.out.println("-------------------------");
            System.out.println(task);
        }
    }

    // Mark Task as Completed
    static void completeTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        for (Task task : tasks) {

            if (task.getId() == id) {

                if (task.isCompleted()) {
                    System.out.println("Task is already completed.");
                } else {
                    task.setCompleted(true);
                    System.out.println("Task Marked as Completed!");
                }

                return;
            }
        }

        System.out.println("Task Not Found.");
    }

    // Delete Task
    static void deleteTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        for (Task task : tasks) {

            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task Deleted Successfully!");
                return;
            }
        }

        System.out.println("Task Not Found.");
    }
}