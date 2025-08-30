import java.util.Scanner;

public class BMIProgram {
    // Method to compute BMI and status
    public static String[] computeBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // cm to m
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";
        return new String[] {
            String.format("%.2f", heightCm),
            String.format("%.2f", weight),
            String.format("%.2f", bmi),
            status
        };
    }

    // Method to process all persons
    public static String[][] processAll(double[][] hw) {
        String[][] result = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            result[i] = computeBMIStatus(hw[i][0], hw[i][1]);
        }
        return result;
    }

    // Display method
    public static void display(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hw = new double[10][2]; // [person][0=weight, 1=height]
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            hw[i][0] = sc.nextDouble();
            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            hw[i][1] = sc.nextDouble();
        }
        String[][] results = processAll(hw);
        display(results);
        sc.close();
    }
}
