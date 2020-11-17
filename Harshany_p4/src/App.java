import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        String menuChoice = "0";

        while (menuChoice != "3") {

            System.out.println(" ");
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println(" ");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");

            Scanner menuC = new Scanner(System.in);
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
                /*} catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }*/


            } else if (menuChoice.equals("3")) {
                System.exit(0);
            }
        }

    }

}
