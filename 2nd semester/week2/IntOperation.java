class IntOperation {
    public static void main(String[] args) {
        System.out.println("Enter value for a:");
        int a = Integer.parseInt(System.console().readLine());

        System.out.println("Enter value for b:");
        int b = Integer.parseInt(System.console().readLine());

        System.out.println("Enter value for c:");
        int c = Integer.parseInt(System.console().readLine());

        // Perform integer operations
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;

        // Display results
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", and " + result3);
    }
}
