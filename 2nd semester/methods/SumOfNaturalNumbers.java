import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to find the sum using a loop
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Check if input is valid
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            // Calculate and display the sum
            int sum = calculateSum(n);
            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }
}
