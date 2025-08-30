import java.util.Scanner;

public class HandshakeCalculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Calculate maximum handshakes using the formula
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display result
        System.out.println("Maximum number of possible handshakes: " + maxHandshakes);

        scanner.close();
    }
}
