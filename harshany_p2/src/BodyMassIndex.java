import static java.lang.Math.pow;

public class BodyMassIndex {
    static double bmi;
    public BodyMassIndex(double height, double weight) {


        double a = (703 * weight);
        double b = pow(height,2);
        bmi = a / b;

        returnBMI(bmi);
        BodyMassCategory(bmi);
    }

    public static void bmi() {
        System.out.println(bmi);
    }

    private double returnBMI(double bmi) {
        return bmi;
    }


    public void BodyMassCategory(double bmi) {
        if (bmi < 18.5) {
            System.out.println("Underweight");
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal Weight");
        }
        else if (bmi >= 25 && bmi <= 29.9) {

            System.out.println("Overweight");
        }
        else if (bmi >= 30) {
            System.out.println("Obesity");
        }
        else {
            System.out.println("Error");
        }
    }
}