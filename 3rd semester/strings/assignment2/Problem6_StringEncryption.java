import java.util.*;

public class Problem6_StringEncryption {

    static String caesarEncrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                sb.append((char)((c - base + shift) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    static String xorEncrypt(String text, char key) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append((char)(c ^ key));
        return sb.toString();
    }

    static String xorDecrypt(String text, char key) {
        return xorEncrypt(text, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Enter shift for Caesar Cipher: ");
        int shift = sc.nextInt();
        sc.nextLine(); // consume newline

        String enc = caesarEncrypt(text, shift);
        String dec = caesarDecrypt(enc, shift);
        System.out.println("Caesar Encrypted: " + enc);
        System.out.println("Caesar Decrypted: " + dec);

        System.out.println("Enter key character for XOR Cipher: ");
        char key = sc.nextLine().charAt(0);

        String xorEnc = xorEncrypt(text, key);
        String xorDec = xorDecrypt(xorEnc, key);
        System.out.println("XOR Encrypted: " + xorEnc);
        System.out.println("XOR Decrypted: " + xorDec);
    }
}
