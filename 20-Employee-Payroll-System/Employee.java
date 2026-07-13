public class Employee {

    private int employeeId;
    private String employeeName;
    private String department;
    private double basicSalary;

    // Constructor
    public Employee(int employeeId, String employeeName,
                    String department, double basicSalary) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Calculate Bonus
    public double getBonus() {

        if (basicSalary >= 50000)
            return 5000;
        else
            return 2000;
    }

    // Calculate Net Salary
    public double getNetSalary() {
        return basicSalary + getBonus();
    }

    @Override
    public String toString() {

        return "Employee ID   : " + employeeId +
               "\nEmployee Name : " + employeeName +
               "\nDepartment    : " + department +
               "\nBasic Salary  : Rs" + String.format("%.2f", basicSalary);
    }
}