import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setDescription("Second Task");

        assertEquals("Second Task", list.get(0).getDescription());

    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setDueDate("2020-11-22");

        assertEquals("2020-11-22", list.get(0).getDueDate());

    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setTitle("Task 2");

        assertEquals("Task 2", list.get(0).getTitle());

    }


    @Test
    public void constructorSucceedsWithValidDueDate() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);

        assertEquals("2010-11-22", addItem.getDueDate());

    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);

        assertEquals("Task 1", addItem.getTitle());

    }

    @Test
    public void constructorSucceedsWithValidDescription() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);

        assertEquals("My first task", addItem.getDescription());

    }





}