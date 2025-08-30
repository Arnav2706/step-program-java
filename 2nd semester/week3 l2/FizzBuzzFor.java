public class FizzBuzzFor {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}