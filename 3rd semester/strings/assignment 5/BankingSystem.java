import java.time.LocalDateTime;
import java.util.*;

final class Transaction {
    private final String transactionId;
    private final LocalDateTime timestamp;
    private final double amount;
    private final String transactionType;
    private final String description;
    private final String fromAccount;
    private final String toAccount;
    private final Map<String,String> metadata;

    public Transaction(String transactionId, double amount, String type, String desc, String from, String to, Map<String,String> meta) {
        this.transactionId = transactionId;
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.transactionType = type;
        this.description = desc;
        this.fromAccount = from;
        this.toAccount = to;
        this.metadata = meta == null ? Map.of() : Map.copyOf(meta);
    }

    public final boolean isValid() { return amount >= 0; }
}

class BankAccount {
    private final String accountNumber;
    private final String accountType;
    private final LocalDateTime openDate;
    private double balance;
    private String accountStatus;
    private final String ownerId;
    private final List<Transaction> transactionHistory = new ArrayList<>();

    BankAccount(String accountNumber, String accountType, double initialBalance, String ownerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.openDate = LocalDateTime.now();
        this.balance = initialBalance;
        this.ownerId = ownerId;
        this.accountStatus = "ACTIVE";
    }

    double getInternalBalance() { return balance; } // package-private
    public String getPublicAccountInfo() { return "AC-" + accountNumber.substring(Math.max(0,accountNumber.length()-4)); }

    public boolean deposit(double amt) {
        if (amt <= 0) return false;
        balance += amt;
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), amt, "DEPOSIT", "", null, accountNumber, null));
        return true;
    }

    public boolean withdraw(double amt) {
        if (amt <= 0 || amt > balance) return false;
        balance -= amt;
        transactionHistory.add(new Transaction(UUID.randomUUID().toString(), amt, "WITHDRAW", "", accountNumber, null, null));
        return true;
    }
}

class BankTeller { private final String tellerId; BankTeller(String id){this.tellerId=id;} }
class AccountManager { private final String managerId; AccountManager(String id){this.managerId=id;} }
class Auditor { private final String auditorId; Auditor(String id){this.auditorId=id;} }

public final class BankingSystem {
    private static final Map<String,Object> accountRegistry = new HashMap<>();

    public static boolean processTransaction(Object transactionObj, Object staff) {
        if (!(transactionObj instanceof Transaction)) return false;
        // validate staff permissions (simplified)
        if (!(staff instanceof BankTeller) && !(staff instanceof AccountManager)) return false;
        Transaction t = (Transaction) transactionObj;
        return t.isValid();
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("ACC1001", "SAVINGS", 5000, "C100");
        a1.deposit(1000);
        System.out.println("Public info: " + a1.getPublicAccountInfo());
        Transaction tx = new Transaction(UUID.randomUUID().toString(), 200, "TRANSFER", "To friend", "ACC1001", "ACC2002", Map.of());
        System.out.println("Process tx by teller: " + BankingSystem.processTransaction(tx, new BankTeller("T1")));
    }
}
