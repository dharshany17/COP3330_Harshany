import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

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
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            String k = list.get(2).toString();
        });
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setDescription("My second task");

        assertEquals("My second task", list.get(0).getDescription());
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setDueDate("2020-11-22");

        assertEquals("2020-11-22", list.get(0).getDueDate());

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
    public void editingTaskItemTitleChangesValue() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        list.get(0).setTitle("Task 2");

        assertEquals("Task 2", list.get(0).getTitle());

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
            list.get(2).getTitle();
        });
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<TaskItem>();
        TaskItem addItem = new TaskItem("Task 1", "2010-11-22", "My first task", false);
        list.add(addItem);
        assertEquals("Task 1", list.get(0).getTitle());
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


}