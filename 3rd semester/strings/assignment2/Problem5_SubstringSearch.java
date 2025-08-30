import java.util.*;

public class Problem5_SubstringSearch {

    static int search(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            while (j < pattern.length() && text.charAt(i + j) == pattern.charAt(j)) j++;
            if (j == pattern.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main text: ");
        String text = sc.nextLine();
        System.out.println("Enter substring to search: ");
        String pattern = sc.nextLine();

        int index = search(text, pattern);
        if (index != -1) System.out.println("Substring found at index: " + index);
        else System.out.println("Substring not found");
    }
}
