import java.util.Scanner;

public class ATMInterface {
    public static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true; // Withdrawal successful
            } else {
                return false; // Insufficient funds
            }
        }

        public double checkBalance() {
            return balance;
        }
    }

    public static class ATM {
        private BankAccount bankAccount;
        private Scanner scanner;

        public ATM(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
            this.scanner = new Scanner(System.in);
        }

        public void displayOptions() {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
        }

        public void run() {
            while (true) {
                displayOptions();
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        if (withdrawAmount > 0) {
                            if (bankAccount.withdraw(withdrawAmount)) {
                                System.out.println("Withdrawn $" + withdrawAmount);
                            } else {
                                System.out.println("Insufficient funds");
                            }
                        } else {
                            System.out.println("Invalid amount");
                        }
                        break;
                    case "2":
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        if (depositAmount > 0) {
                            bankAccount.deposit(depositAmount);
                            System.out.println("Deposited $" + depositAmount);
                        } else {
                            System.out.println("Invalid amount");
                        }
                        break;
                    case "3":
                        System.out.println("Current balance: $" + bankAccount.checkBalance());
                        break;
                    case "4":
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}
