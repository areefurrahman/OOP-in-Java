public class AssignmentBankaccount {
    
    private int accountId;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private double[] transactions;

    public Bankaccount() {
        this.accountId = 0;
        this.accountHolderName = "";
        this.balance = 0.0;
        this.accountType = "";
        this.transactions = new double[5];
    }

    public Bankaccount(int accountId, String accountHolderName, double balance, String accountType) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        setBalance(balance);
        setAccountType(accountType);
        this.transactions = new double[5]; 
    }

    public Bankaccount(Bankaccount other) {
        this.accountId = other.accountId;
        this.accountHolderName = other.accountHolderName;
        this.balance = other.balance;
        this.accountType = other.accountType;
        this.transactions = new double[5];
        System.arraycopy(other.transactions, 0, this.transactions, 0, other.transactions.length);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        if (accountType.equals("Savings") || accountType.equals("Checking")) {
            this.accountType = accountType;
        } else {
            System.out.println("Invalid account type. Use 'Savings' or 'Checking'.");
        }
    }

    // Transaction Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction(-amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    private void addTransaction(double amount) {
        for (int i = 1; i < transactions.length; i++) {
            transactions[i - 1] = transactions[i];
        }
        transactions[transactions.length - 1] = amount;
    }

    public Bankaccount copy() {
        return new Bankaccount(this);
    }

    public static Bankaccount findHighestBalance(Bankaccount[] accounts) {
        if (accounts == null || accounts.length == 0) {
            return null;
        }
        Bankaccount highest = accounts[0];
        for (Bankaccount account : accounts) {
            if (account.getBalance() > highest.getBalance()) {
                highest = account;
            }
        }
        return highest;
    }

    public void displayAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.print("Last 5 Transactions: ");
        for (double transaction : transactions) {
            System.out.print(transaction + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Bankaccount account1 = new Bankaccount(1, "Alice", 1000, "Savings");
        account1.deposit(500);
        account1.withdraw(200);
        account1.displayAccountDetails();

        Bankaccount account2 = account1.copy();
        account2.setAccountHolderName("Bob");
        account2.deposit(300);
        account2.displayAccountDetails();

        System.out.println("Are the two accounts equal? " + (account1 == account2));

        Bankaccount[] accounts = {
            account1,
            account2,
            new Bankaccount(3, "Ramzan", 2000, "Checking"),
            new Bankaccount(4, "Umar", 1500, "Savings")
        };

        Bankaccount highest = Bankaccount.findHighestBalance(accounts);
        System.out.println("Account with highest balance:");
        highest.displayAccountDetails();
    }
}
