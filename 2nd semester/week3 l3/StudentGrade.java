public class StudentGrade {
    public static void main(String[] args) {
        System.out.println("Enter marks for Physics:");
        int physics = Integer.parseInt(System.console().readLine());
        System.out.println("Enter marks for Chemistry:");
        int chemistry = Integer.parseInt(System.console().readLine());
        System.out.println("Enter marks for Maths:");
        int maths = Integer.parseInt(System.console().readLine());
        
        int total = physics + chemistry + maths;
        double percentage = total / 3.0;
        
        System.out.println("Average Marks: " + percentage + "%");
        
        if (percentage >= 80) {
            System.out.println("Grade: A (Level 4, above agency-normalized standards)");
        } else if (percentage >= 70) {
            System.out.println("Grade: B (Level 3, at agency-normalized standards)");
        } else if (percentage >= 60) {
            System.out.println("Grade: C (Level 2, below, but approaching agency-normalized standards)");
        } else if (percentage >= 50) {
            System.out.println("Grade: D (Level 1, well below agency-normalized standards)");
        } else if (percentage >= 40) {
            System.out.println("Grade: E (Level 1-, too below agency-normalized standards)");
        } else {
            System.out.println("Grade: R (Remedial standards)");
        }
    }
}