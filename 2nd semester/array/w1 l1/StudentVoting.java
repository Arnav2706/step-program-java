public class StudentVoting {
    public static void main(String[] args) {
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter age of student " + (i + 1) + ":");
            ages[i] = Integer.parseInt(System.console().readLine());
        }

        for (int i = 0; i < 10; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age");
            } else if (ages[i] >= 18) {
                System.out.println("The student with age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with age " + ages[i] + " cannot vote.");
            }
        }
    }
}
