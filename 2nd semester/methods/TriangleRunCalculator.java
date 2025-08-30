import java.util.Scanner;

public class TriangleRunCalculator {

    // Method to calculate number of rounds needed to complete 5 km
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceToRun = 5000; // 5 km in meters
        return distanceToRun / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for sides of the triangle
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate number of rounds
        double rounds = calculateRounds(side1, side2, side3);

        // Display result
        System.out.printf("The athlete must complete %.2f rounds to finish a 5 km run.%n", rounds);

        scanner.close();
    }
}
