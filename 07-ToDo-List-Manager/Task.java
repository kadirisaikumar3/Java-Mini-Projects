public class Task {

    private int id;
    private String taskName;
    private boolean completed;

    // Constructor
    public Task(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
        this.completed = false; // New task is pending by default
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {

        String status;

        if (completed) {
            status = "Completed";
        } else {
            status = "Pending";
        }

        return "Task ID      : " + id +
               "\nTask Name    : " + taskName +
               "\nStatus       : " + status;
    }
}