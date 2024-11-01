public class Account {

    private String accountId;
    private String accountHolder;
    private double accountBalance;

    Account(String accountId, String accountHolder, double accountBalance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        if (isCorrectDeposit(amount)) {
            System.out.println(amount + " $ have been credited successfully !");
            accountBalance += amount;
        } else {
            System.out.println("Incorrect amount ! Please try another amount !");
        }

    }

    public boolean isCorrectDeposit(double amount) {
        return amount > 0;
    }

    protected double increaseBalance(double amount) {
        return accountBalance += amount;
    }

    public boolean isCorrectWithDraw(double amount) {
        return accountBalance >= amount && amount > 0;
    }

    public void withDraw(double amount) {
        if (isCorrectWithDraw(amount)) {
            accountBalance -= amount;
            System.out.println(amount + " $ have been successfully withdrawn");
        } else {
            System.out.println("Insufficient funds to complete the transaction ! Please try a smaller amount");
        }

    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountId(){
        return accountId;
    }

    public String getAccountInfo() {
        return String.format("Account ID: %s\nAccount Holder: %s\nAccount Balance: %.2f $", accountId, accountHolder, accountBalance);
    }
}
