import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);
        int choice;

        System.out.println("===== WELCOME TO ATM =====");

        do {

            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.printf(
                            "Current Balance: ₹%.2f%n",
                            account.getBalance()
                    );
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();

                    if (account.deposit(deposit)) {
                        System.out.printf(
                                "₹%.2f deposited successfully.%n",
                                deposit
                        );
                        System.out.printf(
                                "New Balance: ₹%.2f%n",
                                account.getBalance()
                        );
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = sc.nextDouble();

                    if (account.withdraw(withdraw)) {
                        System.out.printf(
                                "₹%.2f withdrawn successfully.%n",
                                withdraw
                        );
                        System.out.printf(
                                "Remaining Balance: ₹%.2f%n",
                                account.getBalance()
                        );
                    } else {
                        System.out.println(
                                "Transaction failed. Insufficient balance or invalid amount."
                        );
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}