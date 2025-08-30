.import java.util.Scanner;

public class StringLength {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Will throw an exception when count exceeds the string length
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        
        System.out.println("Computed length: " + findLength(input));
        System.out.println("Built-in length: " + input.length());
        scanner.close();
    }
}

