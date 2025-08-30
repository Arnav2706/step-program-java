import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][2]; // First column: weight, Second column: height (cm)

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ": ");
            teamData[i][0] = scanner.nextDouble();
            System.out.println("Enter height (cm) for person " + (i + 1) + ": ");
            teamData[i][1] = scanner.nextDouble();
        }

        String[][] resultData = computeBMI(teamData);
        displayResults(resultData);
    }

    public static String[][] computeBMI(double[][] teamData) {
        String[][] resultData = new String[10][4]; // Columns: height, weight, BMI, status

        for (int i = 0; i < 10; i++) {
            double weight = teamData[i][0];
            double heightMeters = teamData[i][1] / 100.0; // Convert cm to meters
            double bmi = weight / (heightMeters * heightMeters);
            String status = getBMIStatus(bmi);

            resultData[i][0] = String.format("%.2f cm", teamData[i][1]);
            resultData[i][1] = String.format("%.2f kg", teamData[i][0]);
            resultData[i][2] = String.format("%.2f", bmi);
            resultData[i][3] = status;
        }

        return resultData;
    }

    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        else if (bmi >= 25.0 && bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void displayResults(String[][] resultData) {
        System.out.println("\nBMI Results:");
        System.out.println("Height    | Weight   | BMI    | Status");
        System.out.println("---------------------------------------");

        for (String[] row : resultData) {
            System.out.printf("%-9s | %-8s | %-6s | %s%n", row[0], row[1], row[2], row[3]);
        }
    }
}
