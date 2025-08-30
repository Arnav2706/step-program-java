import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) - 10; // Generates random ages including possible negatives
        }
        return ages;
    }

    public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "Cannot Vote (Invalid Age)";
            } else {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = ages[i] >= 18 ? "Can Vote" : "Cannot Vote";
            }
        }
        return result;
    }

    public static void displayResults(String[][] data) {
        System.out.println("Age\tEligibility");
        for (String[] entry : data) {
            System.out.println(entry[0] + "\t" + entry[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = generateAges(n);
        String[][] results = checkVoting(ages);

        displayResults(results);
        scanner.close();
    }
}
