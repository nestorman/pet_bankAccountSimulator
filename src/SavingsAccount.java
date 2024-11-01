public class SavingsAccount extends Account {

    private double interestRate;

    SavingsAccount(String accountID, String accountHolder, double balance, double interestRate) {
        super(accountID, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (isCorrectDeposit(amount)) {
            double interest = calculateInterest(amount);
            System.out.println(amount + " $ have been credited successfully !");
            increaseBalance(amount + interest);
            System.out.println(interest + " $ interest earned on deposit !");
            System.out.printf("Account Balance : %.2f $ %n", getAccountBalance());
        } else {
            System.out.println("Incorrect amount ! Please try another amount");
        }
    }


    private double calculateInterest(double amount) {
        return (amount * interestRate) / 100;
    }



}
