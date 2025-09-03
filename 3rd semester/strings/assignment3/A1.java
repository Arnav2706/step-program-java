class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    static int totalAccounts = 0;
    static String bankName = "NA";

    PersonalAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    static void setBankName(String name) {
        bankName = name;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    static String generateAccountNumber() {
        return "AC" + System.nanoTime() % 1000000;
    }

    void addIncome(double amount, String description) {
        currentBalance += amount;
        totalIncome += amount;
    }

    void addExpense(double amount, String description) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
        }
    }

    double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    void displayAccountSummary() {
        System.out.println("\nBank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
    }
}

public class A1 {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Alpha Bank");

        PersonalAccount p1 = new PersonalAccount("Ava");
        PersonalAccount p2 = new PersonalAccount("Ben");
        PersonalAccount p3 = new PersonalAccount("Cara");

        p1.addIncome(1000, "Salary");
        p1.addExpense(200, "Food");

        p2.addIncome(1500, "Salary");
        p2.addExpense(400, "Rent");

        p3.addIncome(800, "Part-time");
        p3.addExpense(100, "Travel");

        p1.displayAccountSummary();
        p2.displayAccountSummary();
        p3.displayAccountSummary();

        System.out.println("\nTotal Accounts: " + PersonalAccount.getTotalAccounts());

        PersonalAccount.setBankName("Beta Bank");

        p1.displayAccountSummary();
        p2.displayAccountSummary();
        p3.displayAccountSummary();
    }
}
