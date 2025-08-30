public class LargestNumber {
    public static void main(String[] args) {
        System.out.println("Enter three numbers:");
        int number1 = Integer.parseInt(System.console().readLine());
        int number2 = Integer.parseInt(System.console().readLine());
        int number3 = Integer.parseInt(System.console().readLine());

        System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3));
        System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3));
        System.out.println("Is the third number the largest? " + (number3 > number1 && number3 > number2));
    }
}
