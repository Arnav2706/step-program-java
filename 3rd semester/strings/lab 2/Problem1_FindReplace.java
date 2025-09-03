  import java.util.Scanner;

public class Problem1_FindReplace {

    // Method to find all occurrences of substring
    public static int[] findOccurrences(String text, String find) {
        int index = text.indexOf(find);
        int count = 0;

        while (index != -1) {
            count++;
            index = text.indexOf(find, index + 1);
        }

        int[] positions = new int[count];
        index = text.indexOf(find);
        int i = 0;
        while (index != -1) {
            positions[i++] = index;
            index = text.indexOf(find, index + 1);
        }
        return positions;
    }

    // Manual replacement
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() &&
                text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareResults(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text = sc.nextLine();
        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();
        System.out.println("Enter the replacement substring:");
        String replace = sc.nextLine();

        int[] positions = findOccurrences(text, find);
        String manualResult = manualReplace(text, find, replace);
        String builtinResult = text.replace(find, replace);

        System.out.println("\n--- Results ---");
        System.out.print("Occurrences at positions: ");
        for (int pos : positions) System.out.print(pos + " ");
        System.out.println("\nManual Replace Result: " + manualResult);
        System.out.println("Built-in Replace Result: " + builtinResult);
        System.out.println("Comparison: " + compareResults(manualResult, builtinResult));

        sc.close();
    }
}
