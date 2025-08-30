public class OddEvenArrays {
    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        int number = Integer.parseInt(System.console().readLine());

        if (number < 1) {
            System.out.println("Error: Enter a natural number (>= 1).");
            return;
        }

        int evenSize = number / 2;
        int oddSize = number / 2 + 1;
        int[] evenNumbers = new int[evenSize];
        int[] oddNumbers = new int[oddSize];
        int evenIndex = 0, oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println("\nEven numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
    }
}
