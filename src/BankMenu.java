import java.util.Scanner;

public class BankMenu {

    private BankSimulator bankSimulator;
    private Scanner scanner;
    private static final int ID_GENERATE_LENGTH = 5;

    BankMenu() {
        bankSimulator = new BankSimulator();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        boolean exit = true;
        while (exit) {
            System.out.println("#### Bank Menu ####");
            System.out.println("1. Add account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Print All Accounts");
            System.out.println("6. Remove Account");
            System.out.println("7. Exit");

            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    deposite();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    bankSimulator.printAllAccounts();
                    break;
                case 6:
                    removeAccount();
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");

            }
        }


    }


    private void addAccount() {
        System.out.println("Enter Account ID:");
        String accountId = scanner.next();
        System.out.println("Enter Account Holder");
        String accountHolder = scanner.next();
        System.out.println("Enter Initial Balance");
        double accountBalance = scanner.nextDouble();
        System.out.println("Is it Saving Account ? Press Y or N");
        char accountType = scanner.next().charAt(0);
        if (accountType == 'Y' || accountType == 'y') {
            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            bankSimulator.addAccount(new SavingsAccount(accountId, accountHolder, accountBalance, interestRate));
        } else {
            bankSimulator.addAccount(new Account(accountId, accountHolder, accountBalance));
        }

    }

    private void deposite() {
        System.out.println("Enter Account ID:");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.println("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Sorry but Account is not available");
        }
    }

    private void withdraw() {
        System.out.println("Enter Account ID");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.println("Enter the withdrawal amount");
            double withdrawalAmount = scanner.nextDouble();
            account.withDraw(withdrawalAmount);
        }

    }

    private void checkBalance() {
        System.out.println("Enter Account ID");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);
        if(account != null){
            account.getAccountInfo();
        }
        else {
            System.out.println("Account not found");
        }


    }

    private void removeAccount() {
        System.out.println("Enter account ID to remove:");
        String accountId = scanner.next();
        bankSimulator.removeAccount(accountId);
    }


}
