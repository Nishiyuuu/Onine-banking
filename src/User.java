import java.util.ArrayList;
import java.util.List;

public class User {    
    private String login;
    private String password;
    private List<Account> accounts;
    private boolean isAdmin;

    public User(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
