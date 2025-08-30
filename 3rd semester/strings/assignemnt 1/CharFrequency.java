import java.util.Scanner;

public class CharFrequency {
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        boolean[] visited = new boolean[256];
        String[][] result = new String[text.length()][2];
        int idx = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!visited[c]) {
                visited[c] = true;
                result[idx][0] = String.valueOf(c);
                result[idx][1] = String.valueOf(freq[c]);
                idx++;
            }
        }
        String[][] finalResult = new String[idx][2];
        for (int i = 0; i < idx; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String[][] freqData = findFrequency(input);
        System.out.println("Character | Frequency");
        for (String[] row : freqData) {
            System.out.println(row[0] + "         | " + row[1]);
        }
        sc.close();
    }
}
