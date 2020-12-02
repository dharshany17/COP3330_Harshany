import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TaskList {

    private List<TaskItem> items;

    public TaskList() {
        this.items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public void add(TaskItem item) {
        items.add(item);
    }

    public TaskItem get(int index) {
        return items.get(index);
    }

    public void remove(int index) {
        items.remove(index);
    }


    public String view() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if (item.isStatus()) {
                sb.append(String.format("%d) *** %s%n", i, item));
            } else {
                sb.append(String.format("%d) %s%n", i, item));
            }
        }
        return sb.toString();
    }

    public String viewCompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if (item.isStatus())
                sb.append(String.format("%d) %s%n", i, item));
        }
        return sb.toString();
    }

    public String viewUncompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if (!item.isStatus())
                sb.append(String.format("%d) %s%n", i, item));
        }

        return sb.toString();
    }


    public void update(int index, String title, String description, String dueDate) {
        this.get(index).update(title, description, dueDate);
    }

    public void save(String filename) {
        try (Formatter output = new Formatter(filename)) {
            output.format("tasks%n");
            for (TaskItem item : items) {
                output.format("%s%n", item.getDueDate());
                output.format("%s%n", item.getTitle());
                output.format("%s%n", item.getDescription());
                if (item.isStatus()) {
                    output.format("Complete%n");
                } else {
                    output.format("incomplete%n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        List<TaskItem> backupList = items;

        items = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get(filename))) {
            String header = input.nextLine();
            if (header.equalsIgnoreCase("tasks")) {
                while (input.hasNext()) {
                    String dueDate = input.nextLine();
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String status = input.nextLine();

                    TaskItem item = new TaskItem(title, description, dueDate, false);
                    this.add(item);
                }
            } else {
                items = backupList;
                throw new InputMismatchException("Warning: filename is not valid");
            }
        } catch (FileNotFoundException e) {
            items = backupList;
            throw new InputMismatchException("Warning: file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



