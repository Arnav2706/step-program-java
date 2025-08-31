public class BankAccount {
    // Static variables (shared across all instances)
    private static String bankName = "Default Bank";
    private static int totalAccounts = 0;
    private static double interestRate = 0.03; // 3%
    
    // Instance variables (unique to each object)
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++; // Increment static counter
    }
    
    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }
    
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
    
    // Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
    
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Annual Interest: $" + calculateInterest());
    }
    
    public static void main(String[] args) {
        // Set bank name and interest rate using static methods
        BankAccount.setBankName("Java National Bank");
        BankAccount.setInterestRate(0.045); // 4.5%
        
        // Create multiple BankAccount objects
        BankAccount account1 = new BankAccount("ACC001", "Alice Johnson", 1000.0);
        BankAccount account2 = new BankAccount("ACC002", "Bob Williams", 2500.0);
        BankAccount account3 = new BankAccount("ACC003", "Carol Davis", 500.0);
        
        // Show that static members are shared
        System.out.println("=== Bank Information (Shared) ===");
        BankAccount.displayBankInfo();
        System.out.println("Total accounts via account1: " + account1.getTotalAccounts());
        System.out.println("Total accounts via BankAccount class: " + BankAccount.getTotalAccounts());
        
        // Show that instance members are unique
        System.out.println("\n=== Account Information (Unique) ===");
        System.out.println("--- Account 1 ---");
        account1.displayAccountInfo();
        
        System.out.println("\n--- Account 2 ---");
        account2.displayAccountInfo();
        
        System.out.println("\n--- Account 3 ---");
        account3.displayAccountInfo();
        
        // Demonstrate calling static methods with and without objects
        System.out.println("\n=== Static Method Demonstration ===");
        // Calling static method without object (preferred way)
        BankAccount.displayBankInfo();
        
        // Calling static method with object (possible but not recommended)
        account1.displayBankInfo(); // Warning: should be called statically
        
        // Perform transactions
        System.out.println("\n=== Transactions ===");
        account1.deposit(200.0);
        account2.withdraw(300.0);
        account3.deposit(100.0);
        
        System.out.println("\n=== Updated Account Info ===");
        account1.displayAccountInfo();
        System.out.println();
        account2.displayAccountInfo();
    }
}