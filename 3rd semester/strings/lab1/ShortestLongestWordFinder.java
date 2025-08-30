import java.util.Scanner;

public class ShortestLongestWordFinder {

    // Step c: Find string length without length() method
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Stop when out of bounds
        }
        return count;
    }

    // Step b: Split string into words without split()
    public static String[] manualSplit(String str) {
        int len = findLength(str);

        // Count words based on spaces
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        int start = 0, index = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[index++] = str.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = str.substring(start, len); // last word

        return words;
    }

    // Step d: Create 2D array with words and their lengths
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Step e: Find shortest and longest word indexes
    public static int[] findShortestLongest(String[][] wordLengthArray) {
        int minIndex = 0, maxIndex = 0;
        int minLength = Integer.parseInt(wordLengthArray[0][1]);
        int maxLength = minLength;

        for (int i = 1; i < wordLengthArray.length; i++) {
            int length = Integer.parseInt(wordLengthArray[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Step b & d: Get words and their lengths
        String[] words = manualSplit(input);
        String[][] wordTable = getWordsWithLengths(words);

        // Step e: Find shortest and longest
        int[] indexes = findShortestLongest(wordTable);

        // Step f: Display table
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] row : wordTable) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }

        System.out.println("\nShortest word: " + wordTable[indexes[0]][0] +
                           " (" + wordTable[indexes[0]][1] + ")");
        System.out.println("Longest word: " + wordTable[indexes[1]][0] +
                           " (" + wordTable[indexes[1]][1] + ")");

        sc.close();
    }
}
