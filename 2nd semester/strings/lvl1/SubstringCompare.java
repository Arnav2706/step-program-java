import java.util.Scanner;

public class SubstringCompare {
    public static String substringUsingCharAt(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.next();
        System.out.println("Enter the start index:");
        int start = sc.nextInt();
        System.out.println("Enter the end index:");
        int end = sc.nextInt();

        String customSub = substringUsingCharAt(input, start, end);
        String builtInSub = input.substring(start, end);

        boolean isEqual = compareUsingCharAt(customSub, builtInSub);

        System.out.println("Custom substring: " + customSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Both substrings are equal: " + isEqual);
    }
}
