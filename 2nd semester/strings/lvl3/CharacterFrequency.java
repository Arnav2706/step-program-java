import java.util.Scanner;

public class CharacterFrequency {
    public static int[] findFrequency(String text) {
        int[] charCount = new int[256]; // Array to store frequency of characters

        // Count frequency of characters
        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i)]++;
        }

        return charCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        int[] frequencies = findFrequency(text);

        System.out.println("Character Frequencies:");
        for (int i = 0; i < 256; i++) {
            if (frequencies[i] > 0) {
                System.out.println((char) i + " -> " + frequencies[i]);
            }
        }
    }
}
5.
import java.util.Scanner;

public class UniqueCharacterFrequency {
    public static char[] findUniqueCharacters(String text) {
        char[] uniqueChars = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueChars[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueChars[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        return uniqueChars;
    }

    public static int[] findFrequency(String text, char[] uniqueChars) {
        int[] charCount = new int[uniqueChars.length];

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < uniqueChars.length; j++) {
                if (uniqueChars[j] == text.charAt(i)) {
                    charCount[j]++;
                }
            }
        }

        return charCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);
        int[] frequencies = findFrequency(text, uniqueChars);

        System.out.println("Unique Character Frequencies:");
        for (int i = 0; i < uniqueChars.length; i++) {
            if (uniqueChars[i] != '\0') {
                System.out.println(uniqueChars[i] + " -> " + frequencies[i]);
            }
        }
    }
}
