class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance = balance - amount;
        } else
            System.out.println("Insufficient balance");
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + " Account Holder: " + accountHolderName + "Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


class currentAccount extends BankAccount {
    private double overdraftLimit;

    public currentAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        if ((getBalance() > amount) && overdraftLimit < 100) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Withdrawal successful.  Remaining Balance: " + getBalance());
        } else
            System.out.println("Withdrawal failed. Overdraft limit exceeded.");
    }
}

public class Basic_task_2 {
    public static void main(String[] args) {

    }
}
