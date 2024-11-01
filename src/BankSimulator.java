import java.util.ArrayList;

public class BankSimulator {

    private ArrayList<Account> bankAccountBase;

    public BankSimulator() {
        bankAccountBase = new ArrayList<>();
    }

    public void addAccount(Account account) {
        bankAccountBase.add(account);
    }


    public Account getAccount(String accountId) {
        for (Account account : bankAccountBase) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        System.out.println("Account not found");
        return null;
    }

    public void removeAccount(String accountId) {
        boolean removed = bankAccountBase.removeIf(account -> account.getAccountId().equals(accountId));
        if (removed) {
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found");
        }
    }

    public void printAllAccounts() {
        if (bankAccountBase.isEmpty()) {
            System.out.println("No accounts available");
        } else {
            for (Account account : bankAccountBase) {
                System.out.println(account.getAccountInfo());
                System.out.println("---------------------------------");
            }
        }


    }

}
