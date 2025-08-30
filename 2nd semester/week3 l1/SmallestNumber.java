public class SmallestNumber {
    public static void main(String[] args) {
        System.out.println("Enter three numbers:");
        int number1 = Integer.parseInt(System.console().readLine());
        int number2 = Integer.parseInt(System.console().readLine());
        int number3 = Integer.parseInt(System.console().readLine());
        System.out.println("Is the first number the smallest? " + (number1 < number2 && number1 < number3));
    }
}
