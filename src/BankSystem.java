import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<User> users;
    private ArrayList<Account> accounts;

    public BankSystem() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void registerUser(String login, String password, boolean isAdmin) {
        User user = new User(login, password, isAdmin);
        users.add(user);
    }

    public void loginUsers(String login, String password){
        for(User user : users){
            if(user.getLogin().equals(login) && user.validatePassword(password)){
                System.out.println("User logged in");
            } else {
                System.out.println("Invalid login or password");
            }
        }
    }

    public void createAccount(User user, String accountType) {
        Account account = null;
        if(accountType.equals("Savings")) {
            account = new SavingsAccount(accounts.size());
        } else if(accountType.equals("Checking")) {
            account = new CheckingAccount(accounts.size());
        }
        user.addAccount(account);
        accounts.add(account);
    }

    public void deposit(User user, String accountNumber, double amount) {
        Account account = null;
        for(Account acc : user.getAccounts()) {
            if(acc.getNumberAccount() == Integer.parseInt(accountNumber)) {
                account = acc;
                break;
            }
        }
        if(account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(User user, String accountNumber, double amount) {
        Account account = null;
        for(Account acc : user.getAccounts()) {
            if(acc.getNumberAccount() == Integer.parseInt(accountNumber)) {
                account = acc;
                break;
            }
        }
        if(account != null) {
            try {
                account.withdraw(amount);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void transfer(User sender, String fromAccount, String toAccount, double amount){
        Account accountSender = null;
        Account accountReceive = null;
        for(Account acc : sender.getAccounts()) {
            if(acc.getNumberAccount() == Integer.parseInt(fromAccount)) {
                accountSender = acc;
                break;
            }
        }
        for(User user : users){
            for(Account acc : user.getAccounts()){
                if(acc.getNumberAccount() == Integer.parseInt(toAccount)){
                    accountReceive = acc;
                    break;
                }
            }
        }
        if(accountSender != null && accountReceive != null) {
            try {
                accountSender.withdraw(amount);
                accountReceive.deposit(amount);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void viewTransactionHistory(User user, String accountNumber){
        Account account = null;
        for(Account acc : user.getAccounts()) {
            if(acc.getNumberAccount() == Integer.parseInt(accountNumber)) {
                account = acc;
                break;
            }
        }
        if(account != null) {
            for(Transaction transaction : account.getTransactions()) {
                transaction.getTransactionDetails();
            }
        }
    }

    public User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
    public void deleteUser(String login) {
        User userToDelete = null;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                userToDelete = user;
                break;
            }
        }
        if (userToDelete != null) {
            users.remove(userToDelete);
            for (Account account : userToDelete.getAccounts()) {
                accounts.remove(account);
            }
        }
    }
}