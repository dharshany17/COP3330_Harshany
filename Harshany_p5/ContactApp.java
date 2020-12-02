import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {


        Scanner input = new Scanner(System.in);
        private ContactList contactList;



        public void contactMain() {
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
            contactList = new ContactList();
            System.out.println("new contact list has been created");
        }

        private void loadList () {
            System.out.println("Enter the filename to load: ");
            String filename = input.nextLine();

            contactList = new ContactList();
            contactList.load(filename);

            System.out.println("contact list has been loaded");
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
                    if (contactList.size() > 0) {
                        editItem();
                    } else {
                        System.out.println("no contacts to edit");
                    }
                } else if (taskMenuChoice.contains("4") || taskMenuChoice.contains("remove")) {
                    if (contactList.size() > 0) {
                        removeItem();
                    } else {
                        System.out.println("no contacts to remove");
                    }

                } else if (taskMenuChoice.contains("5") || taskMenuChoice.contains("save")) {
                    if (contactList.size() > 0) {
                        saveItems();
                    } else {
                        System.out.println("no contacts to save");
                    }
                } else if (taskMenuChoice.contains("6") || taskMenuChoice.contains("quit")) {
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
            System.out.println("5) save the current list");
            System.out.println("6) quit to the main menu");
            System.out.println(" ");
        }

        private void displayItems () {
            System.out.println(" ");
            System.out.println("Current Contacts");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println(contactList.view());
            System.out.println(" ");
        }

        private void addItem () {
            System.out.println("First name: ");
            String firstName = input.nextLine();

            System.out.println("Last name: ");
            String lastName = input.nextLine();

            System.out.println("Phone number (xxx-xxx-xxxx): ");
            String phone = input.nextLine();

            System.out.println("Email address (x@y.z): ");
            String email = input.nextLine();

            try {

                contactList.add(new ContactItem(firstName, lastName, phone, email));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        private void editItem () {
            displayItems();
            System.out.print("Which contact will you edit? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < contactList.size()) {
                System.out.printf("Enter a new first name for contact %d: ", index);
                String firstName = input.nextLine();

                System.out.printf("Enter a new last Name for contact %d: ", index);
                String lastName = input.nextLine();

                System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", index);
                String phone = input.nextLine();

                System.out.printf("Enter a new email address (x@y.z) for contact %d: ", index);
                String email = input.nextLine();

                try {
                    contactList.update(index, firstName, lastName, phone, email);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                catch( IndexOutOfBoundsException e){
                    System.out.println("hdhdh");
                }
            } else {
                System.out.println("Warning: invalid contact number");
            }
        }

        private void removeItem () {
            displayItems();

            System.out.println("Which contact would you like to remove? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < contactList.size()) {
                contactList.remove(index);
            } else {
                System.out.println("Warning: invalid contact number");
            }
        }

        private void saveItems () {
            if (contactList.size() > 0) {
                System.out.print("Enter the filename to save as: ");
                String filename = input.nextLine();
                contactList.save(filename);

                System.out.println("contact list has been saved");
            } else {
                System.out.println("no contacts to save");
            }
        }

    }
