import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BASIC BANKING SYSTEM =====");

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter Interest Rate (%): ");
        double interestRate = sc.nextDouble();

        SavingsAccount account = new SavingsAccount(
            accountNumber,
            accountHolder,
            balance,
            interestRate
        );

        int choice;

        do {
            System.out.println("\n===== BANKING MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Add Interest");
            System.out.println("6. Account Information");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        account.displayBalance();
                        break;

                    case 4:
                        account.displayTransactionHistory();
                        break;

                    case 5:
                        account.addInterest();
                        break;

                    case 6:
                        account.displayBalance();
                        account.displayAccountType();
                        break;

                    case 7:
                        System.out.println("Thank you for using the Banking System!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);

        sc.close();
    }
}