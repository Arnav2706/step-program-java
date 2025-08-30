import java.util.Random;

public class StudentScorecard {
    public static void main(String[] args) {
        int numStudents = 5; // Set number of students
        int[][] scores = generateScores(numStudents);
        double[][] metrics = computeMetrics(scores);
        String[] grades = assignGrades(metrics);

        displayScorecard(scores, metrics, grades);
    }

    // Generate random scores for Physics, Chemistry, and Math
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // PCM Scores

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(91) + 10; // Physics (10-100)
            scores[i][1] = rand.nextInt(91) + 10; // Chemistry (10-100)
            scores[i][2] = rand.nextInt(91) + 10; // Math (10-100)
        }
        return scores;
    }

    // Compute total, average, and percentage for each student
    public static double[][] computeMetrics(int[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Average, Percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = Math.round((total / 300.0) * 10000.0) / 100.0; // Rounded to 2 decimal places

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = percentage;
        }
        return results;
    }

    // Assign grades based on percentage
    public static String[] assignGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];

        for (int i = 0; i < metrics.length; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 90) {
                grades[i] = "A";
            } else if (percentage >= 80) {
                grades[i] = "B";
            } else if (percentage >= 70) {
                grades[i] = "C";
            } else if (percentage >= 60) {
                grades[i] = "D";
            } else if (percentage >= 50) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    // Display the scorecard with student details
    public static void displayScorecard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\t%s%n", 
                i + 1, scores[i][0], scores[i][1], scores[i][2],
                metrics[i][0], metrics[i][1], metrics[i][2], grades[i]);
        }
    }
}
