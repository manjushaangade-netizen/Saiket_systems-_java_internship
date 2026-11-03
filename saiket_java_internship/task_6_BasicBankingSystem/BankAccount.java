import java.util.ArrayList;

public class BankAccount {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;

        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
        transactionHistory.add("Deposited: " + amount);

        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);

        System.out.println("Amount withdrawn successfully.");
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History ---");

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}