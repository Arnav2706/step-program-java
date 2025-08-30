import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) return "Tie";

        if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
            return "User Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void playGame(int rounds) {
        int userWins = 0, computerWins = 0, ties = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String userChoice = scanner.nextLine();
            String computerChoice = getComputerChoice();
            String result = determineWinner(userChoice, computerChoice);

            System.out.println("Computer chose: " + computerChoice);
            System.out.println("Result: " + result);

            if (result.equals("User Wins")) userWins++;
            else if (result.equals("Computer Wins")) computerWins++;
            else ties++;
        }

        System.out.println("\nFinal Stats:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
        System.out.println("User Win Percentage: " + (100.0 * userWins / rounds) + "%");
        System.out.println("Computer Win Percentage: " + (100.0 * computerWins / rounds) + "%");

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rounds: ");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        playGame(rounds);
        scanner.close();
    }
}
