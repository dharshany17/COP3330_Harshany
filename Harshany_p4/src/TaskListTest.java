import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IndexOutOfBoundsException.class, () -> { TaskItem addItem = new TaskItem("Task 1", "2010-11-222", "My first task", false); });
        //done
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskItem addItem = new TaskItem("", "2010-11-22", "My first task", false);
        });
        //done
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        assertEquals("2010-11-22", addItem.getDueDate());
        //done
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        assertEquals("Task 1", addItem.getTaskName());
        //done
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            addItem.setDueDate("2020-11-222");});
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        addItem.setDueDate("2020-11-22");
        assertEquals("2020-11-22", addItem.getDueDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        assertThrows(InvalidPropertiesFormatException.class, () -> {
            addItem.setTaskName("");});
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        addItem.setTaskName("Task 2");
        assertEquals("Task 2", addItem.getTaskName());
    }

    @Test
    public void addingTaskItemsIncreasesSize() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals(1, list.size());
        //done
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        addItem.setStatusT();
        assertEquals(true, addItem.isStatus());
        //done
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1).setStatusT();
        });
        //done

    }

    @Test
    public void editingTaskItemChangesValues() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        String k = list.get(0).toString();
        int f = Integer.parseInt(k);

        addItem = new TaskItem("Task 2", "2000-7-11", "My second task", false);

        list.set(f, addItem);
        assertEquals("Task 2", addItem.getTaskName());
        assertEquals("2000-7-11", addItem.getDueDate());
        assertEquals("My second task", addItem.getDescription());
        assertEquals(false, addItem.isStatus());

    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        String k = list.get(0).toString();
        int f = Integer.parseInt(k);

        addItem = new TaskItem("Task 1", "2010-11-22", "My second task", false);

        list.set(f, addItem);
        assertEquals("Task 1", addItem.getTaskName());
        assertEquals("2010-11-22", addItem.getDueDate());
        assertEquals("My second task", addItem.getDescription());
        assertEquals(false, addItem.isStatus());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            String k = list.get(2).toString();
        });
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        String k = list.get(0).toString();
        int f = Integer.parseInt(k);

        addItem = new TaskItem("Task 1", "2000-7-11", "My first task", false);

        list.set(f, addItem);
        assertEquals("Task 1", addItem.getTaskName());
        assertEquals("2000-7-11", addItem.getDueDate());
        assertEquals("My first task", addItem.getDescription());
        assertEquals(false, addItem.isStatus());

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            String k = list.get(2).toString();
        });
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        String k = list.get(0).toString();
        int f = Integer.parseInt(k);

        addItem = new TaskItem("Task 2", "2010-11-22", "My first task", false);

        list.set(f, addItem);
        assertEquals("Task 2", addItem.getTaskName());
        assertEquals("2010-11-22", addItem.getDueDate());
        assertEquals("My first task", addItem.getDescription());
        assertEquals(false, addItem.isStatus());

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            String k = list.get(2).toString();
        });
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2).getDescription();
        });
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals("My first task", list.get(0).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(2).getDueDate(); });
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals("2010-11-22", list.get(0).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2).getTaskName();
        });
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals("Task 1", list.get(0).getTaskName());
    }

    @Test
    public void newTaskListIsEmpty() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        assertEquals(0, list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.remove(2);});
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", true);
        addItem.setStatusF();
        assertEquals(false, addItem.isStatus());

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", true);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1).setStatusT();
        });


    }

    @Test
    public void gettingTaskItemStatusFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(2).isStatus(); });
    }

    @Test
    public void gettingTaskItemStatusSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals(false, list.get(0).isStatus());
    }


    }


