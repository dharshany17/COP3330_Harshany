public class TaskItem {

    public boolean isStatus() {
        return status;
    }

    public void setStatusT() {
        this.status = true;
    }

    public void setStatusF() {
        this.status = false;
    }

    private String taskName;
    private String dueDate;
    private String description;
    private boolean status;

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskItem(String name, String due, String descr, boolean stat){
        this.taskName = name;
        this.dueDate = due;
        this.description = descr;
        this.status = stat;
    }

    @Override
    public String toString() {
        return "[" + dueDate + "] " + taskName + ": " + description;
    }

}
