public class HarshadNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        int sum = 0, temp = number;
        
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
    }
}