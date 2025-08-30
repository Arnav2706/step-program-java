import java.util.Scanner;

public class WordAnalysis {
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

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static String[] findShortestLongest(String[][] words) {
        String shortest = words[0][0], longest = words[0][0];

        for (String[] wordData : words) {
            if (Integer.parseInt(wordData[1]) < findLength(shortest)) {
                shortest = wordData[0];
            }
            if (Integer.parseInt(wordData[1]) > findLength(longest)) {
                longest = wordData[0];
            }
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[][] wordsData = wordLengths(splitText(input));
        String[] result = findShortestLongest(wordsData);

        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Longest Word: " + result[1]);
        scanner.close();
    }
}
