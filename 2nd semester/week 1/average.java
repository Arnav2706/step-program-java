public class average {
    public static void main(String[] args) {
        // Marks in individual subjects
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate the total and average marks
        int totalMarks = maths + physics + chemistry;
        double averageMarks = totalMarks / 3.0;

        // Output
        System.out.printf("Sam's average mark in PCM is %.2f", averageMarks);
    }
}
