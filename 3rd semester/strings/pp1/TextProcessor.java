import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] sentences = text.split("[.!?]");
        String[] words = text.split("\\s+");

        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (String w : words) {
            String clean = w.replaceAll("[^a-zA-Z]", "");
            if (clean.length() > longestWord.length()) longestWord = clean;
            for (char ch : clean.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (var entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentences.length);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\n--- Cleaned Text ---\n" + cleaned);

        System.out.println("\n--- Analysis ---");
        analyzeText(cleaned);

        System.out.println("\n--- Words Sorted ---");
        String[] sorted = getWordsSorted(cleaned);
        for (String word : sorted) System.out.println(word);

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine();
        boolean found = Arrays.stream(sorted)
                              .anyMatch(w -> w.equalsIgnoreCase(searchWord));
        System.out.println(found ? "Word found." : "Word not found.");

        scanner.close();
    }
}
