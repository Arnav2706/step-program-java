import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text) {
        // This will throw an exception if index is out of bounds
        System.out.println("Character at index 100: " + text.charAt(100));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Character at index 100: " + text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e);
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
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }

        // Safe call with handling
        handleException(input);
    }
}
