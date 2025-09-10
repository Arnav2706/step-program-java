public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return isLocked ? 0.0 : balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            resetFailedAttempts();
            return true;
        }
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
            return true;
        }
        return false;
    }

    public boolean deposit(double amount, int pin) {
        if (validatePin(pin) && amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, int pin) {
        if (validatePin(pin) && amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(SecureBankAccount target, double amount, int pin) {
        if (withdraw(amount, pin)) {
            target.balance += amount;
            return true;
        }
        return false;
    }

    private void lockAccount() {
        isLocked = true;
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC1001", 1000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC2002", 500);

        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        System.out.println("Acc1 deposit: " + acc1.deposit(500, 1234));
        System.out.println("Acc1 withdraw: " + acc1.withdraw(200, 1234));
        System.out.println("Acc1 balance: " + acc1.getBalance());

        System.out.println("Acc1 transfer to Acc2: " + acc1.transfer(acc2, 300, 1234));
        System.out.println("Acc1 balance after transfer: " + acc1.getBalance());
        System.out.println("Acc2 balance after transfer: " + acc2.getBalance());

        System.out.println("Wrong PIN attempts:");
        acc1.withdraw(100, 1111);
        acc1.withdraw(100, 1111);
        acc1.withdraw(100, 1111);

        System.out.println("Account locked: " + acc1.isAccountLocked());
    }
}
