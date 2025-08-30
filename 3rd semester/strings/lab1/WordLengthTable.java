import java.util.Scanner;

public class WordLengthTable {

    // Step c: Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // access each char
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // stop when out of bounds
        }
        return count;
    }

    // Step b: Method to split text into words using charAt()
    public static String[] manualSplit(String str) {
        int len = findLength(str);

        // Count spaces → words
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        int start = 0;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[index++] = str.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = str.substring(start, len); // last word

        return words;
    }

    // Step d: Create 2D array with word and its length
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i]; // word
            result[i][1] = String.valueOf(findLength(words[i])); // length as String
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take user input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split and get lengths
        String[] words = manualSplit(input);
        String[][] wordTable = getWordsWithLengths(words);

        // Step e: Display table (convert length to int before printing)
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] row : wordTable) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }

        sc.close();
    }
}
