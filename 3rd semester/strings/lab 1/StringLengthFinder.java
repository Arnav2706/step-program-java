
import java.util.Scanner;

public class StringLengthFinder {

    // Method to find length without using length() method
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) { // infinite loop until exception
                str.charAt(count); // will throw StringIndexOutOfBoundsException when count is too big
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception ends loop
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take user input
        System.out.print("Enter a string: ");
        String input = sc.next(); // next() takes word until space

        // Step b & c: Call user-defined method and built-in length()
        int customLength = findLength(input);
        int builtinLength = input.length();

        // Display results
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtinLength);

        sc.close();
    }
}
