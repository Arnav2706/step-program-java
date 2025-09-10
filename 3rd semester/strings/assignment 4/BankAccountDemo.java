import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // 1. Default constructor
    public BankAccount() {
        this("Unknown", 0.0);
    }

    // 2. Constructor with name
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(9000) + 1000;
        this.balance = 0.0;
    }

    // 3. Constructor with name and balance
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(9000) + 1000;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayAccount() {
        System.out.println("AccountHolder: " + accountHolder + 
                           ", AccNo: " + accountNumber + 
                           ", Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000);

        a2.deposit(2000);
        a3.withdraw(1000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
