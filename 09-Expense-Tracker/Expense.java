public class Expense {

    private int id;
    private String expenseName;
    private String category;
    private double amount;

    // Constructor
    public Expense(int id, String expenseName, String category, double amount) {
        this.id = id;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {

        return "Expense ID   : " + id +
               "\nExpense Name : " + expenseName +
               "\nCategory     : " + category +
               "\nAmount       : Rs" + String.format("%.2f", amount);
    }
}