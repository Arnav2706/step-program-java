import java.util.Scanner;

public class SplitWords {
    public static String[] splitText(String text) {
        int count = 0;
        int[] spaceIndexes = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[count++] = i;
            }
        }

        String[] words = new String[count + 1];
        int start = 0;
        for (int i = 0; i < count; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[count] = text.substring(start);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] words = splitText(input);
        for (String word : words) {
            System.out.println(word);
        }
        scanner.close();
    }
}
