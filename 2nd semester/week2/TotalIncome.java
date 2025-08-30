class TotalIncome {
    public static void main(String[] args) {
        System.out.println("Enter salary:");
        float salary = Float.parseFloat(System.console().readLine());
        System.out.println("Enter bonus:");
        float bonus = Float.parseFloat(System.console().readLine());
        // Compute total income
        float totalIncome = salary + bonus;
        // Display result
        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + 
                           ". Hence Total Income is INR " + totalIncome);
    }
}
