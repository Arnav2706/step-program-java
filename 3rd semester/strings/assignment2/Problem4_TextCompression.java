import java.util.*;

public class Problem4_TextCompression {

    static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    static String decompress(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i + 1;
            String num = "";
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                num += s.charAt(j);
                j++;
            }
            int count = Integer.parseInt(num);
            for (int k = 0; k < count; k++) sb.append(c);
            i = j - 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();

        String comp = compress(s);
        System.out.println("Compressed: " + comp);
        System.out.println("Decompressed: " + decompress(comp));
    }
}
