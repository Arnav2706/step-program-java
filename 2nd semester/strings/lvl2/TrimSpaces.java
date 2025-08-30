import java.util.Scanner;

public class TrimSpaces {
    public static int[] findStartEnd(String str) {
        int start = 0, end = str.length() - 1;

        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end > start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    public static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = scanner.nextLine();

        int[] bounds = findStartEnd(input);
        String trimmedByCharAt = substringUsingCharAt(input, bounds[0], bounds[1]);
        String builtInTrim = input.trim();

        System.out.println("Trimmed by charAt(): " + trimmedByCharAt);
        System.out.println("Built-in trim(): " + builtInTrim);
        System.out.println("Are they equal? " + compareStrings(trimmedByCharAt, builtInTrim));
        scanner.close();
    }
}
