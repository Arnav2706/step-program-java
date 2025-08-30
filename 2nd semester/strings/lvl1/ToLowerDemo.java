import java.util.Scanner;

public class ToLowerDemo {

    public static String convertToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String userLower = convertToLower(input);
        String builtInLower = input.toLowerCase();

        System.out.println("User-defined Lower: " + userLower);
        System.out.println("Built-in Lower:     " + builtInLower);

        System.out.println("Are both equal? " + compareStrings(userLower, builtInLower));
    }
}
