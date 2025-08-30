public class DigitCounter {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        int count = 0;
        
        while (number != 0) {
            number /= 10;
            count++;
        }
        
        System.out.println("Number of digits: " + count);
    }
}