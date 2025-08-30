public class Calculator {
    public static void main(String[] args) {
        System.out.println("Enter first number:");
        double first = Double.parseDouble(System.console().readLine());
        System.out.println("Enter second number:");
        double second = Double.parseDouble(System.console().readLine());
        System.out.println("Enter operator (+, -, *, /):");
        String op = System.console().readLine();
        
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
    }
}
