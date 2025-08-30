public class EmployeeBonus {
    public static void main(String[] args) {
        System.out.println("Enter salary:");
        double salary = Double.parseDouble(System.console().readLine());
        System.out.println("Enter years of service:");
        int years = Integer.parseInt(System.console().readLine());
        
        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus");
        }
    }
}