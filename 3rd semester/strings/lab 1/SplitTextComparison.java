import java.util.Scanner;

public class SplitTextComparison {

    // Step b: Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Access each char until exception
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exit loop when out of bounds
        }
        return count;
    }

    // Step c: Manual split method using charAt()
    public static String[] manualSplit(String str) {
        int len = findLength(str);

        // Step c.i: Count words and store space indexes
        int wordCount = 1; // At least one word
        int[] spaceIndexes = new int[len]; // Store indexes of spaces
        int spaceIndexCount = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[spaceIndexCount++] = i;
                wordCount++;
            }
        }

        // Step c.ii: Extract words based on space indexes
        String[] words = new String[wordCount];
        int start = 0;
        int wordPos = 0;

        for (int i = 0; i < spaceIndexCount; i++) {
            int end = spaceIndexes[i];
            words[wordPos++] = str.substring(start, end);
            start = end + 1; // Skip space
        }
        // Last word
        words[wordPos] = str.substring(start, len);

        return words;
    }

    // Step d: Compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take user input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Step e: Call user-defined and built-in split()
        String[] manualResult = manualSplit(input);
        String[] builtinResult = input.split(" ");

        // Compare both
        boolean isSame = compareArrays(manualResult, builtinResult);

        // Display results
        System.out.println("\nManual Split Result:");
        for (String word : manualResult) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtinResult) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + isSame);

        sc.close();
    }
}
