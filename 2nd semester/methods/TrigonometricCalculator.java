import java.util.Scanner;

public class TrigonometricCalculator {

    // Method to calculate sine, cosine, and tangent of an angle in degrees
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle); // Convert to radians
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[] {sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input angle in degrees
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();

        // Calculate trig functions
        double[] results = calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.printf("Sine of %.2f° = %.4f%n", angle, results[0]);
        System.out.printf("Cosine of %.2f° = %.4f%n", angle, results[1]);
        System.out.printf("Tangent of %.2f° = %.4f%n", angle, results[2]);

        scanner.close();
    }
}
