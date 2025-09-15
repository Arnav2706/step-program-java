import java.util.*;

public class Problem3_PalindromeAnalyzer {

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    static int longestPalindromeLength(String text) {
        int max = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String sub = text.substring(i, j);
                if (isPalindrome(sub) && sub.length() > max)
                    max = sub.length();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        String[] words = text.split(" ");
        for (String w : words) {
            if (isPalindrome(w)) System.out.println("Palindrome Word: " + w);
        }
        System.out.println("Longest Palindrome Substring Length: " + longestPalindromeLength(text));
    }
}
