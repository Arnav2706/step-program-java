import java.util.Scanner;

public class CharArrayCompare {
    public static char[] getChars(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        return result;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.next();

        char[] userArray = getChars(input);
        char[] builtInArray = input.toCharArray();

        boolean isEqual = compareArrays(userArray, builtInArray);

        System.out.println("User-defined char array: " + new String(userArray));
        System.out.println("Built-in toCharArray(): " + new String(builtInArray));
        System.out.println("Both arrays are equal: " + isEqual);
    }
}
