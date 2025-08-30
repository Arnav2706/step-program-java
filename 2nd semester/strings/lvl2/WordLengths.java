import java.util.Scanner;

public class WordLengths {
    public static String[][] getWordLengths(String text) {
        String[] words = splitText(text);
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[][] wordData = getWordLengths(input);
        System.out.println("Word\tLength");
        for (String[] entry : wordData) {
            System.out.println(entry[0] + "\t" + entry[1]);
        }
        scanner.close();
    }
}
