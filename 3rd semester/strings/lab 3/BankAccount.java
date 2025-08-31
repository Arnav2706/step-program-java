public class BankAccount {
    // Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    // Static variables
    private static int totalAccounts = 0;
    private static int accountCounter = 1;
    
    // Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }
    
    // Instance methods
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + " | New balance: $" + balance);
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds! Available: $" + balance);
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount + " | Remaining balance: $" + balance);
    }
    
    public void checkBalance() {
        System.out.println("Account Balance: $" + balance);
    }
    
    // Static methods
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static String generateAccountNumber() {
        return String.format("ACC%03d", accountCounter++);
    }
    
    public void displayAccountInfo() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║          ACCOUNT INFORMATION     ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ Account Number: " + accountNumber + "         ║");
        System.out.println("║ Account Holder: " + accountHolderName + "     ║");
        System.out.println("║ Balance: $" + String.format("%.2f", balance) + "              ║");
        System.out.println("╚══════════════════════════════════╝");
    }
    
    public static void main(String[] args) {
        // Create array of BankAccount objects
        BankAccount[] accounts = new BankAccount[3];
        
        // Create multiple accounts
        accounts[0] = new BankAccount("Alice Johnson", 1000.0);
        accounts[1] = new BankAccount("Bob Smith", 2500.0);
        accounts[2] = new BankAccount("Carol Davis", 500.0);
        
        System.out.println("=== INITIAL ACCOUNT CREATION ===");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }
        
        // Demonstrate transactions
        System.out.println("\n=== TRANSACTIONS ===");
        accounts[0].deposit(200.0);
        accounts[0].withdraw(150.0);
        accounts[1].withdraw(3000.0); // Should fail - insufficient funds
        accounts[2].deposit(-100.0);  // Should fail - negative amount
        
        // Show static vs instance variables
        System.out.println("\n=== STATIC VS INSTANCE VARIABLES ===");
        System.out.println("Total Accounts (Static): " + BankAccount.getTotalAccounts());
        
        for (BankAccount account : accounts) {
            System.out.println("Account " + account.accountNumber + " balance (Instance): $" + account.balance);
        }
        
        // Final account information
        System.out.println("\n=== FINAL ACCOUNT STATUS ===");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }
    }
}