import java.util.Scanner;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] charCount = new int[256]; // Array to store frequency of characters

        // Count frequency of characters
        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i)]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            if (charCount[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0'; // No non-repeating character found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
