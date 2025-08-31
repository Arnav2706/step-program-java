import java.util.Scanner;

public class Problem4_CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void displayAscii(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i) + " -> " + (int) text.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encrypt:");
        String text = sc.nextLine();
        System.out.println("Enter shift value:");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nOriginal ASCII values:");
        displayAscii(text);
        System.out.println("\nEncrypted ASCII values:");
        displayAscii(encrypted);

        System.out.println("\nEncrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
        System.out.println("Decryption successful? " + text.equals(decrypted));

        sc.close();
    }
}
