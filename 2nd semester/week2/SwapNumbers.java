class SwapNumbers {
    public static void main(String[] args) {
        System.out.println("Enter first number:");
        int number1 = Integer.parseInt(System.console().readLine());
        System.out.println("Enter second number:");
        int number2 = Integer.parseInt(System.console().readLine());
        // Swap using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;
        // Display result
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
