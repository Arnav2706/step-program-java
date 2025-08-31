import java.util.Scanner;

public class Problem2_CaseConversion {

    public static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }

    public static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public static String toUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) sb.append(toUpper(text.charAt(i)));
        return sb.toString();
    }

    public static String toLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) sb.append(toLower(text.charAt(i)));
        return sb.toString();
    }

    public static String toTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                sb.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(c));
                    newWord = false;
                } else {
                    sb.append(toLower(c));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        String upper = toUpperCase(text);
        String lower = toLowerCase(text);
        String title = toTitleCase(text);

        System.out.println("\n--- Conversion Results ---");
        System.out.printf("%-15s %-30s\n", "Method", "Result");
        System.out.printf("%-15s %-30s\n", "Uppercase", upper);
        System.out.printf("%-15s %-30s\n", "Lowercase", lower);
        System.out.printf("%-15s %-30s\n", "Title Case", title);

        sc.close();
    }
}
