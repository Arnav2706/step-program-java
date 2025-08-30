public class VotingEligibility {
    public static void main(String[] args) {
        System.out.println("Enter age:");
        int age = Integer.parseInt(System.console().readLine());

        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
    }
}
