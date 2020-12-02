import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {


    Scanner input = new Scanner(System.in);
    private TaskList taskList;



        public void taskMain() {
            String mainMenuChoice;
            while (true) {
                displayMainMenu();
                mainMenuChoice = getMenuChoice();

                if (mainMenuChoice.contains("1") || mainMenuChoice.contains("create")) {
                    createList();
                    modifyList();
                } else if (mainMenuChoice.contains("2") || mainMenuChoice.contains("load")) {
                    try {
                        loadList();
                        modifyList();
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (mainMenuChoice.contains("3") || mainMenuChoice.contains("quit")) {
                    break;
                } else {
                    System.out.println("Invalid menu option");
                }
            }
        }

        private void displayMainMenu () {
            System.out.println(" ");
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            System.out.println(" ");
        }

        private String getMenuChoice () {
            System.out.print("> ");
            return input.nextLine();
        }

        private void createList () {
            taskList = new TaskList();
            System.out.println("new task list has been created");
        }

        private void loadList () {
            System.out.println("Enter the filename to load: ");
            String filename = input.nextLine();

            taskList = new TaskList();
            taskList.load(filename);

            System.out.println("task list has been loaded");
        }

        private void modifyList () {
            String taskMenuChoice;
            while (true) {
                displayOperationMenu();
                taskMenuChoice = getMenuChoice();

                if (taskMenuChoice.contains("1") || taskMenuChoice.contains("view")) {
                    displayItems();
                } else if (taskMenuChoice.contains("2") || taskMenuChoice.contains("add")) {
                    addItem();
                } else if (taskMenuChoice.contains("3") || taskMenuChoice.contains("edit")) {
                    if (taskList.size() > 0) {
                        editItem();
                    } else {
                        System.out.println("no tasks to edit");
                    }
                } else if (taskMenuChoice.contains("4") || taskMenuChoice.contains("remove")) {
                    if (taskList.size() > 0) {
                        removeItem();
                    } else {
                        System.out.println("no tasks to remove");
                    }
                } else if (taskMenuChoice.contains("5") || taskMenuChoice.contains("mark")) {
                    if (taskList.size() > 0) {
                        markItem();
                    } else {
                        System.out.println("no tasks to mark");
                    }
                } else if (taskMenuChoice.contains("6") || taskMenuChoice.contains("unmark")) {
                    if (taskList.size() > 0) {
                        unmarkItem();
                    } else {
                        System.out.println("no tasks to unmarks");
                    }
                } else if (taskMenuChoice.contains("7") || taskMenuChoice.contains("save")) {
                    if (taskList.size() > 0) {
                        saveItems();
                    } else {
                        System.out.println("no tasks to save");
                    }
                } else if (taskMenuChoice.contains("8") || taskMenuChoice.contains("quit")) {
                    break;
                } else {
                    System.out.println("Invalid menu option");
                }
            }

        }

        public void displayOperationMenu () {
            System.out.println(" ");
            System.out.println("List Operation Menu");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) mark an item as uncompleted");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the main menu");
            System.out.println(" ");
        }

        private void displayItems () {
            System.out.println(" ");
            System.out.println("Current Tasks");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println(taskList.view());
            System.out.println(" ");
        }

        private void addItem () {
            System.out.println("Task title: ");
            String title = input.nextLine();

            System.out.println("Task description: ");
            String description = input.nextLine();

            System.out.println("Task due date (YYYY-MM-DD): ");
            String dueDate = input.nextLine();

            try {
                taskList.add(new TaskItem(title, description, dueDate, false));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid task");
            }
        }

        private void editItem () {
            displayItems();
            System.out.print("Which task will you edit? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < taskList.size()) {
                System.out.printf("Enter a new title for task %d: ", index);
                String title = input.nextLine();

                System.out.printf("Enter a new description for task %d: ", index);
                String description = input.nextLine();

                System.out.printf("Enter a new task date (YYYY-MM-DD) for task %d: ", index);
                String dueDate = input.nextLine();

                try {
                    taskList.update(index, title, description, dueDate);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Warning: invalid task number");
            }
        }

        private void removeItem () {
            displayItems();

            System.out.println("Which item would you like to remove? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < taskList.size()) {
                taskList.remove(index);
            } else {
                System.out.println("Warning: invalid task number");
            }
        }

        private void markItem () {
            displayUncompletedItems();

            System.out.println("Which item would you like to mark as completed? ");
            int index = input.nextInt();
            input.nextLine();

            if (index >= taskList.size()) {
                System.out.println("Warning: invalid task number");
            }
            else {
                taskList.get(index).setStatusT();
            }
        }

        private void displayCompletedItems () {
            System.out.println(" ");
            System.out.println("Completed Tasks");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println(taskList.viewCompletedTasks());
            System.out.println(" ");
        }

        private void unmarkItem () {
            displayCompletedItems();

            System.out.println("Which item would you like to mark as incomplete? ");
            int index = input.nextInt();
            input.nextLine();

            if (index >= taskList.size()) {
                System.out.println("Warning: invalid task number");
            }
            else {
                taskList.get(index).setStatusF();
            }
        }

        private void displayUncompletedItems () {
            System.out.println(" ");
            System.out.println("Uncompleted Tasks");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println(taskList.viewUncompletedTasks());
            System.out.println(" ");
        }

        private void saveItems () {
            if (taskList.size() > 0) {
                System.out.print("Enter the filename to save as: ");
                String filename = input.nextLine();
                taskList.save(filename);

                System.out.println("task list has been saved");
            } else {
                System.out.println("no tasks to save");
            }
        }

    }








               /* Scanner menuC = new Scanner(System.in);
                menuChoice = menuC.next();

                if (menuChoice.equals("1")) {

                    TaskList newList = new TaskList();
                    newList.listMenu();

                } else if (menuChoice.equals("2")) {
                    //reading text into and assign to string variables
                    //try {
                    System.out.println("Enter file name (ex: file.txt) ");
                    Scanner k = new Scanner(System.in);
                    String j = k.nextLine();
                    File file = new File(j);
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();

                }
            }*/
