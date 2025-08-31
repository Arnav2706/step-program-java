import java.util.*;

public class Problem6_TextFormatter {

    // Split words manually
    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }

    // Justify text
    public static List<String> justifyText(List<String> words, int width) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int lineLen = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && lineLen + 1 + words.get(j).length() <= width) {
                lineLen += 1 + words.get(j).length();
                j++;
            }

            int spaces = width - lineLen;
            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            if (j == words.size() || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int extra = spaces / gaps, remainder = spaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) {
                        for (int s = 0; s <= extra + (k - i < remainder ? 1 : 0); s++)
                            line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }
        return result;
    }

    // Center align
    public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (sb.length() + w.length() + 1 > width) {
                String line = sb.toString().trim();
                int padding = (width - line.length()) / 2;
                lines.add(" ".repeat(padding) + line);
                sb.setLength(0);
            }
            sb.append(w).append(" ");
        }
        if (sb.length() > 0) {
            String line = sb.toString().trim();
            int padding = (width - line.length()) / 2;
            lines.add(" ".repeat(padding) + line);
        }
        return lines;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to format:");
        String text = sc.nextLine();
        System.out.println("Enter line width:");
        int width = sc.nextInt();

        List<String> words = splitWords(text);

        long t1 = System.nanoTime();
        List<String> justified = justifyText(words, width);
        long t2 = System.nanoTime();
        List<String> centered = centerAlign(words, width);
        long t3 = System.nanoTime();

        System.out.println("\n--- Original Text ---");
        System.out.println(text);

        System.out.println("\n--- Justified Text ---");
        int lineNo = 1;
        for (String line : justified)
            System.out.println(lineNo++ + ": " + line + " (" + line.length() + ")");

        System.out.println("\n--- Center Aligned Text ---");
        lineNo = 1;
        for (String line : centered)
            System.out.println(lineNo++ + ": " + line + " (" + line.length() + ")");

        System.out.println("\n--- Performance Analysis ---");
        System.out.println("Justify Time: " + (t2 - t1) + " ns");
        System.out.println("Center Time: " + (t3 - t2) + " ns");

        sc.close();
    }
}
