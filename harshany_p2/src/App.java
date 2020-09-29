import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        BodyMassIndex.bmi();



    }

    private static boolean moreInput() {
        Scanner myObj = new Scanner(System.in);
                System.out.println("Enter Y or N");
                String choice = myObj.next();

                if (choice.equals("Y")) {
                    return true;
                }
                else if (choice.equals("N")){
                    return false;
                }
                else{
                    return moreInput();
                }

    }

    private static double getUserWeight() {
        Scanner userWeight = new Scanner(System.in);
        System.out.println("Enter weight in pounds");
        double weight = userWeight.nextDouble();

        if (weight < 0) {
            System.out.println("weight can not be negative");
            return getUserWeight();
        }
        return weight;
    }

        private static double getUserHeight() {
            Scanner userHeight = new Scanner(System.in);
            System.out.println("Enter height in inches");
            double height = userHeight.nextDouble();

            if (height < 0) {
                System.out.println("height can not be negative");
                return getUserHeight();
            }
            return height;
        }
    }
