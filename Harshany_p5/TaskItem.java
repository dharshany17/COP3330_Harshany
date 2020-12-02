public class TaskItem {

    private String title;
    private String dueDate;
    private String description;
    private boolean status;

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
       return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TaskItem(String title, String due, String descr, boolean status)throws IllegalArgumentException{
        if(title.length() == 0 ) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.dueDate = due;
        this.description = descr;
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + description + "] " + title + ": " + dueDate;
    }

    public void update(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;

    }


    public void setStatusT() {
        this.status = true;
    }

    public void setStatusF() {
        this.status = false;
    }


}

