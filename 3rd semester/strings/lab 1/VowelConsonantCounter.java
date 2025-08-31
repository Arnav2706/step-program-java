import java.util.Scanner;

public class VowelConsonantCounter {

    // Step a: Check if a character is a vowel, consonant, or not a letter
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // Add 32 to convert to lowercase
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Step b: Count vowels and consonants
    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String type = checkCharType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step c: Take input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Count vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // Display result
        System.out.println("Number of Vowels: " + counts[0]);
        System.out.println("Number of Consonants: " + counts[1]);

        sc.close();
    }
}
