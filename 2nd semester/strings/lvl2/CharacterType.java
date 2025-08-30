import java.util.Scanner;

public class CharacterType {
    public static String getCharacterType(char c) {
        if (!Character.isLetter(c)) {
            return "Not a Letter";
        }
        return "aeiouAEIOU".indexOf(c) != -1 ? "Vowel" : "Consonant";
    }

    public static String[][] classifyCharacters(String str) {
        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = getCharacterType(str.charAt(i));
        }

        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        for (String[] entry : data) {
            System.out.println(entry[0] + "\t\t" + entry[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] classifiedData = classifyCharacters(input);
        displayTable(classifiedData);
        scanner.close();
    }
}
