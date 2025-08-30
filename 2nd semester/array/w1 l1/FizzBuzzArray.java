public class FizzBuzzArray {
    public static void main(String[] args) {
        System.out.println("Enter a positive integer:");
        int number = Integer.parseInt(System.console().readLine());

        if (number < 1) {
            System.out.println("Error: Enter a positive integer.");
            return;
        }

        String[] results = new String[number];

        for (int i = 0; i < number; i++) {
            int value = i + 1;
            if (value % 3 == 0 && value % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (value % 3 == 0) {
                results[i] = "Fizz";
            } else if (value % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(value);
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }
    }
}
