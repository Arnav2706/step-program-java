import java.util.Scanner;

public class CharacterFrequencyNested {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        findFrequency(text);
    }

    public static void findFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') { // Skip duplicate tracking
                frequency[i] = 1;
                for (int j = i + 1; j < characters.length; j++) {
                    if (characters[i] == characters[j]) {
                        frequency[i]++;
                        characters[j] = '0'; // Mark duplicate to avoid counting again
                    }
                }
            }
        }

        System.out.println("Character Frequencies:");
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                System.out.println(characters[i] + " -> " + frequency[i]);
            }
        }
    }
}
