public class PowerCalculator {
    public static void main(String[] args) {
        System.out.println("Enter base number:");
        int number = Integer.parseInt(System.console().readLine());
        System.out.println("Enter power:");
        int power = Integer.parseInt(System.console().readLine());
        
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        System.out.println(number + " raised to power " + power + " is: " + result);
    }
}