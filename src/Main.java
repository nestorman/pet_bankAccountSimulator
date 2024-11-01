public class Main {
    public static void main(String[] args) {

        BankMenu bankMenu = new BankMenu();
        bankMenu.showMenu();
    }

    /*

    import java.util.Scanner;

public class BankMenu {

    private BankSimulator bankSimulator;
    private Scanner scanner;

    public BankMenu() {
        bankSimulator = new BankSimulator();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Print All Accounts");
            System.out.println("6. Remove Account");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> bankSimulator.printAllAccounts();
                case 6 -> removeAccount();
                case 7 -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addAccount() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter account holder's name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Is this a Savings Account (y/n)? ");
        char accountType = scanner.next().charAt(0);

        if (accountType == 'y' || accountType == 'Y') {
            System.out.print("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            bankSimulator.addAccount(new SavingsAccount(accountId, accountHolder, balance, interestRate));
        } else {
            bankSimulator.addAccount(new Account(accountId, accountHolder, balance));
        }
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private void withdraw() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withDraw(amount);
        }
    }

    private void checkBalance() {
        System.out.print("Enter account ID: ");
        String accountId = scanner.nextLine();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.printf("Account balance: %.2f $%n", account.getAccountBalance());
        }
    }

    private void removeAccount() {
        System.out.print("Enter account ID to remove: ");
        String accountId = scanner.nextLine();
        bankSimulator.removeAccount(accountId);
    }
}

     */
}