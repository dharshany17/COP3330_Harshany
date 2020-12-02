import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String mainMenuChoice;
        while (true) {
            displayAppMenu();
            mainMenuChoice = getMenuChoice();

            if (mainMenuChoice.contains("1") || mainMenuChoice.contains("task list")) {
               TaskApp taskApp;
               taskApp = new TaskApp();
               taskApp.taskMain();
            } else if (mainMenuChoice.contains("2") || mainMenuChoice.contains("contact list")) {
                ContactApp contactApp;
                contactApp = new ContactApp();
                contactApp.contactMain();
            } else if (mainMenuChoice.contains("3") || mainMenuChoice.contains("quit")) {
                break;
            } else {
                System.out.println("Invalid menu option");
            }
        }
    }


    private static void displayAppMenu() {
        System.out.println(" ");
        System.out.println("Select Your Application");
        System.out.println("---------");
        System.out.println(" ");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println(" ");
    }
    private static String getMenuChoice() {
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
