import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== EMPLOYEE PAYROLL SYSTEM ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Payroll Summary");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    calculateSalary();
                    break;

                case 4:
                    payrollSummary();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, department, salary));

        System.out.println("Employee Added Successfully!");
    }

    // View Employees
    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("----------------------------");
            System.out.println(employee);
        }
    }

    // Calculate Salary
    static void calculateSalary() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == id) {

                System.out.println("\n========== SALARY DETAILS ==========");
                System.out.println("Employee ID   : " + employee.getEmployeeId());
                System.out.println("Employee Name : " + employee.getEmployeeName());
                System.out.printf("Basic Salary  : Rs%.2f%n", employee.getBasicSalary());
                System.out.printf("Bonus         : Rs%.2f%n", employee.getBonus());
                System.out.printf("Net Salary    : Rs%.2f%n", employee.getNetSalary());

                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Payroll Summary
    static void payrollSummary() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        double totalPayroll = 0;

        for (Employee employee : employees) {
            totalPayroll += employee.getNetSalary();
        }

        System.out.println("\n========== PAYROLL SUMMARY ==========");
        System.out.println("Total Employees : " + employees.size());
        System.out.printf("Total Payroll   : Rs%.2f%n", totalPayroll);
    }
}