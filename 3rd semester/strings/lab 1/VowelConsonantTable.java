import java.util.Scanner;

public class VowelConsonantTable {

    // Step a: Method to check if a character is a vowel, consonant, or not a letter
    public static String checkCharType(char ch) {
        // i. Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // ii. Check vowel, consonant, or not a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Step b: Find vowels/consonants for each char in string
    public static String[][] findCharTypes(String str) {
        String[][] result = new String[str.length()][2]; // 2D array

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);       // Store character as String
            result[i][1] = checkCharType(ch);        // Store type
        }
        return result;
    }

    // Step c: Display the 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        System.out.println("-------------------------");
        for (String[] row : table) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call methods
        String[][] charTypes = findCharTypes(input);
        displayTable(charTypes);

        sc.close();
    }
