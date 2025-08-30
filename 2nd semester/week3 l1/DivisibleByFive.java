public class DivisibleByFive {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));
    }
}
