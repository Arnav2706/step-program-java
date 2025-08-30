import java.util.*;

public class Problem1_SpellChecker {

    // Split sentence manually into words
    static String[] splitWords(String sentence) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                if (start < i) {
                    words.add(sentence.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < sentence.length()) {
            words.add(sentence.substring(start));
        }
        return words.toArray(new String[0]);
    }

    // Calculate string distance (simple Levenshtein-like)
    static int stringDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[a.length()][b.length()];
    }

    // Find best match
    static String findClosest(String word, String[] dictionary) {
        String best = word;
        int minDist = Integer.MAX_VALUE;
        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                best = dictWord;
            }
        }
        return minDist <= 2 ? best : word; // Suggest only if close
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"hello", "world", "java", "string", "programming", "spell", "checker"};

        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = splitWords(sentence);

        System.out.printf("%-15s %-15s %-10s %-10s\n", "Word", "Suggestion", "Distance", "Status");
        for (String word : words) {
            String suggestion = findClosest(word, dictionary);
            int dist = stringDistance(word, suggestion);
            String status = suggestion.equals(word) ? "Correct" : "Misspelled";
            System.out.printf("%-15s %-15s %-10d %-10s\n", word, suggestion, dist, status);
        }
    }
}
