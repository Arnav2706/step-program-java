public class FactorialForLoop {
    public static void main(String[] args) {
        System.out.println("Enter a positive integer:");
        int n = Integer.parseInt(System.console().readLine());

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + n + " is " + factorial);
    }
}
