import java.util.List;

public abstract class Account {
    private final int numberAccount;
    private double balance;

    public Account(int numberAccount) {
        this.numberAccount = numberAccount;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws UserException {
        if(balance < amount) {
            throw new UserException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public List<Transaction> getTransactions() {
        return getTransactions();
    }

    public abstract String getAccountType();
}
