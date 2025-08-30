public class PrimeNumberCheck {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        boolean isPrime = number > 1;
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        System.out.println(number + (isPrime ? " is a Prime Number" : " is not a Prime Number"));
    }
}
