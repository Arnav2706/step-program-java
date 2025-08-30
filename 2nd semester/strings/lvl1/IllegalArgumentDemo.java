import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        // This will throw an exception if start > end
        String sub = text.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    public static void handleException(String text) {
        try {
            String sub = text.substring(5, 2);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.next();

        // Unsafe call
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e);
        }

        // Safe call with handling
        handleException(input);
    }
}
