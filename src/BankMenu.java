import java.util.InputMismatchException;
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

                    exit = exitFromMenu();
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

        boolean validBalance = false;
        double accountBalance = 0;

        while (!validBalance) {
            System.out.println("Enter Initial Balance");
            try {
                accountBalance = scanner.nextDouble();
                validBalance = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input.Please try a numeric value for the amount");
                scanner.nextLine();
            }
        }

        boolean validAccountType = false;

        while (!validAccountType) {
            System.out.println("Is it Saving Account ? Press Y or N");
            char accountType = scanner.next().charAt(0);
            if (accountType == 'Y' || accountType == 'y') {
                validAccountType = true;
                System.out.println("Enter interest rate: ");
                double interestRate = scanner.nextDouble();
                bankSimulator.addAccount(new SavingsAccount(accountId, accountHolder, accountBalance, interestRate));
                System.out.println(bankSimulator.getAccount(accountId).getAccountInfo());

            } else if (accountType == 'N' || accountType == 'n') {
                validAccountType = true;
                bankSimulator.addAccount(new Account(accountId, accountHolder, accountBalance));
            } else {
                System.out.println("Error ! Try print only  Y or N");
            }
        }


    }

    private void deposite() {
        System.out.println("Enter Account ID:");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);

        boolean validDeposite = false;

        while (!validDeposite) {
            try {
                System.out.println("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
                validDeposite = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input.Please try a numeric value for the amount");
                scanner.nextLine();
            }
        }
    }


    private void withdraw() {
        System.out.println("Enter Account ID");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);

        boolean validWithdraw = false;
        while (!validWithdraw) {
            try {
                System.out.println("Enter the withdrawal amount");
                double withdrawalAmount = scanner.nextDouble();
                account.withDraw(withdrawalAmount);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input.Please try a numeric value for the amount");
                scanner.nextLine();
            }

        }


    }

    private void checkBalance() {
        System.out.println("Enter Account ID");
        String accountId = scanner.next();
        Account account = bankSimulator.getAccount(accountId);
        if (account != null) {
            System.out.println(account.getAccountInfo());
        } else {
            System.out.println("Account not found");
        }


    }

    private void removeAccount() {
        System.out.println("Enter account ID to remove:");
        String accountId = scanner.next();
        bankSimulator.removeAccount(accountId);
    }

    private boolean exitFromMenu() {
        System.out.println("Do you want exit ? Y or N");
        char confirm = scanner.next().charAt(0);
        if (confirm == 'Y' || confirm == 'y') {
            return false;
        }
        return true;
    }


}
