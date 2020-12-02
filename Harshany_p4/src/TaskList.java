import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

    public class TaskList {

        ArrayList<TaskItem> list = new ArrayList<TaskItem>();

        public void listMenu() {

            String userChoice = "0";


            while (userChoice != "8") {

                System.out.println(" ");
                System.out.println("List Operation Menu");
                System.out.println("---------");
                System.out.println(" ");
                System.out.println("1) view the list");
                System.out.println("2) add an item");
                System.out.println("3) edit an item");
                System.out.println("4) remove an item");
                System.out.println("5) mark an item as completed");
                System.out.println("6) unmark an item as completed");
                System.out.println("7) save the current list");
                System.out.println("8) quit to the main menu");


                Scanner choice = new Scanner(System.in);
                userChoice = choice.next();


                if (userChoice.equals("1")) {
                    choiceOne();
                }

                else if (userChoice.equals("2")) {
                    choiceTwo();
                }

                else if (userChoice.equals("3")) {
                    choiceThree();
                }

                else if (userChoice.equals("4")) {
                    choiceFour();
                }

                else if (userChoice.equals("5")) {
                    choiceFive();
                }

                else if (userChoice.equals("6")) {
                    choiceSix();
                }

                else if (userChoice.equals("7")) {
                    choiceSeven();
                }
                else if(userChoice.equals("8")){
                    break;
                }

            }


        }

        public void choiceOne() {

            System.out.println(" ");
            System.out.println("Current Tasks");
            System.out.println("---------");
            System.out.println(" ");

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isStatus()){
                    System.out.print(i + ") *** ");
                    System.out.println(list.get(i).toString());
                }
                else {
                    System.out.print(i + ") ");
                    System.out.println(list.get(i).toString());
                }
            }
        }
        public void choiceTwo(){
            //add an item

            System.out.println("Task title: ");
            Scanner name = new Scanner(System.in);
            String itemName = name.nextLine();
            if (itemName.length() < 1){
                System.out.println("Title must be at least one character long");
                return;
            }

            System.out.println("Task description: ");
            Scanner description = new Scanner(System.in);
            String itemDescription = description.nextLine();
            if (itemName.length() < 0){
                System.out.println("How did you get here?");
                return;
            }

            System.out.println("Task due date (YYYY-MM-DD): ");
            Scanner dueDate = new Scanner(System.in);
            String  aString = dueDate.nextLine();
            String itemDueDate = aString.substring(0, 10);


            // boolean b = Pattern.matches("****-**-**", "2000-10-24");



            TaskItem addItem = new TaskItem(itemName, itemDueDate, itemDescription, false);

            System.out.println(addItem.toString());

            list.add(addItem);


        }

        public void choiceThree(){
            //edit an item
            choiceOne();

            Scanner choice = new Scanner(System.in);
            System.out.println("Which task will you edit?");
            int k = choice.nextInt();
       /* try {
            while (choice.nextInt() > list.size()){
                continue;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Selection is out of bounds");
            return;
        }*/

            System.out.println("Enter a new title for task " + k + ": ");
            Scanner name = new Scanner(System.in);
            String itemName = name.nextLine();
            if (itemName.length() < 1){
                System.out.println("Title must be at least one character long");
                return;
            }

            System.out.println("Enter a new description for task " + k + ": ");
            Scanner description = new Scanner(System.in);
            String itemDescription = description.nextLine();
            if (itemName.length() < 0){
                System.out.println("How did you get here?");
                return;
            }

            System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + k + ": ");
            Scanner dueDate = new Scanner(System.in);
            String  aString = dueDate.nextLine();
            String itemDueDate = aString.substring(0, 10);

            TaskItem addItem = new TaskItem(itemName, itemDueDate, itemDescription, false);

            System.out.println(addItem.toString());

            list.set(k, addItem);


        }

        public void choiceFour(){
            //remove an item
            choiceOne();

            Scanner choice = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Which task will you remove?");
            int k = choice.nextInt();
            list.remove(k);

        }




        public void choiceFive(){
            //mark complete
            System.out.println(" ");
            System.out.println("Uncompleted Tasks");
            System.out.println("---------");
            System.out.println(" ");

            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isStatus()){
                    System.out.print(i + ") ");
                    System.out.println(list.get(i).toString());
                }

            }

            Scanner choice = new Scanner(System.in);
            System.out.println("Which task will you mark as completed? ");
            int k = choice.nextInt();

            list.get(k).setStatusT();

        }
        public void choiceSix(){
            //unmark
            System.out.println(" ");
            System.out.println("Completed Tasks");
            System.out.println("---------");
            System.out.println(" ");

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isStatus()){
                    System.out.print(i + ") ");
                    System.out.println(list.get(i).toString());
                }

            }

            Scanner choice = new Scanner(System.in);
            System.out.println("Which task will you mark as Uncompleted? ");
            int k = choice.nextInt();

            list.get(k).setStatusF();
        }


        public void choiceSeven() {
            //save the list
            Scanner fileName = new Scanner(System.in);
            System.out.println("Enter the file name to save as: ");
            String name = fileName.nextLine();
            File file = new File(name);

            try {
                FileWriter myWriter = new FileWriter(file);
                myWriter.write(String.valueOf(list));
                myWriter.close();
                System.out.println("task list has been saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

