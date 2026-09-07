/*
 * Encapsulation: bundling data (fields) with the methods that operate on it,
 * and restricting direct access to internal state (private fields + public getters/setters).
 */
public class Encapsulation {

    static class BankAccount {
        private double balance; // hidden from outside, cannot be modified directly

        public BankAccount(double initialBalance) {
            if (initialBalance < 0) throw new IllegalArgumentException("Balance cannot be negative");
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > balance) throw new IllegalStateException("Insufficient funds");
            balance -= amount;
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100.0);
        acc.deposit(50);
        acc.withdraw(30);
        System.out.println("Balance: " + acc.getBalance()); // 120.0
        // acc.balance = -500;  // NOT allowed - field is private, forces use of controlled methods
    }
}
