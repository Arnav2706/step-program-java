public class NaturalNumberSumForLoop {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int n = Integer.parseInt(System.console().readLine());

        if (n > 0) {
            int sumFormula = n * (n + 1) / 2;

            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }

            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumLoop);
            System.out.println("Results match: " + (sumFormula == sumLoop));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
