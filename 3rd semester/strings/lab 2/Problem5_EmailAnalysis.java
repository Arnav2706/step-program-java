import java.util.*;

public class Problem5_EmailAnalysis {

    public static boolean validateEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.indexOf('.', at);
        return at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1;
    }

    public static String[] extractParts(String email) {
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = email.substring(at + 1, dot);
        String extension = email.substring(dot + 1);
        return new String[]{username, domain, domainName, extension};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of emails:");
        int n = Integer.parseInt(sc.nextLine());
        String[] emails = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter email " + (i + 1) + ":");
            emails[i] = sc.nextLine();
        }

        int validCount = 0, invalidCount = 0;
        Map<String, Integer> domainCount = new HashMap<>();
        int totalUsernameLength = 0;

        System.out.printf("\n%-25s %-15s %-20s %-15s %-10s %-10s\n",
                "Email", "Username", "Domain", "DomainName", "Extension", "Valid?");

        for (String email : emails) {
            if (validateEmail(email)) {
                validCount++;
                String[] parts = extractParts(email);
                totalUsernameLength += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);

                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        email, parts[0], parts[1], parts[2], parts[3], "Yes");
            } else {
                invalidCount++;
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        email, "-", "-", "-", "-", "No");
            }
        }

        String mostCommonDomain = domainCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("None");
        double avgUsernameLen = validCount > 0 ? (double) totalUsernameLength / validCount : 0;

        System.out.println("\n--- Statistics ---");
        System.out.println("Valid emails: " + validCount);
        System.out.println("Invalid emails: " + invalidCount);
        System.out.println("Most common domain: " + mostCommonDomain);
        System.out.println("Average username length: " + avgUsernameLen);

        sc.close();
    }
}
