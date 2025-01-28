import java.util.ArrayList;

public class User {
    private String login; // Login
    private String password; // Password
    private boolean typeUser; //Default user - False, Admin - True
    private ArrayList<Account> AccounList;

    public User(String login, String password, boolean typeUser) {
        this.login = login;
        this.password = password;
        this.typeUser = typeUser;
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

    public boolean isTypeUser() {
        return typeUser;
    }

    public void setTypeUser(boolean typeUser) {
        this.typeUser = typeUser;
    }

    public ArrayList<Account> getAccounList() {
        return AccounList;
    }

    public void setAccounList(ArrayList<Account> accounList) {
        AccounList = accounList;
    }

    

    
}
