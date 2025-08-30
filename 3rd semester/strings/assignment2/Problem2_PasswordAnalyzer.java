import java.util.*;

public class Problem2_PasswordAnalyzer {

    static boolean hasUpper(String s) {
        for (char c : s.toCharArray()) if (Character.isUpperCase(c)) return true;
        return false;
    }

    static boolean hasLower(String s) {
        for (char c : s.toCharArray()) if (Character.isLowerCase(c)) return true;
        return false;
    }

    static boolean hasDigit(String s) {
        for (char c : s.toCharArray()) if (Character.isDigit(c)) return true;
        return false;
    }

    static boolean hasSpecial(String s) {
        for (char c : s.toCharArray()) if (!Character.isLetterOrDigit(c)) return true;
        return false;
    }

    static String analyze(String pw) {
        int score = 0;
        if (pw.length() >= 8) score++;
        if (hasUpper(pw)) score++;
        if (hasLower(pw)) score++;
        if (hasDigit(pw)) score++;
        if (hasSpecial(pw)) score++;

        if (score <= 2) return "Weak";
        if (score == 3 || score == 4) return "Moderate";
        return "Strong";
    }

    static String generatePassword(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String pw = sc.nextLine();
        System.out.println("Strength: " + analyze(pw));

        System.out.println("Do you want a strong password suggestion? (yes/no)");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            System.out.println("Suggested Password: " + generatePassword(12));
        }
    }
}
